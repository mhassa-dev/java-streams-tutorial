package mh.java.streams.tutorial;

import mh.java.streams.tutorial.model.Gender;
import mh.java.streams.tutorial.model.Person;

import java.util.ArrayList;
import java.util.List;

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
