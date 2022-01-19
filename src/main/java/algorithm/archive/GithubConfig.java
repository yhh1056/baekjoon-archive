package algorithm.archive;

import java.text.MessageFormat;
import java.util.Objects;

public class GithubConfig {
    private final String username;
    private final String repositoryName;
    private final String mainBranch;

    public GithubConfig(final String username, final String repositoryName, final String mainBranch) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(repositoryName);
        Objects.requireNonNull(mainBranch);

        this.username = username;
        this.repositoryName = repositoryName;
        this.mainBranch = mainBranch;
    }

    public static GithubConfig of(String name, String repositoryName, String mainBranch) {
        return new GithubConfig(name, repositoryName, mainBranch);
    }

    public String parse(final Class<?> clazz) {
        return MessageFormat.format("https://github.com/{0}/{1}/blob/{2}/{3}/{4}.java",
            this.username,
            this.repositoryName,
            this.mainBranch,
            clazz.getPackageName().replace(".", "/"),
            clazz.getSimpleName());
    }
}
