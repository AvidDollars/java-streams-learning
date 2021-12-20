package lambdas_04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting_03 {
    public static void main(String[] args) {
        List<Person> listOfPersons = Arrays.asList(
                new Person("Peter", 15),
                new Person("Martin", 22),
                new Person("Jack", 18),
                new Person("Elisa", 22)
        );
        
        // instead of implementing 'compareTo' method in Person class
        // or using Comparator anonymous class
        // we can use lambda expression

        // 'sort' is default method of List interface that accepts comparator as an argument
        Comparator<Person> compareByAge = (a, b) -> a.age - b.age;
        Comparator<Person> compareByName = (a, b) -> a.name.compareTo(b.name);

        listOfPersons.sort(compareByAge); // [Person{name='Peter', age=15}, Person{name='Martin', age=22}, ...

        // comparators can be chained with 'thenComparing' default method from the Comparator interface
        // 1st comparison is by age, 2nd is by name
        Comparator<Person> composite = compareByAge.thenComparing(compareByName);

        // sorting in reversed order with 'reversed' default method from Comparator interface
        Comparator<Person> compositeReversed = compareByAge.reversed()
                .thenComparing(compareByName.reversed());

        listOfPersons.sort(compositeReversed); // [Person{name='Martin', age=22}, Person{name='Elisa', age=22}, ...

        // static method 'comparingInt' takes ToIntFunction as an argument
        // for comparison based on extracted keys
        // avoids boxing of primitive types
        // other methods → comparingLong, comparingDouble
        Comparator<Person> compareByAgeTwo = Comparator.comparingInt(person -> person.age);

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