package parrallelStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class JavaReactiveStream {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //double of even numbers
        List<Integer> doubled = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                doubled.add(numbers.get(i) * 2);
            }
        }
        System.out.println(doubled);

        //Decllarative & function code reads like the problems statments
        //single pass through
        System.out.println(
                numbers.parallelStream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .collect(toList()));
    }

/*
funtion == devlarative + highorder-function
internal vs external iteration
imperative style
*/

//    Thread thread = new Thread(new Runnable() {
//        @Override
//        // will take no parameter and doe
//        public void run() {
//
//        }
//    }
}