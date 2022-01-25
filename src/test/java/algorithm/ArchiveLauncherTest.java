package algorithm;

import algorithm.archive.GithubConfig;
import algorithm.archive.provider.baekjoon.Baekjoon;
import algorithm.archive.provider.baekjoon.BaekjoonLevel;
import algorithm.file.DefaultBaekjoonMarkdownGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArchiveLauncherTest {

    @Test
    @DisplayName("generate default provider")
    void generateProvider() {
        GithubConfig config = new GithubConfig("yhh1056", "repo", "main");
        ArchiveLauncher launcher = new ArchiveLauncher();
        launcher.run(new DefaultBaekjoonMarkdownGenerator(config));
    }

}

@Baekjoon(number = 10001, level = BaekjoonLevel.RUBY)
class Solve1 {}
