package com.inteface.java8;

public class LambdaMainClass {
    public static void main(String[] args) {

            LambdaInterface lambdaInterface = (int x) -> x*x;

            System.out.println(lambdaInterface.getSquare(5));
    }
}
