package com.company;

import java.util.function.Predicate;

public class Main implements  Predicate<Integer> {

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        ScannerUtils scanner = new ScannerUtils();
        scanner.getInt("Enter a valid integer: \n", this);
        scanner.getString("", s -> true);
        scanner.getString("Enter a String bigger than 0: \n", s -> s.length() > 0);
    }

    @Override
    public boolean test(Integer integer) {
        return integer >= 0;
    }
}