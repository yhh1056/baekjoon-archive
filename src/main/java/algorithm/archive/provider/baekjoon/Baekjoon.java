package algorithm.archive.provider.baekjoon;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Baekjoon {

    /**
     * baekjoon problem name. (example: A+B)
     */
    String name();

    /**
     * baekjoon problem url. (example: https://www.acmicpc.net/problem/1000)
     */
    String url() default "";

    /**
     * baekjoon level. BRONZE, SILVER, GOLD, PLATINUM, DIAMOND, RUBY
     */
    BaekjoonLevel level() default BaekjoonLevel.UNDEFINED;

    /**
     * baekjoon problem number. (example: 1000)
     */
    int number() default 0;

}
