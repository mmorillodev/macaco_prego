package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class ScannerUtils {

    private Scanner scanner;

    public ScannerUtils() {
        this.scanner= new Scanner(System.in);
    }

    public int getInt(String message, Predicate<Integer> predicate) {
        int input;
        boolean retry = false;

        do {
            input = 0;
            if(retry) {
                scanner.nextLine();
                retry = false;
            }
            try {
                System.out.print(message);
                input = scanner.nextInt();
            } catch(InputMismatchException e) {
                retry = true;
            }
        } while(!predicate.test(input) || retry);
        return input;
    }

    public String getString(String message, Predicate<String> predicate) {
        String input;
        boolean retry = false;

        do {
            input = "";
            try {
                System.out.print(message);
                input = scanner.nextLine();
            } catch(InputMismatchException e) {
                retry = true;
            }
        } while(!predicate.test(input) || retry);
        return input;
    }

    public double getDouble(String message, Predicate<Double> predicate) {
        double input;
        boolean retry = false;

        do {
            input = 0.0;
            if(retry) {
                scanner.nextLine();
                retry = false;
            }
            try {
                System.out.print(message);
                input = scanner.nextDouble();
            } catch(InputMismatchException e) {
                retry = true;
            }
        } while(!predicate.test(input) || retry);
        return input;
    }

    public double getFloat(String message, Predicate<Float> predicate) {
        float input;
        boolean retry = false;

        do {
            input = 0.0f;
            if(retry) {
                scanner.nextLine();
                retry = false;
            }
            try {
                System.out.print(message);
                input = scanner.nextFloat();
            } catch(InputMismatchException e) {
                retry = true;
            }
        } while(!predicate.test(input) || retry);
        return input;
    }

    public double getByte(String message, Predicate<Byte> predicate) {
        byte input;
        boolean retry = false;

        do {
            input = 0;
            if(retry) {
                scanner.nextLine();
                retry = false;
            }
            try {
                System.out.print(message);
                input = scanner.nextByte();
            } catch(InputMismatchException e) {
                retry = true;
            }
        } while(!predicate.test(input) || retry);
        return input;
    }

    public char getChar(String message, Predicate<Character> predicate) {
        char input;
        boolean retry = false;

        do {
            input = 0;
            try {
                System.out.print(message);
                input = scanner.next().charAt(0);
            } catch(InputMismatchException e) {
                retry = true;
            }
        } while(!predicate.test(input) || retry);
        return input;
    }

    public void clearBuffer() {
        scanner.nextLine();
    }
}
