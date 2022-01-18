package algorithm.archive.provider.programmers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Programmers {

    /**
     * programmers problem name. (example: 직사각형 별찍기)
     */
    String name();

    /**
     * programmers problem url. (example: https://programmers.co.kr/learn/courses/30/lessons/12969)
     */
    String url() default "";

    /**
     * programmers level. LEVEL1, LEVEL2, LEVEL3, LEVEL4, LEVEL5,
     */
    ProgrammersLevel level() default ProgrammersLevel.UNDEFINED;

    /**
     * programmers problem number. (example: 12969)
     */
    int number() default 0;

}
