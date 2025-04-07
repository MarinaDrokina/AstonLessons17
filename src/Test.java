public class Test {
    public static int sortArr(String[][] mas) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (mas.length != 4)
            throw new MyArraySizeException();
        for (int j = 0; j < 4; j++) {
            if (mas[j].length != 4)
                throw new MyArraySizeException();
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                try {
                    sum += Integer.parseInt(mas[i][j]);
                } catch (NumberFormatException exc) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        try {
            for (int j = 0; j < 5; j++) {
                if (mas[j].length != 4)
                    throw new MyArraySizeException();
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Значение выходит за границы диапазона");
        }
        return sum;
    }
}

