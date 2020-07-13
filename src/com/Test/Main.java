package com.Test;



public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Vector<Integer> vector = new Vector<Integer>(5,4);
        System.out.println(vector.toString());
        vector.set(0,1);
        System.out.println(vector.toString());
        vector.pushBack(5);
        System.out.println(vector.toString());
        vector.popBack();
        System.out.println(vector.toString());
    }
}

class Vector <T> {

    private T[] vector;

    private T[] copy(T[] src, T[] dst){
        int min = Math.min(src.length, dst.length);
        System.arraycopy(src, 0, dst, 0, min);
        return dst;
    }

    @Override
    public String toString() {
        StringBuilder strResult = new StringBuilder();
        for (int i = 0;i<this.vector.length;i++){
            strResult.append("[").append(i).append("]").append(": ").append(this.vector[i]).append("\n");
        }
        return strResult.toString();
    }

    public Vector(T[] array){
        this.vector =  (T[]) new Object[array.length];
        System.arraycopy(array, 0, this.vector, 0,array.length);
    }

    public Vector(int capacity,T defalt){
        this.vector = (T[]) new Object[capacity];
        for(int i = 0;i < capacity;i++){
            this.vector[i] = defalt;
        }
    }

    public T get(int position){
        return this.vector[position];
    }

    public void set(int position,T value){
        if (position >= 0 && position < this.vector.length){
            this.vector[position] = value;
            return;
        }
        System.out.println("Out of range");
    }

    public void pushBack(T value){
        T[] temp = (T[]) new Object[this.vector.length + 1];
        copy(this.vector, temp);
        temp[temp.length - 1] = value;
        this.vector = temp;
    }

    public T popBack(){
        T forReturn = this.vector[this.vector.length - 1];
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[this.vector.length - 1];
        copy(this.vector, temp);
        this.vector = temp;
        return forReturn;
    }

}