package Lesson2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        MyArray myArray = new MyArray(10000);

        for (int i = 0; i < myArray.getSize(); i++) {
            myArray.setElement(i, random.nextInt(500)+1 );
        }
        long start = System.currentTimeMillis();
        myArray.sortBubble();
        long finish = System.currentTimeMillis();
        long time = finish - start;
        System.out.println(time);

    }

}
