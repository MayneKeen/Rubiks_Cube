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
       putFaces();
    }




    private HashMap<String, Colour[][]> cube = new HashMap<>();

    private Colour frontFace[][] = new Colour[3][3];
    private Colour backFace[][] = new Colour[3][3];
    private Colour leftFace[][] = new Colour[3][3];
    private Colour rightFace[][] = new Colour[3][3];
    private Colour upperFace[][] = new Colour[3][3];
    private Colour lowerFace[][] = new Colour[3][3];


   private void putFaces() {
       cube.put("front", frontFace);
       cube.put("back", backFace);
       cube.put("left", leftFace);
       cube.put("right", rightFace);
       cube.put("upper", upperFace);
       cube.put("lower", lowerFace);
   }



    public static Colour[][] transposeLeft(Colour[][] face) {
        int m = 3;
        int p = m/2;
        for(int i = 0; i < m/2; i++) {
            for (int j = i; j < m - 1 - i; j++) {
                Colour tmp = face[i][j];
                face[i][j] = face[m-j-1][i];
                face[m-j-1][i] = face[m-i-1][m-j-1];
                face[m-i-1][m-j-1] = face[j][m-i-1];
                face[j][m-i-1] = tmp;
            }
        }
        return face;
    }

    public static Colour[][] transposeRight(Colour[][] face) {
        int m = 3;
        int p = m/2;
        for(int i = 0; i < m/2; i++) {
            for (int j = i; j < m - 1 - i; j++) {
                Colour tmp = face[i][j];
                face[i][j] = face[j][m-i-1];
                face[j][m-i-1] = face[m-i-1][m-j-1];
                face[m-i-1][m-j-1] = face[m-j-1][i];
                face[m-j-1][i]=tmp;
            }
        }
        return face;
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

                case 4: {
                    switch (b) {
                        case 0: {
                            turnPlaneRight1();
                            break;
                        }
                        case 1: {
                            turnPlaneRight2();
                            break;
                        }
                        case 2: {
                            turnPlaneRight3();
                            break;
                        }
                    }
                    break;
                }

                case 5: {
                    switch (b) {
                        case 0: {
                            turnPlaneLeft1();
                            break;
                        }
                        case 1: {
                            turnPlaneLeft2();
                            break;
                        }
                        case 2: {
                            turnPlaneLeft3();
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
        upperFace = transposeLeft(upperFace);
        putFaces();
    }

    public void turnLeft2() {
        for (int j = 0; j < 3; j++) {
            Colour temp = frontFace[1][j];
            frontFace[1][j] = rightFace[1][j];
            rightFace[1][j] = backFace[1][j];
            backFace[1][j] = leftFace[1][j];
            leftFace[1][j] = temp;
        }
        putFaces();
    }

    public void turnLeft3() {
        for (int j = 0; j < 3; j++) {
            Colour temp = frontFace[2][j];
            frontFace[2][j] = rightFace[2][j];
            rightFace[2][j] = backFace[2][j];
            backFace[2][j] = leftFace[2][j];
            leftFace[2][j] = temp;
        }
        lowerFace = transposeRight(lowerFace);
        putFaces();
    }


    public void turnToLeft() {
        upperFace = transposeLeft(upperFace);
        lowerFace = transposeRight(lowerFace);

        Colour[][] temp = frontFace;
        frontFace = rightFace;
        rightFace = backFace;
        backFace = leftFace;
        leftFace = temp;
        putFaces();
    }







    public void turnRight1() {
        for(int j=0; j<3; j++) {
            Colour temp = frontFace[0][j];
            frontFace[0][j] = leftFace[0][j];
            leftFace[0][j] = backFace[0][j];
            backFace[0][j] = rightFace[0][j];
            rightFace[0][j] = temp;
        }
        upperFace = transposeRight(upperFace);
        putFaces();
    }

    public void turnRight2() {
        for(int j=0; j<3; j++) {
            Colour temp = frontFace[1][j];
            frontFace[1][j] = leftFace[1][j];
            leftFace[1][j] = backFace[1][j];
            backFace[1][j] = rightFace[1][j];
            rightFace[1][j] = temp;
        }
        putFaces();
    }

    public void turnRight3() {
        for(int j=0; j<3; j++) {
            Colour temp = frontFace[2][j];
            frontFace[2][j] = leftFace[2][j];
            leftFace[2][j] = backFace[2][j];
            backFace[2][j] = rightFace[2][j];
            rightFace[2][j] = temp;
        }
        lowerFace = transposeLeft(lowerFace);
        putFaces();
    }

    public void turnToRight() {
        upperFace = transposeRight(upperFace);
        lowerFace = transposeLeft(lowerFace);

        Colour[][] temp = frontFace;
        frontFace = leftFace;
        leftFace = backFace;
        backFace = rightFace;
        rightFace = temp;
        putFaces();
    }






    public void turnUp1() {
        /*for(int i = 0; i<3; i++) {
            Colour temp = frontFace[i][0];
            frontFace[i][0] = lowerFace[i][0];
            lowerFace[i][0] = backFace[2-i][0];
            backFace[2-i][0] = upperFace[i][0];
            upperFace[i][0] = temp;
        }
        leftFace = transposeRight(leftFace);
        */

        turnPlaneToLeft();
        turnLeft3();
        turnPlaneToRight();
        putFaces();
    }

    public void turnUp2() {
        /*for(int i = 0; i<3; i++) {
            Colour temp = frontFace[i][1];
            frontFace[i][1] = lowerFace[i][1];
            lowerFace[i][1] = backFace[2-i][1];
            backFace[2-i][1] = upperFace[i][1];
            upperFace[i][1] = temp;
        }
       */

        turnPlaneToLeft();
        turnLeft2();
        turnPlaneToRight();
        putFaces();
    }

    public void turnUp3() {
        /*for(int i = 0; i<3; i++) {
            Colour temp = frontFace[i][2];
            frontFace[i][2] = lowerFace[i][2];
            lowerFace[i][2] = backFace[2-i][2];
            backFace[2-i][2] = upperFace[i][2];
            upperFace[i][2] = temp;
        }
        rightFace = transposeLeft(rightFace);
        */

        turnPlaneToLeft();
        turnLeft1();
        turnPlaneToRight();
        putFaces();
    }


    public void turnToUp() {
        leftFace = transposeRight(leftFace);
        rightFace = transposeLeft(rightFace);

        Colour[][] temp = frontFace;
        frontFace = lowerFace;
        lowerFace = backFace;
        backFace = upperFace;
        upperFace = temp;
        putFaces();
    }






    public void turnDown1() {
        /*for(int i=0; i<3;i++) {
            Colour temp = frontFace[i][0];
            frontFace[i][0] = upperFace[i][0];
            upperFace[i][0] = backFace[2-i][0];
            backFace[2-i][0] = lowerFace[i][0];
            lowerFace[i][0] = temp;
        }
        leftFace = transposeLeft(leftFace);
        */
        turnPlaneToLeft();
        turnRight3();
        turnPlaneToRight();
        putFaces();
    }

    public void turnDown2() {
        /*for(int i=0; i<3;i++) {
            Colour temp = frontFace[i][1];
            frontFace[i][1] = upperFace[i][1];
            upperFace[i][1] = backFace[2-i][1];
            backFace[2-i][1] = lowerFace[i][1];
            lowerFace[i][1] = temp;
        }
        */
        turnPlaneToLeft();
        turnRight2();
        turnPlaneToRight();
        putFaces();
    }

    public void turnDown3() {
        /*for(int i=0; i<3;i++) {
            Colour temp = frontFace[i][2];
            frontFace[i][2] = upperFace[i][2];
            upperFace[i][2] = backFace[2-i][2];
            backFace[2-i][2] = lowerFace[i][2];
            lowerFace[i][2] = temp;
        }
        rightFace = transposeRight(rightFace);
        */
        turnPlaneToLeft();
        turnRight1();
        turnPlaneToRight();
        putFaces();
    }

    public void turnToDown() {
        leftFace = transposeLeft(leftFace);
        rightFace = transposeRight(rightFace);

        Colour[][] temp = frontFace;
        frontFace = upperFace;
        upperFace = backFace;
        backFace = lowerFace;
        lowerFace = temp;
    }



    public void turnPlaneLeft1(){
        /*for(int i=0; i<3; i++) {
            Colour temp = leftFace[i][1];
            leftFace[i][1] = lowerFace[i][1];
            lowerFace[i][1] = rightFace[2 - i][1];
            rightFace[2 - i][1] = upperFace[i][1];
            upperFace[i][1] = temp;
        } */

        this.turnToLeft();
        this.turnUp3();
        this.turnToRight();
        putFaces();
    }

    public void turnPlaneLeft2() {
        this.turnToLeft();
        this.turnUp2();
        this.turnToRight();
        putFaces();
    }

    public void turnPlaneLeft3() {
        this.turnToLeft();
        this.turnUp1();
        this.turnToRight();
        putFaces();
    }

    public void turnPlaneToLeft() {
       turnPlaneLeft1();
       turnPlaneLeft2();
       turnPlaneLeft3();
        putFaces();
    }

    public void turnPlaneRight1() {
        this.turnToRight();
        this.turnUp1();
        this.turnToLeft();
        putFaces();
    }

    public void turnPlaneRight2() {
        this.turnToRight();
        this.turnUp2();
        this.turnToLeft();
        putFaces();
    }

    public void turnPlaneRight3() {
        this.turnToRight();
        this.turnUp3();
        this.turnToLeft();
        putFaces();
    }


    public void turnPlaneToRight() {
       turnPlaneRight1();
       turnPlaneRight2();
       turnPlaneRight3();
       putFaces();
    }






    public Colour[][] getFront() {
       Colour[][] tmp = cube.get("front");
       return tmp;
    }

    public Colour[][] getBack() {
        Colour[][] tmp = cube.get("back");
        return tmp;
    }

    public Colour[][] getLeft() {
        Colour[][] tmp = cube.get("left");
        return tmp;
    }

    public Colour[][] getRight() {
        Colour[][] tmp = cube.get("right");
        return tmp;
    }

    public Colour[][] getUpper() {
        Colour[][] tmp = cube.get("upper");
        return tmp;
    }

    public Colour[][] getLower() {
        Colour[][] tmp = cube.get("lower");
        return tmp;
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
