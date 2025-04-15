import static java.lang.Math.sqrt;

public class TriangleArea {
    public static double calculateArea(double a, double b, double c) {
        double result;
        result = Math.round(sqrt((a + b + c) / 2 * (((a + b + c) / 2 - a) * ((a + b + c) / 2 - b) * ((a + b + c) / 2 - c))) * 100.0) / 100.0;
        return result;
    }
}