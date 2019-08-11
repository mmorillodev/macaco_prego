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

    public void setXAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public double getXAxis() {
        return this.xAxis;
    }

    public void setYAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public double getYAxis() {
        return this.yAxis;
    }

    public void setUAxis(double xAxis) {
        this.xAxis = uAxis;
    }

    public double getUAxis() {
        return this.uAxis;
    }

    public void setVAxis(double xAxis) {
        this.xAxis = vAxis;
    }

    public double getVAxis() {
        return this.xAxis;
    }

    @Override
    public String toString() {
        return "[X axis: " + xAxis + ", " +
                "Y axis: " + yAxis + ", " +
                "U axis: " + uAxis + ", " +
                "V axis: " + vAxis + "]";
    }
}
