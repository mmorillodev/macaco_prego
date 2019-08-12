package com.company.test;

import com.company.main.Area;
import com.company.main.AreaDelimiterTest;

public class Test {

    public static void main(String[] args) {
        AreaDelimiterTest test = new AreaDelimiterTest(5);
        Area area = new Area();
        area.setXAxis(5).setYAxis(4).setUAxis(4).setVAxis(1);
        area.orderAxis();
        test.addArea(area);
        System.out.println("X: " + area.getXAxis());
        System.out.println("Y: " + area.getYAxis());
        System.out.println("U: " + area.getUAxis());
        System.out.println("V: " + area.getVAxis());
    }
}
