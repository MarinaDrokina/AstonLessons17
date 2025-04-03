import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Lesson9 {
    public static void main(String[] args) {


        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSum(ThreadLocalRandom.current().nextInt(-10, 15), ThreadLocalRandom.current().nextInt(-10, 15)) + "\n");
        printPositiveNegative(ThreadLocalRandom.current().nextInt(-100, 150));
        System.out.println(checkTrueOrFalse(ThreadLocalRandom.current().nextInt(-1000, 1000)) + "\n");
        stringNumber("Tuk", 3);
        System.out.println(calendar(ThreadLocalRandom.current().nextInt(1900, LocalDate.now().getYear())) + "\n");
        changeNumArray();
        fillArray();
        multiplication();
        nArray();
        System.out.println(Arrays.toString(lenValue(10, 3)) + "\n");

    }


    private static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple\n");
    }

    private static void checkSumSign() {
        int a = ThreadLocalRandom.current().nextInt(-10, 10);
        int b = ThreadLocalRandom.current().nextInt(-10, 10);
        if ((a + b) >= 0) System.out.println("Сумма положительная\n");
        else System.out.println("Сумма отрицательная\n");
    }

    private static void printColor() {
        int value = ThreadLocalRandom.current().nextInt(-100, 150);
        if (value <= 0) System.out.println("Красный\n");
        else if (value <= 100) System.out.println("Желтый\n");
        else System.out.println("Зеленый\n");
    }

    private static void compareNumbers() {
        int a = ThreadLocalRandom.current().nextInt(-10, 10);
        int b = ThreadLocalRandom.current().nextInt(-10, 10);
        if (a >= b) System.out.println("a >= b\n");
        else System.out.println("a < b\n");
    }

    private static boolean checkSum(int a, int b) {
        var result = a + b;
        return (result >= 10 && result <= 20);
    }

    private static void printPositiveNegative(int x) {
        if (x < 0) System.out.println("Отрицательное число\n");
        else System.out.println("Положительное число\n");
    }

    private static boolean checkTrueOrFalse(int z) {
        return (z < 0);
    }

    private static void stringNumber(String str, int count) {
        System.out.println(str.repeat(count) + "\n");
    }

    private static boolean calendar(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static void changeNumArray() {
        int[] mas = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 0) mas[i] = 1;
            else mas[i] = 0;
        }
        System.out.print("Arr = " + Arrays.toString(mas) + "\n");
    }

    private static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.print("Arr = " + Arrays.toString(arr) + "\n");
    }

    private static void multiplication() {
        int[] mlt = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mlt.length; i++) {
            if (mlt[i] < 6) mlt[i] *= 2;
        }
        System.out.print("Arr = " + Arrays.toString(mlt) + "\n");
    }

    private static void nArray() {
        int[][] nar = new int[][]
                {
                        {9, 8, 7},
                        {6, 5, 4},
                        {3, 2, 1}
                };
        for (int i = 0; i < nar.length; i++) {
            for (int j = 0; j < nar.length; j++) {
                if (nar[i] == nar[j]) nar[i][j] = 1;
                System.out.print(nar[i][j] + " ");
            }
            System.out.println("\n");
        }
        for (int i = 0; i < nar.length; i++) {
            for (int j = nar.length - 1; j >= 0; j--) {
                if (nar[i] == nar[j]) nar[i][j] = 1;
                System.out.print(nar[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    private static int[] lenValue(int len, int initialValue) {
        int[] xyz = new int[len];
        Arrays.fill(xyz, initialValue);
        return xyz;
    }
}




