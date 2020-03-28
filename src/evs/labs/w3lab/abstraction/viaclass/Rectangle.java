package evs.labs.w3lab.abstraction.viaclass;

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Rectangle has drawn");
    }

    @Override
    void displayArea() {
        System.out.println("Area of Rectangle = length x width");
    }
}
