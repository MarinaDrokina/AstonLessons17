public class ArithmeticOperations {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль не допустимо");
        }
        {
            return a / b;
        }
    }
}

