package Interface;

public class Circle extends Geom implements IForm {

    private double radius;

    public Circle(String borderColor, String backgroundColor, double radius) {
        super(borderColor, backgroundColor);
        this.radius = radius;
    }

    public double calculateArea() {
        return (Math.PI * Math.pow(this.radius, 2));
    }

    public double calculatePerimeter() {
        return (2 * Math.PI * this.radius);
    }

    public String backgroundColor() {
        return this.backgroundColor;
    }

    public String borderColor() {
        return this.borderColor;
    }
}
