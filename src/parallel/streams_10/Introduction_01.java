package parallel.streams_10;

import java.util.List;
import java.util.stream.IntStream;

public class Introduction_01 {
    public static void main(String[] args)  {
        /*
        *         PARALLEL STREAM:
        *
        *         /→ intermediate → intermediate →\
        * source --→ intermediate → intermediate --→ terminal
        *         \→ intermediate → intermediate →/
        * */

        // to obtain available number of processors:
        Runtime
                .getRuntime()
                .availableProcessors();

        int sumAllAdultAges = Person.getPeople().parallelStream()
                .filter(person -> person.getAge() >= 18)
                .mapToInt(Person::getAge)
                .reduce(0, Integer::sum);

        // sumAllAdultAges; → 102

        // sum of consecutive numbers:
        int factorial = IntStream
                .rangeClosed(1, 10)
                // makes a stream parallel
                .parallel()
                .reduce(1, (a, b) -> a * b);
        // factorial; → 3628800

    }
}

class Person {
    String name;
    int age;

    static List<Person> getPeople() {
        return List.of(
                new Person("Nick", 25),
                new Person("Jack", 18),
                new Person("Rebecca", 19),
                new Person("Adrian", 20),
                new Person("Emily", 12),
                new Person("Harry", 16),
                new Person("Lucy", 20),
                new Person("Nicolle", 15)
        );
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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