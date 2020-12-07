package com.raptor.test05;

import java.util.ArrayList;

class TestClass05 {
    
    String x;

    void foo() {
        var list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.forEach(System.out::println);
    }

    void bar() {
        var list = new ArrayList<String>();
        list.add("purple");
        list.forEach(element -> x = element);
        System.out.println(x);
    }

}
