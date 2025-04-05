package Interface;

public class Triangle extends Geom implements IForm {
    private double side1;
    private double side2;
    private double height;

    public Triangle(String borderColor, String backgroundColor, double side1, double side2, double height) {
        super(borderColor, backgroundColor);
        this.side1 = side1;
        this.side2 = side2;
        this.height = height;
    }

    public double calculateArea() {
        return ((this.side1 * this.height) / 2);
    }

    public double calculatePerimeter() {
        return this.side1 + this.side2 + this.height;
    }

    public String backgroundColor() {
        return this.backgroundColor;
    }

    public String borderColor() {
        return this.borderColor;
    }
}
