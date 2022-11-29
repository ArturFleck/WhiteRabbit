package pageReader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PageReader {
    public static void main(String[] args) throws IOException {
        String urlStart = "https://libking.ru/books/sf-/sf-space/1067519-";
        String urlEnd = "frenk-herbert-dyuna-obnovlennyj-perevod-ot-2019-goda-litres.html#book";

        List<String> page = new ArrayList<>();

        for (int i = 1; i <= 175; i++) {
            URL url ;
            if (i==1){
                url = new URL(urlStart+urlEnd);
            }
            else{
                url = new URL(urlStart+i+"-"+urlEnd);
            }

            try {
                // read text returned by server
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

                String line;
                String buffer;
                while ((buffer = in.readLine()) != null) {
                    if (buffer.contains("<p>") && !buffer.contains("Шрифт") && !buffer.contains("Интервал") && !buffer.contains("Закладка") && !buffer.contains("Отзывы читателей") && !buffer.contains("все книги автора")) {
                        line = buffer;
                        line = line.replaceAll("&nbsp;", "");
                        line = line.replaceAll("\t", "");
                        line = line.replaceAll("\t\t", "");
                        line = line.replaceAll("<p>", "");
                        line = line.replaceAll("</p>", "");
                        line = line.replaceAll("<em>", "");
                        line = line.replaceAll("</em>", "");
                        //System.out.println( page.contains(line));
                        if (!page.contains(line))
                            page.add(line);
                        //System.out.println(line);
                    }
                }

                in.close();

            } catch (MalformedURLException e) {
                System.out.println("Malformed URL: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("I/O Error: " + e.getMessage());
            }
        }

        //page.forEach(System.out::println);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Book.txt"));

            for (int i=0;i< page.size();i++) {
                writer.write(page.get(i)+"\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
