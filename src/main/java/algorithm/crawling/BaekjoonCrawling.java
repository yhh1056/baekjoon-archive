package algorithm.crawling;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BaekjoonCrawling {
    private static final String SOLVED_URL = "https://solved.ac/search?query=";
    private static final String DIV_CSS = "div.StickyTable__Table-sc-45ty5n-0";

    private static final Set<String> problemName = new LinkedHashSet<>();

    private BaekjoonCrawling() {}

    public static final String getProblemName(int number) {
        String title = "undefined";
        Connection connect = Jsoup.connect(SOLVED_URL + number);
        try {
            Elements elements = connect.get().select(DIV_CSS);
            for (Element element : elements) {
                problemName.addAll(Arrays.asList(element.select("span").text().split(" ")));
                if (!problemName.isEmpty()) {
                    title = "";
                }

                boolean tag = true;
                for (String name : problemName) {
                    if (tag) {
                        tag = false;
                    } else {
                        title += name + " ";
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            problemName.clear();
        }
        return title.trim();
    }
}
