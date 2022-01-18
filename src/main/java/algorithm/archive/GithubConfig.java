package algorithm.archive;

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

    public String getUsername() {
        return username;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public String getMainBranch() {
        return mainBranch;
    }
}
