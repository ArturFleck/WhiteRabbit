package optionals;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class OptionalsExample {
    public static void main(String[] args) {

        Optional<String> hello = Optional.ofNullable(null);
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());
        System.out.println(hello.orElse("world"));

        System.out.println("\n ------------------- \n");

        Person person1 = new Person("James Webb", "sam@gm.com");
        Person person2 = new Person("Lindon Johnson", null);
        Person person3 = new Person("Gray Brown", "g.b@em.com");

        String email = person1
                .getEmail()
                .map(String::toLowerCase)
                .orElse("email is not provided");
        System.out.println(email);


        if (person2.getEmail().isPresent()) {
            String email1 = person2.getEmail().get();
            System.out.println(email1.toLowerCase(Locale.ROOT));
        } else {
            System.out.println("email is not provided");
        }

        System.out.println("\n ------------------- \n");

        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);

        for (Person p : list) {
            System.out.print(p.getName() + "\t");
            System.out.println(p.getEmail().map(String::toLowerCase).orElse("email not provided"));
        }

        System.out.println("\n ------------------- \n");

        list.stream()
                .filter(x->x.getEmail().isPresent())
                .map(x->x.getEmail().orElse(""))
                .forEach(System.out::println);

        System.out.println("\n ------------------- \n");

        list.forEach(x -> System.out.println(x.getEmail().orElse("email not provided")));

    }
}

@AllArgsConstructor
class Person {
    private final String name;
    private final String email;

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}