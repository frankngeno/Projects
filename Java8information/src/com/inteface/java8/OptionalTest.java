package com.inteface.java8;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Integer[] array = new Integer[5];
        array[3] = 5;
        Optional<Integer> optional = Optional.ofNullable(array[3]);

//        if (optional.isPresent()) {
//            System.out.println(array[3].toString());
//        }
        System.out.println(array[3].toString());
    }
}
