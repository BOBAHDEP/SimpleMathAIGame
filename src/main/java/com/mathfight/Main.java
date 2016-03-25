package com.mathfight;

import com.mathfight.client.RandBot;
import com.mathfight.client.SimpleBot;
import com.mathfight.system.Checker;

public class Main {
    public static void main(String[] args) {
        Checker checker = new Checker(new RandBot(), new SimpleBot());
        System.out.println(checker.getStatistics());
    }
}
