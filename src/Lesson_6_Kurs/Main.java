package Lesson_6_Kurs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        MyTreeMap<Integer, Integer> mtm = new MyTreeMap<>();

        Random random = new Random();
        int treeNumber = 20;
        int treeDeep = 6;

        List mtmArray = new ArrayList();
        for (int i = 0; i < treeNumber; i++) {
            mtmArray.set(i, new MyTreeMap<Integer, Integer>());
            while(((MyTreeMap) mtmArray.get(i)).sizeLeftBranch() != treeDeep ||((MyTreeMap) mtmArray.get(i)).sizeRightBranch() != treeDeep) {
            int value = random.nextInt(201) - 100;
            ((MyTreeMap) mtmArray.get(i)).put(value, value);
            }
//            System.out.println(mtmArray[i].sizeLeftBranch());
        }


    }
}
