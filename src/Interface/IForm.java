package Interface;

public interface IForm {

    String backgroundColor();

    double calculateArea();

    String borderColor();

    double calculatePerimeter();

     default String resultText() {
        return "Area = " + calculateArea() + ", Perimeter = " + calculatePerimeter() + " ,Bordercolor = " + borderColor() + " ,Backgroundcolor = " + backgroundColor();
    }
}
