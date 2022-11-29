package FileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static void main(String[] args) {

        String[] names = {"Maggie>", "Eva", "Ann", "Joan"};

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("writing to a file");
            writer.write("\nAnd here is the other line");

            for (String name : names) {
                writer.write("\n" + name);
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String path = "output.txt"; // "D:/JavaProjects/WhiteRabbit/output.txt";
        List<String> info = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            while (reader.ready()) {
                info.add(reader.readLine());
            }

            reader.close();

        } catch (IOException e){
            e.printStackTrace();
        }

        info.forEach(System.out::println);

        System.out.println("\n" + info);
    }
}
