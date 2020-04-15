package lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RecursionClass {

    public static void main(String[] args) {

        System.out.println(numberPower(2, 5));

        //Задача о рюкзаке
        //Подсмотрел реализацию на стаковерфлоу, сам не разобрался бы, зато так стало понятнее
        int TOTAL_EQUIP_COUNT = 26;
        float[] weights = new float[TOTAL_EQUIP_COUNT];
        Random random = new Random();
        for (int i = 0; i < weights.length; i++) {
            weights[i] = random.nextInt(20000) / 1000f;
        }
        System.out.println(Arrays.toString(weights));
        ArrayList<Integer> indices = new ArrayList<>();
        recursive(weights, indices);


    }

    private static void recursive(float[] weights, ArrayList<Integer> indices) {
        int MAX_EQUIP_COUNT = 13;
        if (indices.size() > MAX_EQUIP_COUNT)
            return;
        int i = 0;
        if (indices.size() > 0)
            i = indices.get(indices.size() - 1) + 1;
        for (; i < weights.length; i++) {
            indices.add(i);
            float sum = 0;
            for (Integer index : indices) {
                sum += weights[index];
            }
            float REQUIRED_WEIGHT = 10f;
            float epsilon = 0.0001f;
            if (Math.abs(sum - REQUIRED_WEIGHT) < epsilon) {
                StringBuilder s = new StringBuilder();
                s.append(weights[indices.get(0)]);
                for (int j = 1; j < indices.size(); j++) {
                    s.append(", ").append(weights[indices.get(j)]);
                }
                System.out.println("Подходящая сумма: " + s.toString());
            } else if (sum < REQUIRED_WEIGHT) {
                recursive(weights, indices);
            }
            indices.remove(indices.size() - 1);
        }
    }



    public static int numberPower(int number, int power) {
        if (power == 1) return number;
        return number * numberPower(number, power - 1);
    }
}
