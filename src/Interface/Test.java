package Interface;

public class Test {
    public static void main(String[] args) {

        Rectangle rec = new Rectangle("red", "yellow", 18, 2.01);
        System.out.println("Параметры прямоугольника: " + rec.resultText());

        Triangle trgl = new Triangle("black", "white", 1.25, 2.36, 5);
        System.out.println("Параметры треугольника: " + trgl.resultText());

        Circle crl = new Circle("green", "blue", 15);
        System.out.println("Параметры круга: " + crl.resultText());
    }
}
