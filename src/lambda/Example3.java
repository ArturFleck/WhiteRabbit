package lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Example3 {

    public static void main(String[] args) {
        Client client = new Client("Harry Truman", 75, true);
        addHello(client::getName, client::setName); // передаются методы в функцию
        System.out.println(client.getName());
    }

    public static void addHello(Supplier<String> supplier, Consumer<String> consumer) {
        consumer.accept("hello " + supplier.get());
    }
}
