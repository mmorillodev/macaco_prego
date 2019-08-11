package com.company;

import java.util.ArrayList;
import java.util.List;

public class AreaDelimiterTest {
    private List<Area> areas;
    private String     name;

    public AreaDelimiterTest(int areasQtd) {
        areas = new ArrayList<>(areasQtd);
    }

    public void setName(String testName) {
        this.name = testName;
    }

    public String getName() {
        return name;
    }

    public void addArea(Area area) {
        areas.add(area);
    }

    public Area getArea(int i) {
        return areas.get(i);
    }

    public int getAreasNumber() {
        return areas.size();
    }

    public double[] getIntersection() {
        return null;
    }

    @Override
    public String toString() {
        return areas.toString();
    }
}
