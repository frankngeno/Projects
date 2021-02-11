package parrallelStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TheNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //double of even numbers
        Stream<Integer> stream = numbers.stream();
    numbers.stream();
    System.out.println(stream.filter(e -> isEven(e))
            .map(e -> e * 2)
            .collect(toList()));
    }

//    private static boolean isEven(Integer e) {
//        return System.out.println(toList(e));
//    }
    }

