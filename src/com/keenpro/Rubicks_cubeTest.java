package com.keenpro;

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

    @Test
    void turnLeft1() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnLeft1();

    }

    @Test
    void turnLeft2() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnLeft2();
    }

    @Test
    void turnLeft3() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnLeft3();
    }


    @Test
    void turnRight1() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnRight1();
    }

    @Test
    void turnRight2() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnRight2();
    }

    @Test
    void turnRight3() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnRight3();
    }


    @Test
    void turnUp1() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnUp1();
    }

    @Test
    void turnUp2() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnUp2();
    }

    @Test
    void turnUp3() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnUp3();
    }


    @Test
    void turnDown1() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnDown1();
    }

    @Test
    void turnDown2() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnDown2();
    }

    @Test
    void turnDown3() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.turnDown3();
    }







}