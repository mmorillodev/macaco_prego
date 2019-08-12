package com.company;

public class Area {
    private double xAxis;
    private double yAxis;
    private double uAxis;
    private double vAxis;

    public Area(double x, double y, double u, double v) {
        this.xAxis = x;
        this.yAxis = y;
        this.uAxis = u;
        this.vAxis = v;
    }

    public Area() {

    }

    public Area setXAxis(double xAxis) {
        this.xAxis = xAxis;
        return this;
    }

    public double getXAxis() {
        return this.xAxis;
    }

    public Area setYAxis(double yAxis) {
        this.yAxis = yAxis;
        return this;
    }

    public double getYAxis() {
        return this.yAxis;
    }

    public Area setUAxis(double uAxis) {
        this.uAxis = uAxis;
        return this;
    }

    public double getUAxis() {
        return this.uAxis;
    }

    public Area setVAxis(double vAxis) {
        this.vAxis = vAxis;
        return this;
    }

    public double getVAxis() {
        return this.vAxis;
    }

    @Override
    public String toString() {
        return "[X axis: " + xAxis + ", " +
                "Y axis: " + yAxis + ", " +
                "U axis: " + uAxis + ", " +
                "V axis: " + vAxis + "]";
    }
}
