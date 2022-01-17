package examples_11;

import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupPeopleByFirstCharInName_04 {
    public static void main(String[] args) {
        Function<Person, Character> firstCharacter = person -> person.getName().charAt(0);

        var groupedPeople = Person
                .getPersonStreamSample()
                .collect(Collectors.groupingBy(firstCharacter));
        // groupedPeople → {P=[Person{name='Paula', age=32}, Person{name='Paul'...
    }
}
