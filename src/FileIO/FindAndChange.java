package FileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindAndChange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Герберт_-_Дюна._Первая_трилогия.txt"));
        List<String> line = new ArrayList<>();
        String buffer;
        while (reader.ready()) {
            buffer = reader.readLine();
            buffer = buffer.replaceAll("Пауль", "Пол");
            buffer = buffer.replaceAll("Пауля", "Пола");
            buffer = buffer.replaceAll("Паулем", "Полом");
            buffer = buffer.replaceAll("Паулю", "Полу");
            line.add(buffer+"\n");
        }

        reader.close();

        for (int i = 0; i < 70; i++) {
            System.out.println(line.get(i));
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("Герберт_-_Дюна._Первая_трилогия new.txt"));
        for (String s : line) {
            writer.write(s);
        }
        writer.close();
    }
}
