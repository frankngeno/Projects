package com.inteface.java8;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
    public void test(); //functional interface has only abstract method.

    public default void defaultMethod(){
        System.out.println("default method"); // you can have only default method in functional interface
        // its optional to override.  @Override
    }

    public static void staticMethod(){
        System.out.println("Static method"); // you cannot override static method
    }
}
