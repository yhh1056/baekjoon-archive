package algorithm.crawling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaekjoonCrawlingTest {

    @Test
    @DisplayName("crawling baekjoon title 1000")
    void crawling1000() {
        String problemName = BaekjoonCrawling.getProblemName(1000);

        assertEquals(problemName, "A+B");
    }

    @Test
    @DisplayName("crawling baekjoon title 1001")
    void crawling1001() {
        String problemName = BaekjoonCrawling.getProblemName(1001);

        assertEquals(problemName, "A-B");
    }

    @Test
    @DisplayName("crawling baekjoon title 1002")
    void crawling1002() {
        String problemName = BaekjoonCrawling.getProblemName(1002);

        assertEquals(problemName, "터렛");
    }
}