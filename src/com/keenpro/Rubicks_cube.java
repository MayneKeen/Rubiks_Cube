package com.keenpro;

import java.io.*;
import java.lang.Math;
import java.util.*;

public class Rubicks_cube {

    private static PrintStream out = System.out;

    enum Colour {
        white, yellow, blue, red, orange, green
    }

    private HashMap<String, Integer> counter = new HashMap();

    public Rubicks_cube() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.frontFace[i][j] = Colour.white;
                this.backFace[i][j] = Colour.yellow;
                this.leftFace[i][j] = Colour.blue;
                this.rightFace[i][j] = Colour.red;
                this.upperFace[i][j] = Colour.orange;
                this.lowerFace[i][j] = Colour.green;
            }
        }
    }


    private Colour frontFace[][] = new Colour[3][3];
    private Colour backFace[][] = new Colour[3][3];
    private Colour leftFace[][] = new Colour[3][3];
    private Colour rightFace[][] = new Colour[3][3];
    private Colour upperFace[][] = new Colour[3][3];
    private Colour lowerFace[][] = new Colour[3][3];




    private void colourCounter(String colour, int times) {
        int t = counter.get(colour);
        counter.remove(colour);
        counter.put(colour, t-times);
    }

    public void randomize() {

        counter.put("white", 9);
        counter.put("yellow", 9);
        counter.put("blue", 9);
        counter.put("red", 9);
        counter.put("orange", 9);
        counter.put("green", 9);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                /*String frontColour = randomColour(whiteCount, yellowCount, blueCount,
                  *        redCount, orangeCount, greenCount, );
                  *String backColour = randomColour(whiteCount, yellowCount, blueCount,
                  *        redCount, orangeCount, greenCount);
                  *String leftColour = randomColour(whiteCount, yellowCount, blueCount,
                  *        redCount, orangeCount, greenCount);
                  *String rightColour = randomColour(whiteCount, yellowCount, blueCount,
                  *        redCount, orangeCount, greenCount);
                  *String upperColour = randomColour(whiteCount, yellowCount, blueCount,
                  *        redCount, orangeCount, greenCount);
                  *String lowerColour = randomColour(whiteCount, yellowCount, blueCount,
                         redCount, orangeCount, greenCount); */


                String frontColour = randomColour(counter);

                String temp = randomColour(counter);

                while(temp == frontColour) {
                    temp = randomColour(counter);
                }
                String backColour = temp;

                while(temp == frontColour || temp == backColour) {
                    temp = randomColour(counter);
                }
                String leftColour = temp;

                while (temp == frontColour || temp == backColour || temp == leftColour) {
                    temp = randomColour(counter);
                }
                String rightColour = randomColour(counter);

                while (temp == frontColour || temp == backColour || temp == leftColour ||
                        temp == rightColour) {
                    temp = randomColour(counter);
                }
                String upperColour = randomColour(counter);

                while (temp == frontColour || temp == backColour || temp == leftColour ||
                        temp == rightColour || temp == upperColour) {
                    temp = randomColour(counter);
                }
                String lowerColour = randomColour(counter);




                if(frontFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            frontFace[i][j] = Colour.valueOf(frontColour);
                            upperFace[2][j] = Colour.valueOf(upperColour);
                            colourCounter(frontColour, 1);
                            colourCounter(upperColour, 1);
                            break;
                        }
                        case 2: {
                            frontFace[i][j] = Colour.valueOf(frontColour);
                            lowerFace[2][j] = Colour.valueOf(lowerColour);
                            colourCounter(frontColour, 1);
                            colourCounter(lowerColour, 1);
                            break;
                        }
                        case 1: {
                            frontFace[i][j] = Colour.valueOf(frontColour);
                            colourCounter(frontColour, 1);
                            break;
                        }
                    }
                    switch (j) {
                        case 0:{
                            leftFace[i][2] = Colour.valueOf(leftColour);
                            colourCounter(leftColour, 1);
                            break;
                        }
                        case 2: {
                            rightFace[i][0] = Colour.valueOf(rightColour);
                            colourCounter(rightColour, 1);
                            break;
                        }
                    }
                }


                if(backFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            backFace[i][j] = Colour.valueOf(backColour);
                            upperFace[i][2-j] = Colour.valueOf(upperColour);
                            colourCounter(backColour, 1);
                            colourCounter(upperColour, 1);
                            break;
                        }
                        case 2: {
                            backFace[i][j] = Colour.valueOf(backColour);
                            lowerFace[0][2-j]= Colour.valueOf(lowerColour);
                            colourCounter(backColour, 1);
                            colourCounter(lowerColour, 1);
                            break;
                        }
                        case 1: {
                            backFace[i][j] = Colour.valueOf(backColour);
                            colourCounter(backColour, 1);
                            break;
                        }
                    }
                    switch (j) {
                        case 0: {
                            rightFace[i][2] = Colour.valueOf(rightColour);
                            colourCounter(rightColour, 1);
                            break;
                        }
                        case 2: {
                            leftFace[i][2] = Colour.valueOf(leftColour);
                            colourCounter(leftColour, 1);
                            break;
                        }
                    }
                }

                if(leftFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            leftFace[i][j] = Colour.valueOf(leftColour);
                            upperFace[j][0] = Colour.valueOf(upperColour);
                            colourCounter(leftColour, 1);
                            colourCounter(upperColour, 1);
                            break;
                        }
                        case 2: {
                            leftFace[i][j] = Colour.valueOf(leftColour);
                            lowerFace[j][0] = Colour.valueOf(lowerColour);
                            colourCounter(leftColour, 1);
                            colourCounter(lowerColour, 1);
                            break;
                        }
                        case 1: {
                            leftFace[i][j] = Colour.valueOf(leftColour);
                            colourCounter(leftColour, 1);
                            break;
                        }
                    }
                    switch (j) {
                        case 0: {
                            backFace[i][2] = Colour.valueOf(backColour);
                            colourCounter(backColour, 1);
                            break;
                        }
                        case 2: {
                            frontFace[i][0] = Colour.valueOf(leftColour);
                            colourCounter(leftColour, 1);
                            break;
                        }
                    }
                }


                if(rightFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            rightFace[i][j] = Colour.valueOf(rightColour);
                            upperFace[j][2] = Colour.valueOf(upperColour);
                            colourCounter(rightColour, 1);
                            colourCounter(upperColour, 1);
                            break;
                        }
                        case 2: {
                            rightFace[i][j] = Colour.valueOf(rightColour);
                            lowerFace[j][2] = Colour.valueOf(lowerColour);
                            colourCounter(rightColour, 1);
                            colourCounter(lowerColour, 1);
                            break;
                        }
                        case 1: {
                            rightFace[i][j] = Colour.valueOf(rightColour);
                            colourCounter(rightColour, 1);
                            break;
                        }
                    }
                    switch (j) {
                        case 0: {
                            frontFace[i][2] = Colour.valueOf(frontColour);
                            colourCounter(frontColour, 1);
                            break;
                        }
                        case 2: {
                            backFace[i][0] = Colour.valueOf(backColour);
                            colourCounter(backColour, 1);
                            break;
                        }
                    }
                }

                if(upperFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            upperFace[i][j] = Colour.valueOf(upperColour);
                            backFace[0][2-j] = Colour.valueOf(backColour);
                            colourCounter(upperColour, 1);
                            colourCounter(backColour, 1);
                            break;
                        }
                        case 2: {
                            upperFace[i][j] = Colour.valueOf(upperColour);
                            frontFace[0][j] = Colour.valueOf(frontColour);
                            colourCounter(upperColour, 1);
                            colourCounter(frontColour, 1);
                            break;
                        }
                        case 1: {
                            upperFace[i][j] = Colour.valueOf(upperColour);
                            colourCounter(upperColour, 1);
                            break;
                        }
                    }
                    switch (j) {
                        case 0: {
                            leftFace[0][i] = Colour.valueOf(leftColour);
                            colourCounter(leftColour, 1);
                            break;
                        }
                        case 2: {
                            rightFace[0][2-i] = Colour.valueOf(rightColour);
                            colourCounter(rightColour, 1);
                            break;
                        }
                    }
                }

                if(lowerFace[i][j] == null) {
                    switch (i) {
                        case 0: {
                            lowerFace[i][j] = Colour.valueOf(lowerColour);
                            backFace[2][2-j] = Colour.valueOf(backColour);
                            colourCounter(lowerColour, 1);
                            colourCounter(backColour, 1);
                            break;
                        }
                        case 2: {
                            lowerFace[i][j] = Colour.valueOf(lowerColour);
                            frontFace[2][j] = Colour.valueOf(frontColour);
                            colourCounter(lowerColour, 1);
                            colourCounter(frontColour, 1);
                            break;
                        }
                        case 1: {
                            lowerFace[i][j] = Colour.valueOf(lowerColour);
                            colourCounter(lowerColour, 1);
                            break;
                        }
                    }
                    switch (j) {
                        case 0: {
                            leftFace[2][i] = Colour.valueOf(leftColour);
                            colourCounter(leftColour, 1);
                            break;
                        }
                        case 2: {
                            rightFace[2][2-i] = Colour.valueOf(rightColour);
                            colourCounter(rightColour, 1);
                            break;
                        }
                    }
                }

            }
        }
    }


    private static String randomColour(HashMap<String, Integer> counter) {

        int whiteCount = counter.get("white");
        int yellowCount = counter.get("yellow");
        int blueCount = counter.get("blue");
        int redCount = counter.get("red");
        int orangeCount = counter.get("orange");
        int greenCount = counter.get("green");

        Random random = new Random();
        int r = random.nextInt(6);

        int[] arr =  {whiteCount, yellowCount, blueCount, redCount, orangeCount, greenCount};
        String[] colours = {"white", "yellow", "blue", "red", "orange", "green"};

        int temp = 0;
        while (temp == 0) {
            r = random.nextInt(6);
            temp = arr[r];
        }

        return colours[r];

        /* if (r == 0 && counter.get("white") > 0) return "white";
        else if (counter.get("white") < 1 && r == 0) return randomColour(counter);

        if (r == 1  && counter.get("yellow") > 0) return "yellow";
        else if (counter.get("yellow") < 1 && r == 1) return randomColour(counter);

        if (r == 2 && counter.get("blue") > 0) return "blue";
        else if (counter.get("blue") < 1 && r ==2) return randomColour(counter);

        if (r == 3 && counter.get("red") > 0) return "red";
        else if (counter.get("red") < 1 && r ==3) return randomColour(counter);

        if (r == 4 && counter.get("orange") > 0) return "orange";
        else if (counter.get("orange") < 1 && r == 4) return randomColour(counter);

        if (r == 5 && counter.get("green") > 0) return "green";
        else if (counter.get("green") < 1 && r < 5) return randomColour(counter);

        return "";
        */
    }




    public void turnLeft1() {

        for (int j = 0; j < 3; j++) {
            Colour temp = frontFace[1][j];
            frontFace[0][j] = rightFace[0][j];
            rightFace[0][j] = backFace[0][j];
            backFace[0][j] = leftFace[0][j];
            leftFace[0][j] = temp;
        }
        Colour a = upperFace[2][0];
        Colour b = upperFace[2][1];

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
            Colour temp = frontFace[1][j];
            frontFace[1][j] = rightFace[1][j];
            rightFace[1][j] = backFace[1][j];
            backFace[1][j] = leftFace[1][j];
            leftFace[1][j] = temp;
        }
    }

    public void turnLeft3() {
        for (int j = 0; j < 3; j++) {
            Colour temp = frontFace[2][j];
            frontFace[2][j] = rightFace[2][j];
            rightFace[2][j] = backFace[2][j];
            backFace[2][j] = leftFace[2][j];
            leftFace[2][j] = temp;
        }
        Colour a = lowerFace[2][0];
        Colour b = lowerFace[2][1];

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
            Colour temp = frontFace[0][j];
            frontFace[0][j] = leftFace[0][j];
            leftFace[0][j] = backFace[0][j];
            backFace[0][j] = rightFace[0][j];
            rightFace[0][j] = temp;
        }
        Colour a = upperFace[2][1];
        Colour b = upperFace[2][2];

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
            Colour temp = frontFace[1][j];
            frontFace[1][j] = leftFace[1][j];
            leftFace[1][j] = backFace[1][j];
            backFace[1][j] = rightFace[1][j];
            rightFace[1][j] = temp;
        }
    }

    public void turnRight3() {
        for(int j=0; j<3; j++) {
            Colour temp = frontFace[2][j];
            frontFace[2][j] = leftFace[2][j];
            leftFace[2][j] = backFace[2][j];
            backFace[2][j] = rightFace[2][j];
            rightFace[2][j] = temp;
        }
        Colour a = upperFace[2][0];
        Colour b = upperFace[2][1];

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
            Colour temp = frontFace[i][0];
            frontFace[i][0] = lowerFace[i][0];
            lowerFace[i][0] = backFace[i][0];
            backFace[i][0] = upperFace[i][0];
            upperFace[i][0] = temp;
        }
        Colour a = leftFace[2][1];
        Colour b = leftFace[2][2];

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
            Colour temp = frontFace[i][1];
            frontFace[i][1] = lowerFace[i][1];
            lowerFace[i][1] = backFace[i][1];
            backFace[i][1] = upperFace[i][1];
            upperFace[i][1] = temp;
        }

    }

    public void turnUp3() {
        for(int i = 0; i<3; i++) {
            Colour temp = frontFace[i][2];
            frontFace[i][2] = lowerFace[i][2];
            lowerFace[i][2] = backFace[i][2];
            backFace[i][2] = upperFace[i][2];
            upperFace[i][2] = temp;
        }
        Colour a = rightFace[2][0];
        Colour b = rightFace[2][1];

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
            Colour temp = frontFace[i][0];
            frontFace[i][0] = upperFace[i][0];
            upperFace[i][0] = backFace[i][0];
            backFace[i][0] = lowerFace[i][0];
            lowerFace[i][0] = temp;
        }
        Colour a = leftFace[2][0];
        Colour b = leftFace[2][1];

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
            Colour temp = frontFace[i][1];
            frontFace[i][1] = upperFace[i][1];
            upperFace[i][1] = backFace[i][1];
            backFace[i][1] = lowerFace[i][1];
            lowerFace[i][1] = temp;
        }
    }

    public void turnDown3() {
        for(int i=0; i<3;i++) {
            Colour temp = frontFace[i][2];
            frontFace[i][2] = upperFace[i][2];
            upperFace[i][2] = backFace[i][2];
            backFace[i][2] = lowerFace[i][2];
            lowerFace[i][2] = temp;
        }
        Colour a = rightFace[2][1];
        Colour b = rightFace[2][2];

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





    public Colour[][] getFront() {
        return frontFace;
    }

    public Colour[][] getBack() {
        return backFace;
    }

    public Colour[][] getLeft() {
        return  leftFace;
    }

    public Colour[][] getRight() {
        return rightFace;
    }

    public Colour[][] getUpper() {
        return upperFace;
    }

    public Colour[][] getLower() {
        return lowerFace;
    }

    public List<Colour[][]> getAll() {
        List<Colour[][]> result = new ArrayList<Colour[][]>();
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
