package pageReader_PARSER;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;

public class CryptoParser {
    @SneakyThrows
    public static void main(String[] args) {

        org.jsoup.nodes.Document page = Jsoup.connect("https://cryptonews.net/ru/").get();
        var titles = page.select("body > main > div.container > div.content.row > section.col-xs-12.col-sm > div.row.news-item.start-xs >" +
                "div.desc.col-xs > a.title");
        String title = titles.get(0).text();
        String href = titles.get(0).attr("href");
        System.out.println(title);
        System.out.println("https://cryptonews.net" + href);

    }
}
