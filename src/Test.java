public class Test {
    public static int sortArr(String[][] mas) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (mas.length != 4)
            throw new MyArraySizeException("Размер массива не соответствует условию");
        for (int j = 0; j < 4; j++) {
            if (mas[j].length != 4)
                throw new MyArraySizeException("Размер массива не соответствует условию");
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
        return sum;
    }
}

