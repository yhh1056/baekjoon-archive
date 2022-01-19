package algorithm.file;

import algorithm.archive.GithubConfig;
import algorithm.archive.provider.BaekjoonProblem;
import algorithm.archive.provider.baekjoon.Baekjoon;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.reflections.Reflections;

public class DefaultBaekjoonMarkdownGenerator implements MarkdownGenerator<BaekjoonProblem> {
    private static final String PATH_NAME = "solved/baekjoon.md";
    private static final String HEADER = "## 백준";
    private static final String TABLE_HEAD = "|번호|제목|난이도|풀이|주소|\n|---|---|---|---|---|\n";

    private final GithubConfig githubConfig;

    public DefaultBaekjoonMarkdownGenerator(final GithubConfig githubConfig) {
        Objects.requireNonNull(githubConfig);
        this.githubConfig = githubConfig;
    }

    @Override
    public void generate() {
        Reflections reflections = new Reflections("");
        List<BaekjoonProblem> baekjoonProblems = getBaekjoonProblems(reflections, Baekjoon.class);
        Collections.sort(baekjoonProblems);
        write(baekjoonProblems);
    }

    private void write(final List<BaekjoonProblem> baekjoonProblems) {
        File file = new File(PATH_NAME);
        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write("\n".getBytes());
            stream.write(HEADER.getBytes());
            stream.write("\n".getBytes());
            stream.write(TABLE_HEAD.getBytes());
            for (BaekjoonProblem problem : baekjoonProblems) {
                stream.write(MessageFormat.format("|{0}|{1}|{2}|[풀이]({3})|{4}|",
                    String.valueOf(problem.getNumber()), problem.getName(), problem.getLevel(), problem.getLocation(), problem.getUrl()).getBytes());
                stream.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<BaekjoonProblem> getBaekjoonProblems(final Reflections reflections, final Class<Baekjoon> baekjoonClass) {
        List<BaekjoonProblem> problems = new ArrayList<>();
        for (Class<?> clazz : reflections.getTypesAnnotatedWith(baekjoonClass)) {
            for (Baekjoon annotation : clazz.getDeclaredAnnotationsByType(baekjoonClass)) {
                problems.add(BaekjoonProblem.builder()
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
