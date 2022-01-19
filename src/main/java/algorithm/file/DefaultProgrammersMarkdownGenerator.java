package algorithm.file;

import algorithm.archive.GithubConfig;
import algorithm.archive.provider.ProgrammersProblem;
import algorithm.archive.provider.programmers.Programmers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.reflections.Reflections;

public class DefaultProgrammersMarkdownGenerator implements MarkdownGenerator<ProgrammersProblem> {
    private static final String PATH_NAME = "solved/programmers.md";
    private static final String HEADER = "## 프로그래머스";
    private static final String TABLE_HEAD = "|번호|제목|난이도|풀이|주소|\n|---|---|---|---|---|\n";

    private final GithubConfig githubConfig;

    public DefaultProgrammersMarkdownGenerator(final GithubConfig githubConfig) {
        Objects.requireNonNull(githubConfig);
        this.githubConfig = githubConfig;
    }

    @Override
    public void generate() {
        Reflections reflections = new Reflections("");
        List<ProgrammersProblem> programmersProblems = getProgrammersProblems(reflections, Programmers.class);
        Collections.sort(programmersProblems);
        write(programmersProblems);
    }

    private void write(final List<ProgrammersProblem> programmersProblems) {
        File file = new File(PATH_NAME);
        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write("\n".getBytes());
            stream.write(HEADER.getBytes());
            stream.write("\n".getBytes());
            stream.write(TABLE_HEAD.getBytes());
            for (ProgrammersProblem problem : programmersProblems) {
                stream.write(MessageFormat.format("|{0}|{1}|{2}|[풀이]({3})|{4}|",
                    String.valueOf(problem.getNumber()), problem.getName(), problem.getLevel(), problem.getLocation(), problem.getUrl()).getBytes());
                stream.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<ProgrammersProblem> getProgrammersProblems(Reflections reflections, Class<Programmers> programmersClass) {
        List<ProgrammersProblem> problems = new ArrayList<>();
        for (Class<?> clazz : reflections.getTypesAnnotatedWith(programmersClass)) {
            for (Programmers annotation : clazz.getDeclaredAnnotationsByType(programmersClass)) {
                problems.add(ProgrammersProblem.builder()
                    .location(githubConfig.parse(clazz))
                    .level(annotation.level())
                    .name(annotation.name())
                    .number(annotation.number())
                    .url(annotation.url())
                    .build());
            }
        }
        return problems;
    }

}
