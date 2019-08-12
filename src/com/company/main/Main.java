package com.company.main;

import com.company.utils.ScannerUtils;

import java.util.LinkedList;
import java.util.List;

public class Main {

    private final ScannerUtils scanner;

    private final int AXIS_QTD;

    private Main() {
        scanner = new ScannerUtils();
        AXIS_QTD = 4;
    }

    public static void main(String[] args) {
        new Main().main();
    }

    private void main() {
        List<AreaDelimiterTest> tests = new LinkedList<>();
        int qtd;

        do
            qtd = scanner.getInt("\nType the number of rectangles: ", i -> i >= 0 && i <= 10000);
        while(fillTestList(tests, qtd));

        scanner.clearBuffer();

        char resp = scanner.getString(
                "\nWould you like to review the input? [Y]es [N]o\n",
                c -> c.equalsIgnoreCase("y") || c.equalsIgnoreCase("n")
        ).charAt(0);

        resp = String.valueOf(resp).toLowerCase().charAt(0);

        if(resp == 'y') {
            System.out.println("---------------INPUT--------------");
            System.out.println(tests.toString());
        }

        scanner.close();

        System.out.println("---------------RESULT--------------");

        for(AreaDelimiterTest test : tests) {
            System.out.println(test.getName() + ": ");

            Area response = test.getIntersection();

            if(response == null) {
                System.out.println("None");
                continue;
            }

            System.out.println(response.toString());
        }
    }

    private boolean fillTestList(List<AreaDelimiterTest> tests, int areasQtd) {
        if(areasQtd == 0)
            return false;

        double coordinate;
        AreaDelimiterTest test = new AreaDelimiterTest(areasQtd);
        test.setName("Test " + (tests.size() + 1));
        tests.add(test);

        for (int i = 0; i < areasQtd; i++) {
            System.out.println("\n-------------------------------------------------");
            test.addArea(new Area());
            for (int j = 0; j < AXIS_QTD; j++) {
                coordinate = scanner.getDouble(
                        "\nType coordinate " + getCoordinateChar(j) + " for rectangle " + (i + 1) + ": ",
                        n -> n >= -10000 && n <= 10000
                );
                setAreaAxis(test.getArea(i), j, coordinate);
            }
        }
        return true;
    }

    private void setAreaAxis(Area area, int i, double value) {
        switch (i) {
            case 0:
                area.setXAxis(value);
                break;
            case 1:
                area.setYAxis(value);
                break;
            case 2:
                area.setUAxis(value);
                break;
            case 3:
                area.setVAxis(value);
                break;
        }
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