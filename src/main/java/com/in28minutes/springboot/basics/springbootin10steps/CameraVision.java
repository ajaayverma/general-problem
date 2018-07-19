package com.in28minutes.springboot.basics.springbootin10steps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CameraVision {
    public static double getCameraAngle(double scopeAngle, double visionDistance, List<Tree> trees) {
        if (trees.isEmpty()) {
            return 0.0;
        }
        setAngleAndDistanceOfTrees(trees);

        // Below 4 lines are just to show cartesian coordinate of trees in a tabular form
        /*System.out.println("Distance       "+"Angle");
        System.out.println("========================");
        trees.forEach(tree -> System.out.println(tree.getDistance() + "         "+tree.getAngle()));
        System.out.println();*/

        double angleIncrement = 0;
        double angle1 = 0;
        double angle2 = scopeAngle;
        int largest = 0;
        double resultAngle = 0;
        int counter;
        while (angle2 <= 360) {
            counter = 0;
            for (Tree tree : trees) {
                if (tree.getAngle() >= angle1 && tree.getAngle() <= angle2 && tree.getDistance() <= visionDistance) {
                    counter++;
                }
            }
            if (counter > largest) {
                largest = counter;
                resultAngle = angle1;
            }
            angleIncrement += 0.0001; //incrementing angle by 0.0001 because we have assumed and set tree's angle accurate upto 4 decimal places
            angle1 = angle1 + angleIncrement;
            angle2 = angle2 + angleIncrement;
        }
        return truncateDecimal(resultAngle).doubleValue();
    }

    private static void setAngleAndDistanceOfTrees(List<Tree> trees) {
        for (Tree tree : trees) {
            final double treeAngle = truncateDecimal(Math.toDegrees(Math.atan(tree.getY() / tree.getX()))).doubleValue();
            if (treeAngle < 0) {
                tree.setAngle(360 + treeAngle); //Making angle positive when angle of tree is grater than 180 degrees
            } else {
                tree.setAngle(treeAngle);
            }
            tree.setDistance(truncateDecimal(Math.sqrt(tree.getX() * tree.getX() + tree.getY() + tree.getY())).doubleValue());
        }
    }

    private static BigDecimal truncateDecimal(double x) { // Helper method to clip decimal places
        if (x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(4, BigDecimal.ROUND_FLOOR); // truncating value to 4 decimal places
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(4, BigDecimal.ROUND_CEILING);
        }
    }

   /* public static void main(String[] args) {
        Tree tree;
        List<Tree> trees = new ArrayList<>();
        tree = new Tree(12.5, 32.42);
        trees.add(tree);
        tree = new Tree(13.5, 32.42);
        trees.add(tree);
        tree = new Tree(15.5, 32.42);
        trees.add(tree);
        tree = new Tree(16.5, 32.42);
        trees.add(tree);
        tree = new Tree(-22.5, 42.322);
        trees.add(tree);
        tree = new Tree(632.5, -332.22);
        trees.add(tree);
        tree = new Tree(-123.5323, -82.432);
        trees.add(tree);
        tree = new Tree(-22.5, 62.82);
        trees.add(tree);
        tree = new Tree(120.5, 142.432);
        trees.add(tree);

        System.out.println("Required Camera angle : "+CameraVision.getCameraAngle( 15.8, 90, trees));
    }*/

}
