package com.keenpro;

import java.io.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Rubicks_cube {

    private static PrintStream out = System.out;

    private String frontFace[][] = new String[3][3];
    private String backFace[][] = new String[3][3];
    private String leftFace[][] = new String[3][3];
    private String rightFace[][] = new String[3][3];
    private String upperFace[][] = new String[3][3];
    private String lowerFace[][] = new String[3][3];


    private int whiteCount = 9;
    private int yellowCount = 9;
    private int blueCount = 9;
    private int redCount = 9;
    private int orangeCount = 9;
    private int greenCount = 9;

    private void colourCounter(String colour, int times) {
        switch (times) {
            case 1: {
                switch (colour) {
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
            case 2: {
                switch (colour) {
                    case "white": {
                        whiteCount-=2;
                    }
                    case "yellow": {
                        yellowCount-=2;
                    }
                    case "blue": {
                        blueCount-=2;
                    }
                    case "red": {
                        redCount-=2;
                    }
                    case "orange": {
                        orangeCount-=2;
                    }
                    case "green": {
                        greenCount-=2;
                    }
                }
            }
            case 3: {
                switch (colour) {
                    case "white": {
                        whiteCount-=3;
                    }
                    case "yellow": {
                        yellowCount-=3;
                    }
                    case "blue": {
                        blueCount-=3;
                    }
                    case "red": {
                        redCount-=3;
                    }
                    case "orange": {
                        orangeCount-=3;
                    }
                    case "green": {
                        greenCount-=3;
                    }
                }
            }
        }
    }

    public void randomize() throws Exception {


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                String frontColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                if(frontFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            frontFace[i][j] = frontColour;
                            upperFace[2][j] = frontColour;
                            colourCounter(frontColour, 2);
                        }
                        case 2: {
                            frontFace[i][j] = frontColour;
                            lowerFace[2][j] = frontColour;
                            colourCounter(frontColour, 2);
                        }
                        case 1: {
                            frontFace[i][j] = frontColour;
                            colourCounter(frontColour, 1);
                        }
                    }
                    switch (j) {
                        case 0:{
                            leftFace[i][2] = frontColour;
                            colourCounter(frontColour, 1);
                        }
                        case 2: {
                            rightFace[i][0] = frontColour;
                            colourCounter(frontColour, 1);
                        }
                    }
                }



                String backColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                if(backFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            backFace[i][j] = backColour;
                            upperFace[i][2-j] = backColour;
                            colourCounter(backColour, 2);
                        }
                        case 2: {
                            backFace[i][j] = backColour;
                            lowerFace[0][2-j]= backColour;
                            colourCounter(backColour, 2);
                        }
                        case 1: {
                            backFace[i][j] = backColour;
                            colourCounter(backColour, 1);
                        }
                    }
                    switch (j) {
                        case 0: {
                            rightFace[i][2] = backColour;
                            colourCounter(backColour, 1);
                        }
                        case 2: {
                            leftFace[i][2] = backColour;
                            colourCounter(backColour, 1);
                        }
                    }
                }

                String leftColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                if(leftFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            leftFace[i][j] = leftColour;
                            upperFace[j][0] = leftColour;
                            colourCounter(leftColour, 2);
                        }
                        case 2: {
                            leftFace[i][j] = leftColour;
                            lowerFace[j][0] = leftColour;
                            colourCounter(leftColour, 2);
                        }
                        case 1: {
                            leftFace[i][j] = leftColour;
                            colourCounter(leftColour, 1);
                        }
                    }
                    switch (j) {
                        case 0: {
                            backFace[i][2] = leftColour;
                            colourCounter(leftColour, 1);
                        }
                        case 2: {
                            frontFace[i][0] = leftColour;
                            colourCounter(leftColour, 1);
                        }
                    }
                }

                String rightColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                if(rightFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            rightFace[i][j] = rightColour;
                            upperFace[j][2] = rightColour;
                            colourCounter(rightColour, 2);
                        }
                        case 2: {
                            rightFace[i][j] = rightColour;
                            lowerFace[j][2] = rightColour;
                            colourCounter(rightColour, 2);
                        }
                        case 1: {
                            rightFace[i][j] = rightColour;
                            colourCounter(rightColour, 1);
                        }
                    }
                    switch (j) {
                        case 0: {
                            frontFace[i][2] = rightColour;
                            colourCounter(rightColour, 1);
                        }
                        case 2: {
                            backFace[i][0] = rightColour;
                            colourCounter(rightColour, 1);
                        }
                    }
                }
                String upperColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                if(upperFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            upperFace[i][j] = upperColour;
                            backFace[0][2-j] = upperColour;
                            colourCounter(upperColour, 2);
                        }
                        case 2: {
                            upperFace[i][j] = upperColour;
                            frontFace[0][j] = upperColour;
                            colourCounter(upperColour, 2);
                        }
                        case 1: {
                            upperFace[i][j] = upperColour;
                            colourCounter(upperColour, 1);
                        }
                    }
                    switch (j) {
                        case 0: {
                            leftFace[0][i] = upperColour;
                            colourCounter(upperColour, 1);
                        }
                        case 2: {
                            rightFace[0][2-i] = upperColour;
                            colourCounter(upperColour, 1);
                        }
                    }
                }

                String lowerColour = randomColour(whiteCount, yellowCount, blueCount,
                        redCount, orangeCount, greenCount);
                if(lowerFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            lowerFace[i][j] = lowerColour;
                            backFace[2][2-j] = lowerColour;
                            colourCounter(lowerColour, 2);
                        }
                        case 2: {
                            lowerFace[i][j] = lowerColour;
                            frontFace[2][j] = lowerColour;
                            colourCounter(lowerColour, 2);
                        }
                        case 1: {
                            lowerFace[i][j] = lowerColour;
                            colourCounter(lowerColour, 1);
                        }
                    }
                    switch (j) {
                        case 0: {
                            leftFace[2][i] = lowerColour;
                            colourCounter(lowerColour, 1);
                        }
                        case 2: {
                            rightFace[2][2-i] = lowerColour;
                            colourCounter(lowerColour, 1);
                        }
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





    public String[][] getFront() {
        return frontFace;
    }

    public String[][] getBack() {
        return backFace;
    }

    public String[][] getLeft() {
        return  leftFace;
    }

    public String[][] getRight() {
        return rightFace;
    }

    public String[][] getUpper() {
        return upperFace;
    }

    public String[][] getLower() {
        return lowerFace;
    }

    public List<String[][]> getAll() {
        List<String[][]> result = new ArrayList<String[][]>();
        result.add(getFront());
        result.add(getBack());
        result.add(getLeft());
        result.add(getRight());
        result.add(getUpper());
        result.add(getLower());
        return result;
    }





    public static void main(String[] args) {


    }


}
