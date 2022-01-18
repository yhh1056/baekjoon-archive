package algorithm.archive;

import algorithm.archive.provider.BaekjoonProblem;
import algorithm.archive.provider.baekjoon.Baekjoon;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.reflections.Reflections;

public class MarkdownGenerator {
    private final GithubConfig githubConfig;

    public MarkdownGenerator(final GithubConfig githubConfig) {
        this.githubConfig = githubConfig;
    }

    public void generate() {
        Reflections reflections = new Reflections("");
        List<BaekjoonProblem> baekjoonProblems = getBaekjoonProblems(reflections, Baekjoon.class);
        Collections.sort(baekjoonProblems);
        write(baekjoonProblems);
    }

    private void write(final List<BaekjoonProblem> baekjoonProblems) {
        File file = new File("solved.md");
        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write("|번호|제목|난이도|풀이|주소|".getBytes());
            stream.write("\n".getBytes());
            stream.write("|---|---|---|---|---|".getBytes());
            stream.write("\n".getBytes());
            for (BaekjoonProblem problem : baekjoonProblems) {
                stream.write(MessageFormat.format("|{0}|{1}|{2}|[풀이]({3})|{4}|",
                    problem.getNumber(), problem.getName(), problem.getLevel(), problem.getLocation(), problem.getUrl()).getBytes());
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
                    .location(parse(clazz, clazz.getPackageName()))
                    .level(annotation.level())
                    .name(annotation.name())
                    .number(annotation.number())
                    .url(annotation.url())
                    .build());
            }
        }
        return problems;
    }

    private String parse(final Class<?> clazz, final String packageName) {
        return MessageFormat.format("https://github.com/{0}/{1}/blob/{2}/{3}/{4}.java",
            githubConfig.getUsername(),
            githubConfig.getRepositoryName(),
            githubConfig.getMainBranch(),
            packageName.replace(".", "/"),
            clazz.getSimpleName());
    }
}