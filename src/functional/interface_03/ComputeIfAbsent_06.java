package functional.interface_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeIfAbsent_06 {
    public static void main(String[] args) {
        List<String> cities = List.of("barcelona", "prague", "vienna", "paris", "bratislava");
        System.out.println(mapOfFirstCharacters(cities)); // {p=[prague, paris], b=[barcelona, bratislava], v=[vienna]}
        System.out.println(mapOfFirstCharactersTwo(cities)); // {p=[prague, paris], b=[barcelona, bratislava], v=[vienna]}
    }

    // sometimes we have to handle potentially missing keys in a map
    // we can use 'putIfAbsent' method
    static Map<Character, List<String>> mapOfFirstCharacters(List<String> list) {
        Map<Character, List<String>> cityMap = new HashMap<>();

        for (String city: list) {
            char character = city.charAt(0);
            cityMap.putIfAbsent(character, new ArrayList<>());
            cityMap.get(character).add(city);
        }

        return cityMap;
    }

    // or we can use 'computeIfAbsent' method
    // we need to provide lambda function that creates a new array if key is missing
    static Map<Character, List<String>> mapOfFirstCharactersTwo(List<String> list) {
        Map<Character, List<String>> cityMap = new HashMap<>();

        for (String city: list) {
            char character = city.charAt(0);
            cityMap.computeIfAbsent(character, key -> new ArrayList<>());
            cityMap.get(character).add(city);
        }

        return cityMap;
    }
}
