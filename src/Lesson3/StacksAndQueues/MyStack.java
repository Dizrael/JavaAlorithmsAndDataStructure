package Lesson3.StacksAndQueues;

import java.util.EmptyStackException;

public class MyStack<Item> {

    private int size;
    private Item[] stack;
    private final int DEAFULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("Bad size");
        }
        stack = (Item[]) new Object[capacity];
    }

    public MyStack(){
        stack = (Item[]) new Object[DEAFULT_CAPACITY];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == stack.length;
    }

    public void push (Item item){
       if (isFull()){
           throw new StackOverflowError();
       }
       stack[size] = item;
       size++;
    }

    public Item pop(){
        Item temp = peek();
        size--;
        stack[size] = null;
        return temp;
    }

    private Item peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    private void reCapacity(int newCapacity){
        Item[] tempArr = (Item[]) new Object[newCapacity];
        System.arraycopy(stack, 0, tempArr, 0, size);
    }

}
