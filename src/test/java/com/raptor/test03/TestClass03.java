package com.raptor.test03;

import java.util.*;

public class TestClass03<T extends String & CharSequence, E> {

    public static int x1 = 300;
    
    public static void f1(int x, int... ints) {
        int y = x1;
        int z = 10;
        int w = 320;
        float f = 17.2f;
        double d = -1.05;
        y++;
        f2(y, z, w, f, d);
    }

    public static <T extends Number> void f2(T... ts) {
        List<T> list = Arrays.asList(ts);
        list.size();
        list.get(0);
        list.forEach(x -> {
            ts[list.indexOf(x)] = null;
        });
        list.forEach(System.out::println);
    }

    public static void f3(int x) {
        switch (x) {
            case 0: System.out.println("zero");
                    break;
            case 1: System.out.println("one");
                    break;
            case 2: System.out.println("two");
                    break;
            case 4: System.out.println("three");
                    break;
            default:System.out.println(x);
                    break;
        }
    }

}
