package algorithm;

import algorithm.archive.GithubConfig;
import algorithm.archive.provider.baekjoon.Baekjoon;
import algorithm.archive.provider.baekjoon.BaekjoonLevel;
import algorithm.archive.provider.programmers.Programmers;
import algorithm.archive.provider.programmers.ProgrammersLevel;
import algorithm.file.DefaultBaekjoonMarkdownGenerator;
import algorithm.file.DefaultProgrammersMarkdownGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArchiveLauncherTest {

    @Test
    @DisplayName("generate default provider")
    void generateProvider() {
        GithubConfig config = new GithubConfig("yhh1056", "repo", "main");
        ArchiveLauncher launcher = new ArchiveLauncher();
        launcher.run(new DefaultProgrammersMarkdownGenerator(config));
        launcher.run(new DefaultBaekjoonMarkdownGenerator(config));
    }

}

@Baekjoon(number = 10001, level = BaekjoonLevel.RUBY)
class Solve1 {}

@Programmers(name = "test", url = "https://testsetse/10001", level = ProgrammersLevel.LEVEL5, number = 10001)
class Solve2 {}