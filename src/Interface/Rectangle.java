package Interface;

public class Rectangle extends Geom implements IForm {
    private double side1;
    private double side2;

    public Rectangle(String borderColor, String backgroundColor, double side1, double side2) {
        super(borderColor, backgroundColor);
        this.side1 = side1;
        this.side2 = side2;
    }

    public double calculateArea() {
        return (this.side1 * this.side2);
    }

    public double calculatePerimeter() {
        return ((this.side1 + this.side2) * 2);
    }

    public String backgroundColor() {
        return this.backgroundColor;
    }

    public String borderColor() {
        return this.borderColor;
    }
}

