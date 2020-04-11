package Lesson3.StacksAndQueues;

import java.util.EmptyStackException;

public class MyQueue<Item> {
    private int size = 0;
    private Item[] stack;
    private final int DEAFULT_CAPACITY = 10;

    private int begin = 0;
    private int end = 0;

    public MyQueue(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("Bad size");
        }
        stack = (Item[]) new Object[capacity];
    }

    public MyQueue(){
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
        size++;
        stack[end] = item;
        end = nextIndex(end);
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

   public int size(){
        return size;
   }
}
