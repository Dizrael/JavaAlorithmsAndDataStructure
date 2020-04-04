package Lesson2;

public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int size) {
        this.size = size;
        this.array = new int[size];
    }

    public int getElement(int index){
        return this.array[index];
    }

    public void setElement(int index, int elem){
        this.array[index] = elem;
    }

    public int[] deleteElement(int elem){
        for (int i = 0; i <this.size ; i++) {
            if(this.array[i] == elem){
                for (int j = i; j < this.size-1 ; j++) {
                    this.array[j] = this.array[j+1];
                }
                break;
            }
        }
        this.size--;

        return this.array;
    }

    public int getSize(){
        return this.size;
    }

    public void sortBubble(){
        for (int out = this.size-1; out >= 1 ; out--) {
            for (int in = 0; in < out; in++) {
                if(this.array[in] > this.array[in+1]){
                    change(in, in+1);
                }
            }
        }
    }

    public void sortSelect(){
        int mark;
        for (int out = 0; out < this.size; out++) {
            mark = out;
            for (int in = out+1; in < this.size; in++) {
                if(this.array[in]<this.array[mark]){
                    mark = in;
                }
            }
            change(out, mark);
        }
    }

    public void sortInsert(){
        int in;
        for (int out = 1; out < this.size; out++) {
            int temp = this.array[out];
            in = out;
            while(in > 0 && this.array[in-1] >= temp){
                this.array[in] = this.array[in-1];
                --in;
            }
            this.array[in] = temp;
        }
    }

    private void change (int a, int b){
        int tmp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = tmp;
    }
}
