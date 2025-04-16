public class Main {
    public static void main(String[] args) {
        String[][] testArray = new String[][]{
                {"1", "a", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"9", "8", "7", "5"}
        };
        String[][] incorrectTestArrayRows = new String[][]{
                {"1", "a", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "8", "7", "5"}
        };
        try {
            int result = Test.sortArr(incorrectTestArrayRows);
            System.out.println(result);

        } catch (MyArraySizeException | MyArrayDataException exc) {
            System.out.println(exc.getMessage());
        }

        try {
            int result = Test.sortArr(testArray);
            System.out.println(result);
        } catch (MyArraySizeException | MyArrayDataException exc) {
            System.out.println(exc.getMessage());
        }

        try {
            for (int j = 0; j < 5; j++) {
                if (testArray[j].length != 4)
                    System.out.println("All ok");
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Значение выходит за границы диапазона");
        }

    }
}