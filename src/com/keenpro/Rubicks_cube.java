package com.keenpro;

import java.io.*;
import java.lang.Math;
import java.util.*;

public class Rubicks_cube {

    private static PrintStream out = System.out;



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




    public boolean equals(Rubicks_cube cube) {
        Colour[][] front2 = cube.getFront();
        Colour[][] back2 = cube.getBack();
        Colour[][] left2 = cube.getLeft();
        Colour[][] right2 = cube.getRight();
        Colour[][] upper2 = cube.getUpper();
        Colour[][] lower2 = cube.getLower();

        Colour[][] front1 = this.getFront();
        Colour[][] back1 = this.getBack();
        Colour[][] left1 = this.getLeft();
        Colour[][] right1 = this.getRight();
        Colour[][] upper1 = this.getUpper();
        Colour[][] lower1 = this.getLower();


        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(front1[i][j] != front2[i][j] || back1[i][j] != back2[i][j] ||
                        left1[i][j] != left2[i][j] || right1[i][j] != right2[i][j] ||
                        upper1[i][j] != upper2[i][j] || lower1[i][j] != lower2[i][j])
                    return false;
            }
        }
        return true;
    }


    private Map<String, Colour[][]> cube = new HashMap<>();





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



    public static Colour[][] transposeLeft(Colour[][] face) {                      //clockwise
        int m = 3;
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

    public static Colour[][] transposeRight(Colour[][] face) {                     //anticlockwise
        int m = 3;
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
       turnToDown();
       turnToDown();
       turnToDown();
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
        turnDown1();
        turnDown2();
        turnDown3();
    }


    public void turnPlaneLeft1(){                              //nearest to the user
        /*for(int i=0; i<3; i++) {
            Colour temp = leftFace[i][1];
            leftFace[i][1] = lowerFace[i][1];
            lowerFace[i][1] = rightFace[2 - i][1];
            rightFace[2 - i][1] = upperFace[i][1];
            upperFace[i][1] = temp;
        } */

        /*this.turnToLeft();
        this.turnUp1();
        this.turnToRight();
        */

        for(int k=0; k<3; k++) {
            Colour temp = leftFace[2-k][2];
            leftFace[2-k][2] = upperFace[2][k];
            upperFace[2][k] = rightFace[k][0];
            rightFace[k][0] = lowerFace[0][2-k];
            lowerFace[0][2-k] = temp;
        }
        frontFace = transposeRight(frontFace);
        putFaces();
    }

    public void turnPlaneLeft2() {
        for(int k=0; k<3; k++) {
            Colour temp = leftFace[2-k][1];
            leftFace[2-k][1] = upperFace[1][k];
            upperFace[1][k] = rightFace[k][1];
            rightFace[k][1] = lowerFace[1][2-k];
            lowerFace[1][2-k] = temp;
        }
        putFaces();
    }

    public void turnPlaneLeft3() {
        for(int k=0; k<3; k++) {
            Colour temp = leftFace[2-k][0];
            leftFace[2-k][0] = upperFace[0][k];
            upperFace[0][k] = rightFace[k][2];
            rightFace[k][2] = lowerFace[2][2-k];
            lowerFace[2][2-k] = temp;
        }
        backFace = transposeLeft(backFace);
        putFaces();
    }

    public void turnPlaneToLeft() {
       turnPlaneLeft1();
       turnPlaneLeft2();
       turnPlaneLeft3();
       putFaces();
    }

    public void turnPlaneRight1() {                        //nearest to the user
        for(int k=0; k<3; k++) {
            Colour temp = rightFace[2-k][0];
            rightFace[2-k][0] = upperFace[2][2-k];
            upperFace[2][2-k] = leftFace[k][2];
            leftFace[k][2] = lowerFace[0][k];
            lowerFace[0][k] = temp;
        }
        frontFace = transposeLeft(frontFace);
        putFaces();
    }

    public void turnPlaneRight2() {
        for(int k=0; k<3; k++) {
            Colour temp = rightFace[2-k][1];
            rightFace[2-k][1] = upperFace[1][2-k];
            upperFace[1][2-k] = leftFace[k][1];
            leftFace[k][1] = lowerFace[1][k];
            lowerFace[1][k] = temp;
        }
        putFaces();
    }

    public void turnPlaneRight3() {
        for(int k=0; k<3; k++) {
            Colour temp = rightFace[2-k][2];
            rightFace[2-k][2] = upperFace[0][2-k];
            upperFace[0][2-k] = leftFace[k][0];
            leftFace[k][0] = lowerFace[2][k];
            lowerFace[2][k] = temp;
        }
        backFace = transposeLeft(backFace);
        putFaces();
    }


    public void turnPlaneToRight() {
       turnPlaneToLeft();
       turnPlaneToLeft();
       turnPlaneToLeft();
       putFaces();
    }






    public Colour[][] getFront() {
       Colour[][] tmp = new Colour[3][3];
       for(int i=0; i<3; i++) {
           for(int j=0; j<3; j++) {
               tmp[i][j] = frontFace[i][j];
           }
       }
       return tmp;
    }

    public Colour[][] getBack() {
        Colour[][] tmp = new Colour[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                tmp[i][j] = backFace[i][j];
            }
        }
        return tmp;
    }

    public Colour[][] getLeft() {
        Colour[][] tmp = new Colour[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                tmp[i][j] = leftFace[i][j];
            }
        }
        return tmp;
    }

    public Colour[][] getRight() {
        Colour[][] tmp = new Colour[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                tmp[i][j] = rightFace[i][j];
            }
        }
        return tmp;
    }

    public Colour[][] getUpper() {
        Colour[][] tmp = new Colour[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                tmp[i][j] = upperFace[i][j];
            }
        }
        return tmp;
    }

    public Colour[][] getLower() {
        Colour[][] tmp = new Colour[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                tmp[i][j] = lowerFace[i][j];
            }
        }
        return tmp;
    }

    public List<Colour[][]> getAll() {
        List<Colour[][]> result = new ArrayList<>();
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
