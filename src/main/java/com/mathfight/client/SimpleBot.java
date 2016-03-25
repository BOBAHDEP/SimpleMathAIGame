package com.mathfight.client;

public class SimpleBot implements Player {
    public int choose(Integer[] array) {
        if (array[array.length-1] > array[0]) {
            return 1;
        } else {
            return 0;
        }
    }
}
