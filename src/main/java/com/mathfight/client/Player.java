package com.mathfight.client;

public interface Player {
    /**
     * method determines ai step
     * @param array     input data
     * @return          1: last number, 0: first number, any other: error
     */
    public int choose(Integer[] array);
}
