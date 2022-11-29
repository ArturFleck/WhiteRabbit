package generic;

public class GenericExample {

    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>(23);
        printer.print();

        Printer<String> printer1 = new Printer<>("Some text");
        printer1.print();
    }
}
