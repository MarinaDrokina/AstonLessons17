public class Lesson10 {
    public static void main(String[] args) {

        Product bag = new Product("Steeple bag", "05.09.2017", "Hermes", "France", 5400, true);
        String res = bag.getValues();
        System.out.println(res);

        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung s25 ultra", "01.02.2025", "Samsung corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Samsung Galaxy Z Fold6", "08.10.2024", "Samsung corp.", "Vietnam", 6478, false);
        productsArray[2] = new Product("Google Pixel 8", "08.05.2024", "Google", "China", 3825, true);
        productsArray[3] = new Product("Apple iPhone 15", "12.09.2023", "Apple", "China", 7062, true);
        productsArray[4] = new Product("Oneplus 12", "23.01.2023", "BBK Electronics", "China", 6331, false);

        Park lunaPark = new Park();
        lunaPark.addAttraction("Kick-Flip", "09.00-20.00", 50);
        lunaPark.addAttraction("Sun Flare", "08.00-15.00", 80);
        lunaPark.addAttraction("Rocktopus", "07.00-18.00", 150);
        lunaPark.addAttraction("Forge", "09.00-17.30", 45);
        lunaPark.addAttraction("Psychola", "09.30-19.00", 85);
        lunaPark.addAttraction("Veterok", "09.30-19.00", 85);
    }
}
