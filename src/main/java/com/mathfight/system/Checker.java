package com.mathfight.system;

import com.mathfight.client.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Checker {

    public static final int MIN_SIZE = 10;
    public static final int ARRAY_LENGTH = 90;
    public static final int MAX_NUMBER_VALUE = 1000;

    private List<Integer> numbers;
    private int length;

    private Player player1;
    private Player player2;
    private int player1Score = 0;
    private int player2Score = 0;

    public Checker(Player player1, Player player2) {
        final Random random = new Random();
        this.player1 = player1;
        this.player2 = player2;
        length = random.nextInt(ARRAY_LENGTH) + MIN_SIZE;
        if (length%2 == 1) {
            length++;
        }
        numbers = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            numbers.add(random.nextInt(MAX_NUMBER_VALUE));
        }
    }

    private void print() {
        System.out.println(numbers);
    }

    private void deleteLast() {
        numbers.remove(--length);
    }

    private void deleteFirst() {
        numbers.remove(0);
        length--;
    }

    private Integer[] getArray() {
        Integer[] res = new Integer[0];
        return numbers.toArray(res);
    }

    public String play() {

        while (length > 0) {
            player1Score += step(player1);
            player2Score += step(player2);
        }
        if (player1Score > player2Score) {
            return "1 wins! " + player1Score + " : " + player2Score;
        } else if (player1Score < player2Score){
            return "2 wins! " + player1Score + " : " + player2Score;
        } else {
            return "draw!";
        }
    }

    private int step(Player player) {
        int res, chose = player.choose(getArray());
        if (chose == 1) {
            res = numbers.get(length-1);
            deleteLast();
            return res;
        } else if (chose == 0) {
            res = numbers.get(0);
            deleteFirst();
            return res;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getStatistics() {
        int amountOfFirstPlayerVictories = 0;
        int amountOfSecondPlayerVictories = 0;

        for (int i = 0; i < 1000; i++) {
            update();
            String playRes = play();
            if (playRes.startsWith("1")) {
                amountOfFirstPlayerVictories++;
            } else if (playRes.startsWith("2")) {
                amountOfSecondPlayerVictories++;
            }
        }

        return "Results are: " + amountOfFirstPlayerVictories + "(1) : " + amountOfSecondPlayerVictories + "(2)";
    }

    private void update() {
        final Random random = new Random();
        length = random.nextInt(ARRAY_LENGTH) + MIN_SIZE;
        if (length%2 == 1) {
            length++;
        }
        numbers = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            numbers.add(random.nextInt(MAX_NUMBER_VALUE));
        }
        player2Score = 0;
        player1Score = 0;
    }

}
