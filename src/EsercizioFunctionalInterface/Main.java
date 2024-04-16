package EsercizioFunctionalInterface;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Multiply s = (int x, int y) -> x * x;

        int result = s.calculate(5, 5);

        System.out.println(result);

        Function<Integer, Integer> multipltyByItself = value -> value * value;
        Predicate<Integer> isBiggerOf5 = value -> value > 5;
        Consumer<Integer> printValue = value -> System.out.println(value);


        List<Integer> values = new LinkedList<>();
        values.add(1);
        values.add(2);
        values.add(5);
        values.add(7);
        values.add(3);

        values.stream()
                .map(multipltyByItself)
                .filter(isBiggerOf5)
                .forEach(printValue);


        Function<String, String> divide = string -> string.substring(0, string.length()/2) + " " + string.substring(string.length()/2);
        Predicate<String> bothEven = value -> {
            String[] dividedString = value.split(" ");
            return (dividedString[0].length() % 2 == 0 && dividedString[1].length() % 2 == 0);
        };
        Consumer<String> printString = value -> System.out.println(value);

        List<String> stringValues = new LinkedList<>();
        stringValues.add("A");
        stringValues.add("AA");
        stringValues.add("AAA");
        stringValues.add("AAAA");
        stringValues.add("AAAAA");

        stringValues.stream()
                .map(divide)
                .filter(bothEven)
                .forEach(printString);



    }
}
