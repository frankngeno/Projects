package com.inteface.java8;

import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String[] args) {
        StringJoiner name =  new StringJoiner(",","[","]");
//        delimiter: separator, prefix : opening, suffix : closing
        name.add("Frank");
        name.add("John");

        StringJoiner country = new StringJoiner(";","{","}");
        country.add("Usa");
        country.add("Kenya");

//        StringJoiner merged = name.merge(country);
        StringJoiner merged = country.merge(name);
        System.out.println(merged.toString());
    }
}
