package evs.labs.w3lab.abstraction.viaclass;

public class Test {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        s1.draw();
        s1.displayArea();

        Shape s2 = new Rectangle();
        s2.draw();
        s2.displayArea();
    }
}
