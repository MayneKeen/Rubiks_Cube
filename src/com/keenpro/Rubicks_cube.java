package com.keenpro;

import java.io.*;
import java.lang.Math;
import java.util.*;

public class Rubicks_cube {

    private static PrintStream out = System.out;

    enum Colour {
        white, yellow, blue, red, orange, green
    }

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

    public void transposeLeft(Colour[][] face) {          //
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                Colour temp = face[i][j];
                face[i][j] = face[j][i];
                face[j][i] = temp;
            }
        }

        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                Colour temp = face[i][j];
                face[i][j] = face[i][2-j];
                face[i][2-j] = temp;
            }
        }

    }

    public void transposeRight(Colour[][] face) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Colour temp = face[i][j];
                face[i][j] = face[j][i];
                face[j][i] = temp;
            }
        }

        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                Colour temp = face[i][j];
                face[i][j] = face[2-i][j];
                face[2-i][j] = temp;
            }
        }

    }


    public void randomize() {
        Random random = new Random();
        int c = random.nextInt(40);

        for(int i = 0; i<=c; i++) {
            int a = random.nextInt(6);
            int b = random.nextInt(3);
            switch (a) {
                case 0 : {
                    switch (b) {
                        case 0: {
                            turnDown1();
                            break;
                        }
                        case 1: {
                            turnDown2();
                            break;
                        }
                        case 2: {
                            turnDown3();
                            break;
                        }
                    }
                    break;
                }

                case 1: {
                    switch (b) {
                        case 0: {
                            turnUp1();
                            break;
                        }
                        case 1: {
                            turnUp2();
                            break;
                        }
                        case 2: {
                            turnUp3();
                            break;
                        }
                    }
                    break;
                }

                case 2: {
                    switch (b) {
                        case 0: {
                            turnRight1();
                            break;
                        }
                        case 1: {
                            turnRight2();
                            break;
                        }
                        case 2: {
                            turnRight3();
                            break;
                        }
                    }
                    break;
                }

                case 3: {
                    switch (b) {
                        case 0: {
                            turnLeft1();
                            break;
                        }
                        case 1: {
                            turnLeft2();
                            break;
                        }
                        case 2: {
                            turnLeft3();
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }




    public void turnLeft1() {

        for (int j = 0; j < 3; j++) {
            Colour temp = frontFace[1][j];
            frontFace[0][j] = rightFace[0][j];
            rightFace[0][j] = backFace[0][j];
            backFace[0][j] = leftFace[0][j];
            leftFace[0][j] = temp;
        }
        transposeLeft(upperFace);
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
        transposeRight(lowerFace);
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
        transposeRight(upperFace);
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
        transposeLeft(lowerFace);
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
            lowerFace[i][0] = backFace[2-i][0];
            backFace[2-i][0] = upperFace[i][0];
            upperFace[i][0] = temp;
        }
        transposeRight(leftFace);
    }

    public void turnUp2() {
        for(int i = 0; i<3; i++) {
            Colour temp = frontFace[i][1];
            frontFace[i][1] = lowerFace[i][1];
            lowerFace[i][1] = backFace[2-i][1];
            backFace[2-i][1] = upperFace[i][1];
            upperFace[i][1] = temp;
        }

    }

    public void turnUp3() {
        for(int i = 0; i<3; i++) {
            Colour temp = frontFace[i][2];
            frontFace[i][2] = lowerFace[i][2];
            lowerFace[i][2] = backFace[2-i][2];
            backFace[2-i][2] = upperFace[i][2];
            upperFace[i][2] = temp;
        }
        transposeLeft(rightFace);
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
            upperFace[i][0] = backFace[2-i][0];
            backFace[2-i][0] = lowerFace[i][0];
            lowerFace[i][0] = temp;
        }
        transposeLeft(leftFace);
    }

    public void turnDown2() {
        for(int i=0; i<3;i++) {
            Colour temp = frontFace[i][1];
            frontFace[i][1] = upperFace[i][1];
            upperFace[i][1] = backFace[2-i][1];
            backFace[2-i][1] = lowerFace[i][1];
            lowerFace[i][1] = temp;
        }
    }

    public void turnDown3() {
        for(int i=0; i<3;i++) {
            Colour temp = frontFace[i][2];
            frontFace[i][2] = upperFace[i][2];
            upperFace[i][2] = backFace[2-i][2];
            backFace[2-i][2] = lowerFace[i][2];
            lowerFace[i][2] = temp;
        }
        transposeRight(rightFace);
    }

    public void turnToDown() {
        turnDown1();
        turnDown2();
        turnDown3();
    }



    public void turnPlaneLeft(){

    }

    public void turnPlaneRight() {

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
