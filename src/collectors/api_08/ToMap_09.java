package collectors.api_08;

import java.util.List;
import java.util.stream.Collectors;

public class ToMap_09 {
    public static void main(String[] args) {
        // take list of people and take it to a HashMap (key = id, value = List.of(name, age))
        var people = getPeople();

        var peopleById = people.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toMap(
                        PersonId::getId, // key mapper
                        person -> List.of(person.getName(), person.getAge()) // value mapper
                ));
        // peopleById; → {1=[Nick, 22], 3=[Emily, 20], 4=[Suzanne, 25], ...}
    }

    static List<PersonId> getPeople() {
        return List.of(
                new PersonId("Nick", 22, 1),
                new PersonId("Jack", 15, 2),
                new PersonId("Emily", 20, 3),
                new PersonId("Suzanne", 25, 4),
                new PersonId("Jimi", 22, 5),
                new PersonId("Margaret", 20, 6),
                new PersonId("Paul", 15, 7),
                new PersonId("Jordan", 18, 8)
        );
    }
}

class PersonId {
    private String name;
    private int age;
    private int id;

    public PersonId(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}