# baekjoon-archive 

## baekjoon-archive ?

간단한 어노테이션 설정을 통해 **백준 문제 풀이 문서화** 라이브러리입니다. <br>
문제 번호로 크롤링을 하여 문제 정보를 가져온 뒤 사용자가 작성한 마크다운 생성기로 원하는 문서양식을 만들 수 있습니다. <br>
기본적으로 `DefaultBaekjoonMarkdownGenerator`를 제공합니다.

자바 11이상 환경에서 사용하는 것을 권장합니다.

## how to use?

### main
```java
public static void main(String[] args) {
    GithubConfig config = new GithubConfig("github name", "github repo name", "main branch name");
    ArchiveLauncher launcher = new ArchiveLauncher();
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

### result
```text
## 백준
|번호|제목|난이도|풀이|주소|
|---|---|---|---|---|
|1000|A+B|BRONZE|[풀이](https://github.com/{github name}/{github repo name}/blob/{main branch name}/baekjoon/b1000/Main.java)|https://www.acmicpc.net/problem/1000|

```

### Example
[baekjoon-archive 사용 예시 코드](https://github.com/yhh1056/studyAlgorithm)
