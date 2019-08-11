package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private final ScannerUtils scanner;

    private Main() {
        scanner = new ScannerUtils();
    }

    public static void main(String[] args) {
        new Main().main();
    }

    private void main() {
        List<List<List<Double>>> tests = new LinkedList<>();
        int qtd;

        do {
            qtd = scanner.getInt("\nType the number of rectangles: ", i -> i >= 0 && i <= 10000);
        } while(fillTestList(tests, qtd));

        char resp = scanner.getChar("\nDo you want to revise the input? [Y]es [N]o\n");

        if(resp == 'y' || resp == 'Y') {
            System.out.println("---------------INPUT--------------");
            System.out.println(toString(tests));
        }

        scanner.close();

        System.out.println("---------------RESULT--------------");

        for(int i = 0; i < tests.size(); i++) {
            System.out.println("Test " + (i + 1) + ": ");
            System.out.println(Arrays.toString(getIntersection(tests.get(i))));
        }
    }

    private boolean fillTestList(List<List<List<Double>>> tests, int qtd) {
        if(qtd == 0)
            return false;

        List<List<Double>> rectangles = new ArrayList<>(qtd);
        tests.add(rectangles);

        for (int i = 0; i < qtd; i++) {
            System.out.println("\n-------------------------------------------------");
            rectangles.add(new ArrayList<>(4));
            for (int j = 0; j < 4; j++) {
                rectangles.get(i).add(
                        scanner.getDouble(
                            "\nType coordinate " + getCoordinateChar(j) + " for rectangle " + (i + 1) + ": ",
                            n -> n >= -10000 && n <= 10000
                        )
                );
            }
        }
        return true;
    }

    private double[] getIntersection(List<List<Double>> rectangles) {
        return new double[0];
    }

    //Debug
    private String toString(List<List<List<Double>>> tests) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < tests.size(); i++) {
            builder.append("Test ").append((i + 1)).append(":\n");
            for(int j = 0; j < tests.get(i).size(); j++) {
                builder.append("\tRectangle ").append((j + 1)).append(":\n");
                for(int k = 0; k < tests.get(i).get(j).size(); k++) {
                    builder.append("\t\t").append(getCoordinateChar(k)).append(": ").append(tests.get(i).get(j).get(k)).append("\n");
                }
            }
        }

        return builder.toString();
    }

    private char getCoordinateChar(int index) {
        switch (index) {
            case 0:
                return 'X';
            case 1:
                return 'Y';
            case 2:
                return 'U';
            case 3:
                return 'V';
            default:
                return ' ';
        }
    }
}