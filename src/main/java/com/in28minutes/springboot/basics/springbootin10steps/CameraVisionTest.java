package com.in28minutes.springboot.basics.springbootin10steps;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CameraVisionTest {

    @Test
    public void testCameraVision(){
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

      // System.out.println(CameraVision.getCameraAngle(35.8,90,trees));
        assertEquals(53.1996,CameraVision.getCameraAngle( 15.8, 90, trees));
        assertEquals(33.1705,CameraVision.getCameraAngle(35.8,90,trees));
    }
}
