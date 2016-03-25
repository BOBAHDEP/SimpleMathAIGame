package com.mathfight.client;

import java.util.Random;

public class RandBot implements Player {
    final Random random = new Random();
    public int choose(Integer[] array) {
        if (random.nextBoolean()) {
            return 1;
        } else {
            return 0;
        }
    }
}
