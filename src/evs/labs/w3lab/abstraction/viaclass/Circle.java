package evs.labs.w3lab.abstraction.viaclass;

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Circle has drawn");
    }

    @Override
    void displayArea() {
        System.out.println("Area of Circle = (Pi x radius^2)/2");
    }
}
