package com.company.expression1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Data{
    private String name;
    private String Id;

    public Data(String name, String id) {
        this.name = name;
        Id = id;
    }

    public String getName() {
        return name;
    }


    public String getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", Id='" + Id + '\'' +
                '}';
    }
}

public class App {
    public static void main(String[] args) {

        List<Data>list = new ArrayList<>();
        list.add(new Data("fabian", "20"));
        list.add(new Data("Frank", "25"));
        list.add(new Data("cathy", "23"));

        Collections.sort(list, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Data data: list){
            System.out.println(data.getName());
        }


    }
}
