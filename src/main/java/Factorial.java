public class Factorial {

    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        long result = 1;
        if (number > 1) {
            for (int i = 1; i <= number; i++)
                result = result * i;
        }
        {
            return result;
        }
    }
}