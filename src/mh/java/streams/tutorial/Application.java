package mh.java.streams.tutorial;

import mh.java.streams.tutorial.model.Gender;
import mh.java.streams.tutorial.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mh on 24/08/2020.
 */
public class Application {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative approach

        List<Person> females = new ArrayList<>();

        for (Person p : people) {
            if (Gender.FEMALE.equals(p.getGender())) {
                females.add(p);
            }
        }

        females.forEach(System.out::println);

        // Declarative approach
        // Filter
        System.out.println("Filter: ");

        List<Person> femalesFilter = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        femalesFilter.forEach(System.out::println);

        // Sort
        System.out.println("--- Sort ---");
        System.out.println("Before: ");
        people.forEach(System.out::println);

        List<Person> peopleSorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge)) // 1 -> 2 -> 3
                // .sorted(Comparator.comparing(Person::getAge).reversed()) // To reverse ordering 3 -> 2 -> 1
                .collect(Collectors.toList());

        System.out.println("After: ");
        peopleSorted.forEach(System.out::println);

        // All match
        System.out.println("--- All match ---");
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 10);
        System.out.println("All persons age great than 10: " + allMatch);

        // Any match
        System.out.println("--- Any match ---");
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 10);
        System.out.println("Any person age great than 10: " + anyMatch);

        // None match
        System.out.println("--- Any match ---");
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getAge() > 10);
        System.out.println("None person age great than 10: " + noneMatch);

        // Max
        System.out.println("--- Max ---");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Min
        System.out.println("--- Min ---");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Group
        System.out.println("--- Group ---");
        Map<Gender, List<Person>> genderListMap = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        genderListMap.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
