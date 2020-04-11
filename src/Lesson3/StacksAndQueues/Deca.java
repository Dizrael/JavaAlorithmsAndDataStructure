package Lesson3.StacksAndQueues;

import java.util.EmptyStackException;

public class Deca<Item> {
    private int size = 0;
    private Item[] stack;
    private final int DEAFULT_CAPACITY = 10;

    private int begin = 0;
    private int end = 0;

    public Deca(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("Bad size");
        }
        stack = (Item[]) new Object[capacity];
    }

    public Deca(){
        stack = (Item[]) new Object[DEAFULT_CAPACITY];
    }

    public void addFirst(Item item){
        if (isFull()){
            this.stack = reCapacity(size * 2,0, 1);
        }
        size++;
        stack[begin] = item;
    }

    public void addLast(Item item){
        if (isFull()){
            this.stack = reCapacity(size * 2,0, 0);
        }
        size++;
        stack[size - 1] = item;
        end = size-1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == stack.length;
    }

    public void add (Item item){
        if (isFull()){
            throw new StackOverflowError();
        }
        size++;
        stack[end] = item;
        end = nextIndex(end);
    }

    public Item removeFirst(){
        Item value = peekFirst();
        stack[begin] = null;
        size--;
        this.stack = reCapacity(size,1,0);
        return value;
    }

    public Item peekFirst(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[begin];
    }

    public Item removeLast(){
        Item value = peekLast();
        stack[size-1] = null;
        size--;
        end = size-1;
        return value;
    }

    public Item peekLast(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[size-1];
    }

    private int nextIndex (int index){
        return (index + 1) % stack.length;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(stack[i] + " ");
        }
        return sb.toString();
    }

    private Item[] reCapacity(int newCapacity,int srcPos, int dstPos){
        Item[] tempArr = (Item[]) new Object[newCapacity];
        System.arraycopy(stack, srcPos, tempArr, dstPos, size);
        return tempArr;
    }
}
