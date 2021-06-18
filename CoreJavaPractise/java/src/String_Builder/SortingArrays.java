package String_Builder;

import java.util.Arrays;

public class SortingArrays {
    public static void main(String[] args) {
        int[] numbers = { 2,5,7,9,43,65,22 };
        Arrays.sort(numbers);
//        for(int i = 0; i < numbers.length; i++){
//            -
//        }
        for(int num : numbers){
            System.out.print(num + " ");
        }
    }
}
