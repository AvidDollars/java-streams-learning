package examples_11;

public class Sum_06 {
    public static void main(String[] args) {
        // if we want to sum all ages
        int ageSum = Person.getPersonStreamSample()
                .map(Person::getAge)
                .reduce(0, (total, age) -> total + age);
        // geSum; → 212

        // we can use ".mapToInt" instead of ".map"
        // then you can use ".sum" instead of ".reduce"
        int ageSumTwo = Person.getPersonStreamSample()
                .mapToInt(Person::getAge)
                .sum();

        System.out.println(ageSumTwo);
    }
}
