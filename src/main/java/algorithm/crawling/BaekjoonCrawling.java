package algorithm.crawling;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BaekjoonCrawling {
    private static final String SOLVED_URL = "https://solved.ac/search?query=";
    private static final String DIV_CSS = "div.StickyTable__Table-sc-45ty5n-0";

    private static final Queue<String> queue = new LinkedList<>();

    private BaekjoonCrawling() {}

    public static final String getProblemName(int number) {
        String title = "undefined";
        Connection connect = Jsoup.connect(SOLVED_URL + number);
        try {
            Elements elements = connect.get().select(DIV_CSS);
            for (Element element : elements) {
                Collections.addAll(queue, element.select("span").text().split(" "));

                while (!queue.isEmpty()) {
                    String name = queue.poll();
                    if (name.equals(String.valueOf(number))) {
                        queue.poll();
                        return queue.poll();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            queue.clear();
        }
        return title;
    }
}
