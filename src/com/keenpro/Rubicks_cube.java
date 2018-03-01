package com.keenpro;

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Rubicks_cube {

    private static Scanner in = new Scanner(System.in);
    private static PrintStream out = System.out;

    private String frontFace[][] = new String[3][3];
    private String backFace[][] = new String[3][3];
    private String leftFace[][] = new String[3][3];
    private String rightFace[][] = new String[3][3];
    private String upperFace[][] = new String[3][3];
    private String lowerFace[][] = new String[3][3];


    private HashMap<String, List<String>> vertexMap = new HashMap<String, List<String>>();


    public void randomize() throws Exception {
        int whiteCount = 9, yellowCount = 9, blueCount = 9, redCount = 9, orangeCount = 9, greenCount = 9;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                String frontColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                frontFace[i][j] = frontColour;
                switch (frontColour) {
                    case "white": {
                        whiteCount--;
                    }
                    case "yellow": {
                        yellowCount--;
                    }
                    case "blue": {
                        blueCount--;
                    }
                    case "red": {
                        redCount--;
                    }
                    case "orange": {
                        orangeCount--;
                    }
                    case "green": {
                        greenCount--;
                    }
                }


                String backColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                backFace[i][j] = backColour;
                switch (backColour) {
                    case "white": {
                        whiteCount--;
                    }
                    case "yellow": {
                        yellowCount--;
                    }
                    case "blue": {
                        blueCount--;
                    }
                    case "red": {
                        redCount--;
                    }
                    case "orange": {
                        orangeCount--;
                    }
                    case "green": {
                        greenCount--;
                    }
                }


                String leftColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                leftFace[i][j] = leftColour;
                switch (leftColour) {
                    case "white": {
                        whiteCount--;
                    }
                    case "yellow": {
                        yellowCount--;
                    }
                    case "blue": {
                        blueCount--;
                    }
                    case "red": {
                        redCount--;
                    }
                    case "orange": {
                        orangeCount--;
                    }
                    case "green": {
                        greenCount--;
                    }
                }

                String rightColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                rightFace[i][j] = rightColour;
                switch (rightColour) {
                    case "white": {
                        whiteCount--;
                    }
                    case "yellow": {
                        yellowCount--;
                    }
                    case "blue": {
                        blueCount--;
                    }
                    case "red": {
                        redCount--;
                    }
                    case "orange": {
                        orangeCount--;
                    }
                    case "green": {
                        greenCount--;
                    }
                }

                String upperColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                upperFace[i][j] = upperColour;
                switch (upperColour) {
                    case "white": {
                        whiteCount--;
                    }
                    case "yellow": {
                        yellowCount--;
                    }
                    case "blue": {
                        blueCount--;
                    }
                    case "red": {
                        redCount--;
                    }
                    case "orange": {
                        orangeCount--;
                    }
                    case "green": {
                        greenCount--;
                    }
                }

                String lowerColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                lowerFace[i][j] = lowerColour;
                switch (lowerColour) {
                    case "white": {
                        whiteCount--;
                    }
                    case "yellow": {
                        yellowCount--;
                    }
                    case "blue": {
                        blueCount--;
                    }
                    case "red": {
                        redCount--;
                    }
                    case "orange": {
                        orangeCount--;
                    }
                    case "green": {
                        greenCount--;
                    }
                }


            }
        }
    }


    private static String randomColour(int whiteCount, int yellowCount, int blueCount,
                                       int redCount, int orangeCount, int greenCount) throws Exception {

        int r = (int) (Math.random() * 100);

        if (r < 17 && whiteCount > 0) return "white";
        else if (whiteCount < 1 && r < 17) return randomColour(0, yellowCount,
                blueCount, redCount, orangeCount, greenCount);

        if (r < 33 && yellowCount > 0) return "yellow";
        else if (yellowCount < 1 && r < 33) return randomColour(whiteCount, 0,
                blueCount, redCount, orangeCount, greenCount);

        if (r < 50 && blueCount > 0) return "blue";
        else if (blueCount < 1 && r < 50) return randomColour(whiteCount, yellowCount,
                0, redCount, orangeCount, greenCount);

        if (r < 67 && redCount > 0) return "red";
        else if (redCount < 1 && r < 67) return randomColour(whiteCount, yellowCount,
                blueCount, 0, orangeCount, greenCount);

        if (r < 83 && orangeCount > 0) return "orange";
        else if (orangeCount < 1 && r < 83) return randomColour(whiteCount, yellowCount,
                blueCount, redCount, 0, greenCount);

        if (r < 100 && greenCount > 0) return "green";
        else if (whiteCount < 1 && r < 100) return randomColour(whiteCount, yellowCount,
                blueCount, redCount, orangeCount, 0);

        throw new Exception("Incorrect randomColour method");
    }


    public Rubicks_cube() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.frontFace[i][j] = "white";
                this.backFace[i][j] = "yellow";
                this.leftFace[i][j] = "blue";
                this.rightFace[i][j] = "red";
                this.upperFace[i][j] = "orange";
                this.lowerFace[i][j] = "green";
            }
        }


    }


    private void standartSet() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                frontFace[i][j] = "white";
                backFace[i][j] = "yellow";
                leftFace[i][j] = "blue";
                rightFace[i][j] = "red";
                upperFace[i][j] = "orange";
                lowerFace[i][j] = "green";
            }
        }
    }


    public void turnLeft1() {

        for (int j = 0; j < 3; j++) {
            String temp = frontFace[1][j];
            frontFace[0][j] = rightFace[0][j];
            rightFace[0][j] = backFace[0][j];
            backFace[0][j] = leftFace[0][j];
            leftFace[0][j] = temp;
        }
        String a = upperFace[2][0];
        String b = upperFace[2][1];

        upperFace[2][0] = upperFace[2][2];
        upperFace[2][1] = upperFace[1][2];
        upperFace[2][2] = upperFace[0][2];

        upperFace[1][2] = upperFace[0][1];
        upperFace[0][2] = upperFace[0][0];

        upperFace[0][1] = upperFace[1][0];
        upperFace[0][0] = a;
        upperFace[1][0] = b;
    }


    public void turnLeft2() {
        for (int j = 0; j < 3; j++) {
            String temp = frontFace[1][j];
            frontFace[1][j] = rightFace[1][j];
            rightFace[1][j] = backFace[1][j];
            backFace[1][j] = leftFace[1][j];
            leftFace[1][j] = temp;
        }
    }

    public void turnLeft3() {
        for (int j = 0; j < 3; j++) {
            String temp = frontFace[2][j];
            frontFace[2][j] = rightFace[2][j];
            rightFace[2][j] = backFace[2][j];
            backFace[2][j] = leftFace[2][j];
            leftFace[2][j] = temp;
        }
        String a = lowerFace[2][0];
        String b = lowerFace[2][1];

        lowerFace[2][0] = lowerFace[2][2];
        lowerFace[2][1] = lowerFace[1][2];
        lowerFace[2][2] = lowerFace[0][2];

        lowerFace[1][2] = lowerFace[0][1];
        lowerFace[0][2] = lowerFace[0][0];

        lowerFace[0][1] = lowerFace[1][0];
        lowerFace[0][0] = a;
        lowerFace[1][0] = b;
    }


    public void turnToLeft() {
        turnLeft1();
        turnLeft2();
        turnLeft3();
    }







    public void turnRight1() {
        for(int j=0; j<3; j++) {
            String temp = frontFace[0][j];
            frontFace[0][j] = leftFace[0][j];
            leftFace[0][j] = backFace[0][j];
            backFace[0][j] = rightFace[0][j];
            rightFace[0][j] = temp;
        }
        String a = upperFace[2][1];
        String b = upperFace[2][2];

        upperFace[2][2] = upperFace[2][0];
        upperFace[2][1] = upperFace[1][0];
        upperFace[2][0] = upperFace[0][0];

        upperFace[1][0] = upperFace[0][1];
        upperFace[0][0] = upperFace[0][2];

        upperFace[0][1] = upperFace[1][2];
        upperFace[0][2] = b;
        upperFace[1][2] = a;
    }

    public void turnRight2() {
        for(int j=0; j<3; j++) {
            String temp = frontFace[1][j];
            frontFace[1][j] = leftFace[1][j];
            leftFace[1][j] = backFace[1][j];
            backFace[1][j] = rightFace[1][j];
            rightFace[1][j] = temp;
        }
    }

    public void turnRight3() {
        for(int j=0; j<3; j++) {
            String temp = frontFace[2][j];
            frontFace[2][j] = leftFace[2][j];
            leftFace[2][j] = backFace[2][j];
            backFace[2][j] = rightFace[2][j];
            rightFace[2][j] = temp;
        }
        String a = upperFace[2][0];
        String b = upperFace[2][1];

        upperFace[2][0] = upperFace[2][2];
        upperFace[2][1] = upperFace[1][2];
        upperFace[2][2] = upperFace[0][2];

        upperFace[1][2] = upperFace[0][1];
        upperFace[0][2] = upperFace[0][0];

        upperFace[0][1] = upperFace[1][0];
        upperFace[0][0] = a;
        upperFace[1][0] = b;
    }

    public void turnToRight() {
        turnRight1();
        turnRight2();
        turnRight3();
    }






    public void turnUp1() {
        for(int i = 0; i<3; i++) {
            String temp = frontFace[i][0];
            frontFace[i][0] = lowerFace[2-i][0];
            lowerFace[i][0] = backFace[i][2];
            backFace[2-i][2] = upperFace[i][0];
            upperFace[i][0] = temp;
        }
        String a = leftFace[2][1];
        String b = leftFace[2][2];

        leftFace[2][2] = leftFace[2][0];
        leftFace[2][1] = leftFace[1][0];
        leftFace[2][0] = leftFace[0][0];

        leftFace[1][0] = leftFace[0][1];
        leftFace[0][0] = leftFace[0][2];

        leftFace[0][1] = leftFace[1][2];
        leftFace[0][2] = b;
        leftFace[1][2] = a;
    }

    public void turnUp2() {
        for(int i = 0; i<3; i++) {
            String temp = frontFace[i][1];
            frontFace[i][1] = lowerFace[2-i][1];
            lowerFace[i][1] = backFace[i][1];
            backFace[2-i][1] = rightFace[i][1];
            rightFace[i][1] = temp;
        }
    }

    public void turnUp3() {
        for(int i = 0; i<3; i++) {
            String temp = frontFace[i][2];
            frontFace[i][2] = lowerFace[2-i][2];
            lowerFace[i][2] = backFace[i][0];
            backFace[2-i][0] = upperFace[i][2];
            upperFace[i][2] = temp;
        }
        String a = rightFace[2][0];
        String b = rightFace[2][1];

        rightFace[2][0] = rightFace[2][2];
        rightFace[2][1] = rightFace[1][2];
        rightFace[2][2] = rightFace[0][2];

        rightFace[1][2] = rightFace[0][1];
        rightFace[0][2] = rightFace[0][0];

        rightFace[0][1] = rightFace[1][0];
        rightFace[0][0] = a;
        rightFace[1][0] = b;
    }


    public void turnToUp() {
        turnUp1();
        turnUp2();
        turnUp3();
    }






    public void turnDown1() {
        for(int i=0; i<3;i++) {
            String temp = frontFace[i][0];
            frontFace[i][0] = upperFace[i][0];
            upperFace[i][0] = backFace[2-i][2];
            backFace[i][2] = lowerFace[i][0];
            lowerFace[2-i][0] = temp;
        }
        String a = leftFace[2][0];
        String b = leftFace[2][1];

        leftFace[2][0] = leftFace[2][2];
        leftFace[2][1] = leftFace[1][2];
        leftFace[2][2] = leftFace[0][2];

        leftFace[1][2] = leftFace[0][1];
        leftFace[0][2] = leftFace[0][0];

        leftFace[0][1] = leftFace[1][0];
        leftFace[0][0] = a;
        leftFace[1][0] = b;
    }

    public void turnDown2() {
        for(int i=0; i<3;i++) {
            String temp = frontFace[i][1];
            frontFace[i][1] = upperFace[i][1];
            upperFace[i][1] = backFace[2-i][1];
            backFace[i][1] = lowerFace[i][1];
            lowerFace[2-i][1] = temp;
        }
    }

    public void turnDown3() {
        for(int i=0; i<3;i++) {
            String temp = frontFace[i][2];
            frontFace[i][2] = upperFace[i][2];
            upperFace[i][2] = backFace[2-i][0];
            backFace[i][0] = lowerFace[i][2];
            lowerFace[2-i][2] = temp;
        }
        String a = rightFace[2][1];
        String b = rightFace[2][2];

        rightFace[2][2] = rightFace[2][0];
        rightFace[2][1] = rightFace[1][0];
        rightFace[2][0] = rightFace[0][0];

        rightFace[1][0] = rightFace[0][1];
        rightFace[0][0] = rightFace[0][2];

        rightFace[0][1] = rightFace[1][2];
        rightFace[0][2] = b;
        rightFace[1][2] = a;
    }

    public void turnToDown() {
        turnDown1();
        turnDown2();
        turnDown3();
    }





    public void getFront() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                out.println(frontFace[i][j]);
            }
        }
    }

    public void getBack() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                out.println(backFace[i][j]);
            }
        }
    }

    public void getLeft() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                out.println(leftFace[i][j]);
            }
        }
    }

    public void getRight() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                out.println(rightFace[i][j]);
            }
        }
    }

    public void getUpper() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                out.println(upperFace[i][j]);
            }
        }
    }

    public void getLower() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                out.println(lowerFace[i][j]);
            }
        }
    }

    public void getAll() {
        getFront();
        getBack();
        getLeft();
        getRight();
        getUpper();
        getLower();
    }





    public static void main(String[] args) {


    }


}
