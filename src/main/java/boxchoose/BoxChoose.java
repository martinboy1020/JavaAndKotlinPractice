package boxchoose;

import java.util.Scanner;

public class BoxChoose {

    public static void main(String[] args) {

        float objectLength;
        float objectWidth;
        int objectHeight;

        Box3 box3 = new Box3();
        Box5 box5 = new Box5();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter object's length");
        objectLength = scanner.nextFloat();
        System.out.println("Please enter object's width");
        objectWidth = scanner.nextFloat();
        System.out.println("Please enter object's height");
        objectHeight = scanner.nextInt();

        if(objectLength > 0 && objectWidth > 0 && objectHeight > 0) {

            if(box3.validate(objectLength, objectWidth, objectHeight)) {
                System.out.println("box3");
            } else if(box5.validate(objectLength, objectWidth, objectHeight)) {
                System.out.println("box5");
            } else {
                System.out.println("both not");
            }

        } else {
            System.out.println("Object Error");
        }

    }

}

class Box {

    private float boxLength;
    private float boxWidth;
    private float boxHeight;

    Box(float boxLength, float boxWidth, float boxHeight) {
        this.boxLength = boxLength;
        this.boxWidth = boxWidth;
        this.boxHeight = boxHeight;
    }

    boolean validate(float length, float width, int height) {
        return length <= boxLength && width <= boxWidth && height <= boxHeight;
    }

}

class Box3 extends Box {

//    float boxLength = 23f;
//    float boxWidth = 14f;
//    float boxHeight = 13f;
//
//    public Box3() {
//
//    }
//
//    public boolean validate(float length, float width, int height) {
//        return length <= boxLength && width <= boxWidth && height <= boxHeight;
//    }

    Box3() {
        super(23f, 14f, 13f);
    }

}

class Box5 extends Box {

    Box5() {
        super(39.5f, 27.5f, 23f);
    }

//    float boxLength = 39.5f;
//    float boxWidth = 27.5f;
//    float boxHeight = 23f;

//    public Box5() {
//
//    }
//
//    public boolean validate(float length, float width, int height) {
//        return length <= boxLength && width <= boxWidth && height <= boxHeight;
//    }

}
