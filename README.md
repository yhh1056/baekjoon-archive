# y-algo

## y-algo?
This is a library that documents problems solved by Baekjoon and Programmers (to be added). <br>
It is a gradle or maven-based project and supports only Java files. <br>
It is recommended to use Java 11 or higher. 

## How to use

### Gradle
Add the JitPack repository to your build file
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency
```groovy
dependencies {
    implementation 'com.github.yhh1056:y-algo:v0.0.1-alpha'
}
```

### Maven
Add the JitPack repository to your build file
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
Add the dependency
```xml
<dependency>
    <groupId>com.github.yhh1056</groupId>
    <artifactId>y-algo</artifactId>
    <version>v0.0.1-alpha</version>
</dependency>
```

### How to run

```Java
public static void main(String[] args) {
    GithubConfig config = new GithubConfig("github-username", "repository-name", "main-branch-name");
    MarkdownGenerator generator = new MarkdownGenerator(config);
    generator.generate();
}
```

### Annotation example
```Java
@Baekjoon(name = "A+B", url = "https://www.acmicpc.net/problem/1000", level = BaekjoonLevel.BRONZE, number = 1000)
public class Main {
    public static void main(String[] args) {
        ...
    }
}
```