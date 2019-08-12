package com.company.main;

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
        this.xAxis = 0;
        this.yAxis = 0;
        this.uAxis = 0;
        this.vAxis = 0;
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

    public Area orderAxis() {
        double aux;

        if(this.xAxis > this.uAxis) {
            aux = this.uAxis;
            this.uAxis = this.xAxis;
            this.xAxis = aux;
        }
        if(this.yAxis < this.vAxis) {
            aux = this.vAxis;
            this.vAxis = this.yAxis;
            this.yAxis = aux;
        }

        return this;
    }

    @Override
    public String toString() {
        return "[X axis: " + xAxis + ", " +
                "Y axis: " + yAxis + ", " +
                "U axis: " + uAxis + ", " +
                "V axis: " + vAxis + "]";
    }
}
