package optional.api_06;

import java.util.List;
import java.util.Optional;

public class FindFirst_02 {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Michael", 15), new Person("Jack", 12),
                new Person("Jack", 12), new Person("Anabel", 15),
                new Person("Adam", 14), new Person("Samuel", 22),
                new Person("Viktor", 20), new Person("Edvard", 15),
                new Person("Edvard", 19), new Person("Adam", 14)
        );

        Optional<Person> firstAdultPerson = personList.stream()
                .filter(p -> p.age >= 18)
                // returns 'Optional' object which can be populated or empty
                // terminal operation
                .findFirst();


        // firstAdultPerson.isPresent(); → true
        // firstAdultPerson; → Optional[Person{name='Samuel', age=22}]

        // 'Optional' class contains some methods which are also defined in 'Stream' interface
        //      - filter / map / stream / ...
        // other useful methods from 'Optional' class:
        //      - or / orElse / orElseGet / orElseThrow / ...
        //
        // e.g.
        String hasFifteenYears = personList.stream()
                .filter(person -> person.age == 15)
                .findFirst()

                // returns Optional object
                // (not a Stream object, because we are using 'map' from 'Optional' class)
                .map(person -> person.name) // returns name of 1st person of age 15
                .orElse("not found"); // or "not found" if 'Optional.empty' is returned

        // hasFifteenYears; → Michael
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}