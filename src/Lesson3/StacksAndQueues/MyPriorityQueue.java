package Lesson3.StacksAndQueues;

import java.util.EmptyStackException;

public class MyPriorityQueue<Item extends Comparable> {
    private int size = 0;
    private Item[] stack;
    private final int DEAFULT_CAPACITY = 10;

    private int begin = 0;
    private int end = 0;

    public MyPriorityQueue(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("Bad size");
        }
        stack = (Item[]) new Object[capacity];
    }

    public MyPriorityQueue(){
        stack = (Item[]) new Object[DEAFULT_CAPACITY];
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == stack.length;
    }

    public void insert (Item item){
        if (isFull()){
            throw new StackOverflowError();
        }
        stack[end] = item;
        size++;
        int i = size - 1;
        while(i > 0 && stack[i].compareTo(stack[i - 1]) < 0){
            swap(i, i-1);
            i--;
        }
    }

    public void swap(int i1, int i2){
        Item temp = stack[i1];
        stack[i1] = stack[i2];
        stack[i1] = temp;
    }

    public Item remove(){
        Item value = peekFront();
        size--;
        stack[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    private Item peekFront(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[begin];
    }

    private int nextIndex (int index){
        return (index + 1) % stack.length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(stack[i] + " ");
        }
        return sb.toString();
    }
}
