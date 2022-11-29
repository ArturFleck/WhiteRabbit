package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();
        //people.forEach(System.out::println);

        people.stream()
                .filter(x -> x.getAge()>30 && x.getAge()<100)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("--------------------");

        // filter
        List<Person> females = people.stream()

                .filter(x -> x.getGender().equals(Gender.FEMALE))
                //.skip(2)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("--------------------");

        females.remove(females.get(0));
        females.forEach(System.out::println);

        System.out.println("--------------------");

        // sort
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);

        System.out.println("--------------------");

        // all match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);

        System.out.println(allMatch);

        System.out.println("--------------------");

        // any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 121);

        System.out.println(anyMatch);

        System.out.println("--------------------");

        // none match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));

        System.out.println(noneMatch);

        System.out.println("--------------------");

        // max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println("--------------------");

        // min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println("--------------------");

        // group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender,people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        System.out.println("--------------------");

        List<String> nameOfOldestFemale = people.stream()
                .filter(x -> x.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName)
                .stream().collect(Collectors.toList());

        System.out.println(nameOfOldestFemale);

        //same thing as higher
        Optional<String> nameOfTheOldestFemale = people.stream()
                .filter(x -> x.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        nameOfTheOldestFemale.ifPresent(System.out::println);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond",20,Gender.MALE),
                new Person("Alina Smith",33,Gender.FEMALE),
                new Person("Helen White",57,Gender.FEMALE),
                new Person("Alex Boz",14,Gender.MALE),
                new Person("Jamie Goa",99,Gender.MALE),
                new Person("Anna Cook",7,Gender.FEMALE),
                new Person("Zelda Brown",120,Gender.FEMALE)
        );
    }
}
