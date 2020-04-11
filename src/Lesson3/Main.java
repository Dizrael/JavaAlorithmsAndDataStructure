package Lesson3;

import Lesson3.StacksAndQueues.Deca;
import Lesson3.StacksAndQueues.MyStack;

public class Main {
    public static void main(String[] args) {

        String test = "123 123";
        String conv = converter(test);
        System.out.println("Инвертируем строку: " + test + "\nРезультат: " + conv + "\n");

        Deca deca = new Deca(5);
        for (int i = 0; i < 5; i++) {
            deca.add(i+1);
        }
        System.out.println("Наша последовательность числел: " + deca.toString());

        deca.addFirst(9);
        System.out.println("Добавим '9' в начало");
        System.out.println(deca.toString());

        System.out.println("Добавим '0' в конец");
        deca.addLast(0);
        System.out.println(deca.toString());

        deca.removeFirst();
        System.out.println("Удалим 1й элемент:\n" + deca.toString());

        deca.removeLast();
        System.out.println("Удалим последний элемент:\n" +deca.toString());

    }

    public static String converter(String string){
        String oldString = string;
        StringBuilder sb = new StringBuilder();
        MyStack stack = new MyStack(oldString.length());

        for (int i = 0; i < oldString.length(); i++) {
            stack.push(oldString.charAt(i));
        }

        for (int i = 0; i < oldString.length(); i++) {
            char tempCh = (char) stack.pop();
            sb.append(tempCh);
        }

        String newString;
        newString = sb.toString();
        return newString;
    }
}
