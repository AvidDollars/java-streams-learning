package collectors.api_08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownstreamCollector_03 {
    public static void main(String[] args) {
        List<Person> listOfPersons = getPeople();

        Map<Gender, Integer> sumAgeForGenders = listOfPersons.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        // sum age for each group
                        Collectors.summingInt(Person::getAge)
                ));

        // sumAgeForGenders; → {MALE=96, FEMALE=135}
    }

    public static List<Person> getPeople() {
        return Arrays.asList(
                new Person("Nick", 22, Gender.MALE),
                new Person("Jack", 12, Gender.MALE),
                new Person("Nicki", 18, Gender.FEMALE),
                new Person("Elisa", 55, Gender.FEMALE),
                new Person("Jimi", 20, Gender.MALE),
                new Person("Peter", 18, Gender.MALE),
                new Person("Robert", 10, Gender.MALE),
                new Person("Donald", 14, Gender.MALE),
                new Person("Emily", 32, Gender.FEMALE),
                new Person("Sara", 30, Gender.FEMALE)
        );
    }
}

class Person {
    String name;
    int age;
    Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

enum Gender {
    MALE, FEMALE;
}