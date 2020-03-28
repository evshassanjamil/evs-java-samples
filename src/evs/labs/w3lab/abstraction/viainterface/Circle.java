package evs.labs.w3lab.abstraction.viainterface;

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle has drawn");
    }

    @Override
    public void displayArea() {
        System.out.println("Area of Circle = (Pi x radius^2)/2");
    }
}
