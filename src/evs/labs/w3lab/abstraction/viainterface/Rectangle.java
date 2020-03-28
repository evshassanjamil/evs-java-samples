package evs.labs.w3lab.abstraction.viainterface;

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle has drawn");
    }

    @Override
    public void displayArea() {
        System.out.println("Area of Rectangle = length x width");
    }
}
