package Lesson_6_Kurs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
        Random random = new Random();
        int treeNumber = 20;
        int balanced = 0;

        MyTreeMap<Integer, String>[] mtmArray = new MyTreeMap[treeNumber];
        for (int i = 0; i < treeNumber; i++) {
            mtmArray[i] = new MyTreeMap<>();
            do {
                int value = random.nextInt(201) - 100;
                mtmArray[i].put(value, "");
            } while (mtmArray[i].height() < 6);
//            System.out.println(mtmArray[i].sizeLeftBranch() + "   " + mtmArray[i].sizeRightBranch());
            if(Math.abs((mtmArray[i].sizeLeftBranch() - mtmArray[i].sizeRightBranch())) <= 1){
              balanced++;
          }
        }

        System.out.println("Number of balanced trees: " + balanced);
    }

    public static int log2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }
}
