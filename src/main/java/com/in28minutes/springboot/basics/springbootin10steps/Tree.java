package com.in28minutes.springboot.basics.springbootin10steps;

class Tree {
    private double x;
    private double y;
    private double angle;
    private double distance;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    Tree(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
