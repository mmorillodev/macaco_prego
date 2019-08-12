package com.company;

public class Test {

    public static void main(String[] args) {
        AreaDelimiterTest test = new AreaDelimiterTest(5);
        test.addArea(new Area().setUAxis(3.0).setXAxis(1).setYAxis(2).setVAxis(4));
        System.out.println(test.getArea(0).getXAxis());
        System.out.println(test.getArea(0).getYAxis());
        System.out.println(test.getArea(0).getUAxis());
        System.out.println(test.getArea(0).getVAxis());
    }
}
