/*package com.keenpro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rubicks_cubeTest {
    @Test
    void randomize() throws Exception {
        Rubicks_cube cube = new Rubicks_cube();
        cube.randomize();

        for(String[] arr: cube.getFront()) {
            for(String colour: arr) {
                if(colour == null) {
                    throw new Exception("What a Terrible Failure(front)");
                }
            }
        }
        for(String[] arr: cube.getBack()) {
            for(String colour: arr) {
                if(colour == null) {
                    throw new Exception("What a Terrible Failure(back)");
                }
            }
        }
        for(String[] arr: cube.getLeft()) {
            for(String colour: arr) {
                if(colour == null) {
                    throw new Exception("What a Terrible Failure(left)");
                }
            }
        }
        for(String[] arr: cube.getRight()) {
            for(String colour: arr) {
                if(colour == null) {
                    throw new Exception("What a Terrible Failure(right)");
                }
            }
        }
        for(String[] arr: cube.getLower()) {
            for(String colour: arr) {
                if(colour == null) {
                    throw new Exception("What a Terrible Failure(lower)");
                }
            }
        }
        for(String[] arr: cube.getUpper()) {
            for(String colour: arr) {
                if(colour == null) {
                    throw new Exception("What a Terrible Failure(upper)");
                }
            }
        }
    }



    //if common [turnTo()] method is correct then all [turnTo*() methods are correct (Im 2 lazy 2 make 12 mor tests)


    @Test
    void turnToLeft() throws Exception {
        Rubicks_cube defaultCube = new Rubicks_cube();

        Rubicks_cube cube = new Rubicks_cube();
        cube.turnToLeft();

        String[][] front = cube.getFront();
        String[][] back = cube.getBack();
        String[][] left = cube.getLeft();
        String[][] right = cube.getRight();
        String[][] upper = cube.getUpper();
        String[][] lower = cube.getLower();

        String[][] defFront = defaultCube.getFront();
        String[][] defBack = defaultCube.getBack();
        String[][] defLeft = defaultCube.getLeft();
        String[][] defRight = defaultCube.getRight();
        String[][] defUpper = defaultCube.getUpper();
        String[][] defLower = defaultCube.getLower();

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(front[i][j]!= defRight[i][j] || right[i][j] != defBack[i][j] ||
                        back[i][j] != defLeft[i][j] || left[i][j] != defFront[i][j]) {
                    throw new Exception("Incorrect turnToLeft() method");
                }
            }
        }
    }


    @Test
    void turnToRight() throws Exception {
        Rubicks_cube defaultCube = new Rubicks_cube();

        Rubicks_cube cube = new Rubicks_cube();
        cube.turnToRight();

        String[][] front = cube.getFront();
        String[][] back = cube.getBack();
        String[][] left = cube.getLeft();
        String[][] right = cube.getRight();
        String[][] upper = cube.getUpper();
        String[][] lower = cube.getLower();

        String[][] defFront = defaultCube.getFront();
        String[][] defBack = defaultCube.getBack();
        String[][] defLeft = defaultCube.getLeft();
        String[][] defRight = defaultCube.getRight();
        String[][] defUpper = defaultCube.getUpper();
        String[][] defLower = defaultCube.getLower();

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(front[i][j]!= defLeft[i][j] || right[i][j] != defFront[i][j] ||
                        back[i][j] != defRight[i][j] || left[i][j] != defBack[i][j]) {
                    throw new Exception("Incorrect turnToRight() method");
                }
            }
        }
    }


    @Test
    void turnToUp() throws Exception {
        Rubicks_cube defaultCube = new Rubicks_cube();

        Rubicks_cube cube = new Rubicks_cube();
        cube.turnToUp();

        String[][] front = cube.getFront();
        String[][] back = cube.getBack();
        String[][] left = cube.getLeft();
        String[][] right = cube.getRight();
        String[][] upper = cube.getUpper();
        String[][] lower = cube.getLower();

        String[][] defFront = defaultCube.getFront();
        String[][] defBack = defaultCube.getBack();
        String[][] defLeft = defaultCube.getLeft();
        String[][] defRight = defaultCube.getRight();
        String[][] defUpper = defaultCube.getUpper();
        String[][] defLower = defaultCube.getLower();

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(front[i][j] != defLower[i][j]) throw new Exception("Incorrect turnToUp() method");
                if(lower[i][j] != defBack[i][j]) throw new Exception("Incorrect turnToUp() method");
                if(back[i][j] != defUpper[i][j])throw new Exception("Incorrect turnToUp() method");
                if(upper[i][j] != defFront[i][j]) throw new Exception("Incorrect turnToUp() method");

                }
            }
        }


    @Test
    void turnToDown() throws Exception {
        Rubicks_cube defaultCube = new Rubicks_cube();

        Rubicks_cube cube = new Rubicks_cube();
        cube.turnToDown();

        String[][] front = cube.getFront();
        String[][] back = cube.getBack();
        String[][] left = cube.getLeft();
        String[][] right = cube.getRight();
        String[][] upper = cube.getUpper();
        String[][] lower = cube.getLower();

        String[][] defFront = defaultCube.getFront();
        String[][] defBack = defaultCube.getBack();
        String[][] defLeft = defaultCube.getLeft();
        String[][] defRight = defaultCube.getRight();
        String[][] defUpper = defaultCube.getUpper();
        String[][] defLower = defaultCube.getLower();

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(front[i][j] != defUpper[i][j])throw new Exception("Incorrect turnToDown() method");
                if(upper[i][j] != defBack[i][j]) throw new Exception("Incorrect turnToDown() method");
                if(back[i][j] != defLower[i][j])throw new Exception("Incorrect turnToDown() method");
                if(lower[i][j] != defFront[i][j]) throw new Exception("Incorrect turnToDown() method");
                }
            }
        }
    }



*/