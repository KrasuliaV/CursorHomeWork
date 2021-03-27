package com.cursor.krasulia;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<? super A> list = new ArrayList<>();
//        list.add(new B());
        String s = "sss";
        String s2 = "sss";
        System.out.println(s == s2);

        Integer x = new Integer(22);
//        B b = new B();

        System.out.println(B.class.getSuperclass());
        System.out.println(x instanceof Integer);
    }
//
//    public interface A {
//    }
//
//    public class B {
//    }
//
//    public class C {
//    }
}






