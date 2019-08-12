package com.company.main;

import javax.xml.transform.Templates;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AreaDelimiterTest {
    private List<Area> areas;
    private String     name;

    public AreaDelimiterTest(int areasQtd) {
        areas = new ArrayList<>(areasQtd);
    }

    public AreaDelimiterTest() {
        areas = new LinkedList<>();
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

    public void clearAreas() {
        areas.clear();
    }

    public void popArea() {
        areas.remove(areas.size() - 1);
    }

    public void removeArea(int i){
        areas.remove(i);
    }

    public Area getIntersection() {
        return getIntersection(true);
    }

    private Area getIntersection(boolean checkArea) {
        double biggerX = areas.get(0).getXAxis();
        double smallestY = areas.get(0).getYAxis();
        double smallestU = areas.get(0).getUAxis();
        double biggerV = areas.get(0).getVAxis();

        for(Area area : areas) {
            area.orderAxis();

            if(area.getXAxis() > biggerX)
                biggerX = area.getXAxis();
            if(area.getYAxis() < smallestY)
                smallestY = area.getYAxis();
            if(area.getUAxis() < smallestU)
                smallestU = area.getUAxis();
            if(area.getVAxis() > biggerV)
                biggerV = area.getVAxis();
        }

        Area resultant = new Area(biggerX, smallestY, smallestU, biggerV).orderAxis();
        if(checkArea)
            return checkInnerArea(resultant);
        return resultant;
    }

    private Area checkInnerArea(Area area) {
        AreaDelimiterTest test = new AreaDelimiterTest();
        Area resultant;

        for(Area areaI : this.areas) {
            test.clearAreas();
            test.addArea(area);
            test.addArea(areaI);

            resultant = test.getIntersection(false);

            if(area.getXAxis() != resultant.getXAxis()
                    || area.getYAxis() != resultant.getYAxis()
                    || area.getUAxis() != resultant.getUAxis()
                    || area.getVAxis() != resultant.getVAxis())
                return null;
        }

        return area;
    }

    @Override
    public String toString() {
        return areas.toString();
    }
}
