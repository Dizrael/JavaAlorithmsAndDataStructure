package Lesson4;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        LinkedList<String> ll = new LinkedList<>();
//        ll.add("A");
//        ll.add("B");
//        ll.add("C");
//        ll.add("D");

        MyLinkedList<String> mll = new MyLinkedList<>();
        mll.insertFirst("Bob1");
        mll.insertFirst("Bob2");
        mll.insertFirst("Bob3");
        mll.insertFirst("Bob4");
        mll.insertFirst("Bob5");
        mll.insertFirst("Bob6");
        mll.insertFirst("Bob7");
        mll.insertFirst("Bob8");
        mll.insertFirst("Bob9");
        mll.insertFirst("Bob10");

//        System.out.println(mll.removeFirst());
//        System.out.println(mll);
        System.out.println(mll);


    }
}
