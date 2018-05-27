package com.codecool.dynamicArrayDojo;

import java.util.StringJoiner;

// put your code here!
public class DynamicIntArray {

    int[] array;
    int length;

    public DynamicIntArray() {

        this(2);
    }

    public DynamicIntArray(int initSize) {

        array = new int[initSize];
        length = 0;
    }

    public void add(int elem) {

        resizeIfNeeded();
        array[length++] = elem;
    }

    public void insert(int index, int elem) {

        if (index >= length) {
            add(elem);

        } else {
            int[] bigger = new int[array.length + 1];

            for (int i = 0, j = 0; i < bigger.length;) {
                if (i == index) {
                    bigger[i++] = elem;
                } else {
                    bigger[i++] = array[j++];
                }
            }

            array = bigger;
            length++;
        }
    }

    public void remove(int elem) {

        int index = findIndex(elem);

        if (index >= 0) {
            int[] smaller = new int[array.length - 1];

            for (int i = 0, j = 0; i < smaller.length; i++, j++) {
                if (i == index) {
                    j++;
                }
                smaller[i] = array[j];
            }

            array = smaller;
            length--;
        }
        else {
            throw new ArrayIndexOutOfBoundsException("element not present in the array");
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        for (int elem : array) {
            sj.add(String.valueOf(elem));
        }
        return sj.toString();
    }

    private void resizeIfNeeded() {
        if (length == array.length) {
            int[] bigger = new int[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                bigger[i] = array[i];
            }
            array = bigger;
        }
    }

    private int findIndex(int elem) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elem) {
                return i;
            }
        }
        return -1;
    }
}
