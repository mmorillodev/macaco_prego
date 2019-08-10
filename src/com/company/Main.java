package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public final ScannerUtils scanner;

    public Main() {
        scanner = new ScannerUtils();
    }

    public static void main(String[] args) {
        new Main().main();
    }

    public void main() {
        List<int[][]> tests = new ArrayList<>(5);
        int qtd = 0;

        do {
            qtd = scanner.getInt("\nType the number of rectangles: ", i -> i >= 0 && i <= 10000);
        } while(getTest(tests, qtd));

        System.out.println(tests.toString());
    }

    public boolean getTest(List<int[][]> tests, int qtd) {
        if(qtd == 0)
            return false;

        int[][] coordinates = new int[qtd][4];
        tests.add(coordinates);

        for (int i = 0; i < coordinates.length; i++) {
            System.out.println("\n-------------------------------------------------");
            for (int j = 0; j < coordinates[i].length; j++) {
                coordinates[i][j] =
                        scanner.getInt(
                                "\nType coordinate " + getCoordenateChar(j) + " for rectangle " + (i + 1) + ": ",
                                n -> n >= -10000 && n <= 10000
                        );
            }
        }

        return true;
    }

    public char getCoordenateChar(int index) {
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