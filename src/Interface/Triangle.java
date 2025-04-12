package Interface;

import static java.lang.Math.sqrt;

public class Triangle extends Geom implements IForm {
    private double side1;
    private double side2;
    private double side3;
    private double halfPerimeter;

    public Triangle(String borderColor, String backgroundColor, double side1, double side2, double side3) {
        super(borderColor, backgroundColor);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.halfPerimeter = (side1 + side2 + side3) / 2;
    }

    public double calculatePerimeter() {
        return (this.side1 + this.side2 + this.side3);
    }

    public double calculateArea() {
        return sqrt(this.halfPerimeter * (this.halfPerimeter - this.side1) * (this.halfPerimeter - this.side2) * (this.halfPerimeter - this.side3));
    }

    public String backgroundColor() {
        return this.backgroundColor;
    }

    public String borderColor() {
        return this.borderColor;
    }
}
