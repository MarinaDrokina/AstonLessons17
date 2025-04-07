public class MyArrayDataException extends Exception {
    public MyArrayDataException(int r, int c) {
        super(String.format("Ошибка в ячейке " + "[%d,%d]", r, c));
    }
}
