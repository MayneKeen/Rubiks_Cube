package com.keenpro;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rubicks_cubeTest {
    @Test
    void randomize() {
        Rubicks_cube cube = new Rubicks_cube();
        cube.randomize();

        for (Colour[] arr : cube.getFront()) {
            for (Colour colour : arr) {
                assertFalse(colour == null);
            }
        }
        for (Colour[] arr : cube.getBack()) {
            for (Colour colour : arr) {
                assertFalse(colour == null);
            }
        }
        for (Colour[] arr : cube.getLeft()) {
            for (Colour colour : arr) {
                assertFalse(colour == null);
            }
        }
        for (Colour[] arr : cube.getRight()) {
            for (Colour colour : arr) {
                assertFalse(colour == null);
            }
        }
        for (Colour[] arr : cube.getUpper()) {
            for (Colour colour : arr) {
                assertFalse(colour == null);
            }
        }
        for (Colour[] arr : cube.getLower()) {
            for (Colour colour : arr) {
                assertFalse(colour == null);
            }
        }
    }


    //if common [turnTo()] method is correct then all [turnTo*() methods are correct (Im 2 lazy 2 make 12 mor tests)


    @Test
    void turnToLeft() {
        Rubicks_cube defaultCube = new Rubicks_cube();

        Rubicks_cube cube = new Rubicks_cube();
        cube.turnToLeft();

        Colour[][] front = cube.getFront();
        Colour[][] back = cube.getBack();
        Colour[][] left = cube.getLeft();
        Colour[][] right = cube.getRight();
        Colour[][] upper = cube.getUpper();
        Colour[][] lower = cube.getLower();

        Colour[][] defFront = defaultCube.getFront();
        Colour[][] defBack = defaultCube.getBack();
        Colour[][] defLeft = defaultCube.getLeft();
        Colour[][] defRight = defaultCube.getRight();
        Colour[][] defUpper = defaultCube.getUpper();
        Colour[][] defLower = defaultCube.getLower();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(front[i][j] == defRight[i][j] && left[i][j] == defFront[i][j] &&
                        back[i][j] == defLeft[i][j] && right[i][j] == defBack[i][j] &&
                        upper[i][j] == Rubicks_cube.transposeLeft(defUpper)[i][j] &&
                        lower[i][j] == Rubicks_cube.transposeRight(defLower)[i][j]);

            }
        }
    }


    @Test
    void turnToRight() {
        Rubicks_cube defaultCube = new Rubicks_cube();

        Rubicks_cube cube = new Rubicks_cube();
        cube.turnToRight();

        Colour[][] front = cube.getFront();
        Colour[][] back = cube.getBack();
        Colour[][] left = cube.getLeft();
        Colour[][] right = cube.getRight();
        Colour[][] upper = cube.getUpper();
        Colour[][] lower = cube.getLower();

        Colour[][] defFront = defaultCube.getFront();
        Colour[][] defBack = defaultCube.getBack();
        Colour[][] defLeft = defaultCube.getLeft();
        Colour[][] defRight = defaultCube.getRight();
        Colour[][] defUpper = defaultCube.getUpper();
        Colour[][] defLower = defaultCube.getLower();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(front[i][j] == defLeft[i][j] && left[i][j] == defBack[i][j] &&
                        back[i][j] == defRight[i][j] && right[i][j] == defFront[i][j] &&
                        upper[i][j] == Rubicks_cube.transposeRight(defUpper)[i][j] &&
                        lower[i][j] == Rubicks_cube.transposeLeft(defLower)[i][j]);

            }
        }
    }


    @Test
    void turnToUp() {
        Rubicks_cube defaultCube = new Rubicks_cube();

        Rubicks_cube cube = new Rubicks_cube();
        cube.turnToUp();

        defaultCube.turnPlaneToLeft();
        defaultCube.turnToLeft();
        defaultCube.turnPlaneToRight();

        assertTrue(cube.equals(defaultCube));
    }

    @Test
    void turnToDown() {
        Rubicks_cube defaultCube = new Rubicks_cube();

        Rubicks_cube cube = new Rubicks_cube();
        cube.turnToDown();

        defaultCube.turnPlaneToRight();
        defaultCube.turnToLeft();
        defaultCube.turnPlaneToLeft();

        assertTrue(cube.equals(defaultCube));
    }

    @Test
    void turnPlaneToLeft() {
        Rubicks_cube defaultCube = new Rubicks_cube();

        Rubicks_cube cube = new Rubicks_cube();
        cube.turnPlaneToLeft();

        defaultCube.turnToLeft();
        defaultCube.turnToUp();
        defaultCube.turnToRight();

        assertTrue(cube.equals(defaultCube));
    }

    @Test
    void turnPlaneToRight() {
        Rubicks_cube defaultCube = new Rubicks_cube();

        Rubicks_cube cube = new Rubicks_cube();
        cube.turnPlaneToRight();

        defaultCube.turnToRight();
        defaultCube.turnToUp();
        defaultCube.turnToLeft();

        assertTrue(cube.equals(defaultCube));
    }
}



