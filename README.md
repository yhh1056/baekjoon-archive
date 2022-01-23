# y-algo

## y-algo?
This is a library that documents problems solved by Baekjoon and Programmers (to be added). <br>
It is a gradle or maven-based project and supports only Java files. <br>
It is recommended to use Java 11 or higher. 

## how to use?

### main
```java
public static void main(String[] args) {
    GithubConfig config = new GithubConfig("github name", "github repo name", "main branch name");
    ArchiveLauncher launcher = new ArchiveLauncher();
    launcher.run(new DefaultProgrammersMarkdownGenerator(config));
    launcher.run(new DefaultBaekjoonMarkdownGenerator(config));
}
```

### baekjoon
```java
@Baekjoon(number = 1000, level = BaekjoonLevel.BRONZE)
class Main {
    public static void main(String[] args) {
        ...
    }
}
```

### programmers
```java
@Programmers(name = "완주하지 못한 선수", url = "https://programmers.co.kr/learn/courses/30/lessons/42576", level = ProgrammersLevel.LEVEL1, number = 42576)
class Solution {
    ...
}
```
