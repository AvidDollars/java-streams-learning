package streams_05;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapAndFilter_03 {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Michael", 15), new Person("Jack", 12),
                new Person("Emily", 18), new Person("Anabel", 15),
                new Person("Adam", 14), new Person("Samuel", 22),
                new Person("Viktor", 20), new Person("Eva", 15),
                new Person("Edvard", 19), new Person("Simon", 15)
        );

        List<String> adults = personList.stream()
                .filter(person -> person.age >= 18)
                .map(person -> person.name)
                .collect(Collectors.toList());

        // adults → [Emily, Samuel, Viktor, Edvard]
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}