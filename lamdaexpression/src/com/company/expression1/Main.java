package com.company.expression1;

interface Lambda{
    public void demo();

}

public class Main {

    public static void main(String[] args) {
        Lambda lambda = ()->{
            System.out.println("statement 1");
            System.out.println("statement 2");
        };
        lambda.demo();

    }
}
