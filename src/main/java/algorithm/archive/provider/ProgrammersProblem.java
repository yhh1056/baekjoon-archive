package algorithm.archive.provider;

import algorithm.archive.provider.programmers.ProgrammersLevel;
import java.util.Objects;

public class ProgrammersProblem implements Comparable<ProgrammersProblem> {
    private String location;
    private String url;
    private String name;
    private ProgrammersLevel level;
    private int number;

    public ProgrammersProblem(String location, String url, String name, ProgrammersLevel level, int number) {
        Objects.requireNonNull(location);
        Objects.requireNonNull(name);

        this.location = location;
        this.url = url;
        this.name = name;
        this.level = level;
        this.number = number;
    }

    @Override
    public int compareTo(ProgrammersProblem o) {
        return this.number - o.number;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public ProgrammersLevel getLevel() {
        return level;
    }

    public int getNumber() {
        return number;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String location;
        private String url;
        private String name;
        private ProgrammersLevel level;
        private int number;

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder level(ProgrammersLevel level) {
            this.level = level;
            return this;
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public ProgrammersProblem build() {
            return new ProgrammersProblem(location, url, name, level, number);
        }
    }
}
