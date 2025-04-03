public class Lesson10 {
    public static void main(String[] args) {

        Product bag = new Product("Steeple bag", "05.09.2017", "Hermes", "France", 5400, true);
        String res = bag.getValues();
        System.out.println(res);

        Product[] ProductsArray = new Product[5];
        ProductsArray[0] = new Product("Samsung s25 ultra", "01.02.2025", "Samsung corp.", "Korea", 5599, true);
        ProductsArray[1] = new Product("Samsung Galaxy Z Fold6", "08.10.2024", "Samsung corp.", "Vietnam", 6478, false);
        ProductsArray[2] = new Product("Google Pixel 8", "08.05.2024", "Google", "China", 3825, true);
        ProductsArray[3] = new Product("Apple iPhone 15", "12.09.2023", "Apple", "China", 7062, true);
        ProductsArray[4] = new Product("Oneplus 12", "23.01.2023", "BBK Electronics", "China", 6331, false);

        Park lunaPark = new Park();
        lunaPark.addAttractions();
        System.out.println(lunaPark.attractionsArray.length);
    }
}
