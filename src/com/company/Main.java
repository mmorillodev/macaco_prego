package com.company;

import java.util.ArrayList;
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

        scanner.close();

        System.out.println(toString(tests));
    }

    private boolean fillTestList(List<List<List<Double>>> tests, int qtd) {
        if(qtd == 0)
            return false;

        List<List<Double>> coordinates = new ArrayList<>(qtd);
        tests.add(coordinates);

        for (int i = 0; i < qtd; i++) {
            System.out.println("\n-------------------------------------------------");
            coordinates.add(new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                coordinates.get(i).add(
                        scanner.getDouble(
                            "\nType coordinate " + getCoordinateChar(j) + " for rectangle " + (i + 1) + ": ",
                            n -> n >= -10000 && n <= 10000
                        )
                );
            }
        }
        return true;
    }

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