package com.company;

public class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        ScannerUtils scanner = new ScannerUtils();
        int qtd = scanner.getInt("Type the number of rectangles: ", i -> i > 0);
        if(qtd == 0) return;

        int[][] coordinates = new int[qtd][4];

        for(int i = 0; i < coordinates.length; i++) {
            for(int j = 0; j < coordinates[i].length; j++) {
                coordinates[i][j] =
                        scanner.getInt(
                                "\nType coordinate " + getCoordenateChar(j) + " for rectangle " + (i+1) + ": ",
                                n -> true
                        );
            }
        }
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