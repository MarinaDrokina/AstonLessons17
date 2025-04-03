class Product {
    private String name;
    private String dateIssue;
    private String manufacturer;
    private String countryOrigin;
    private long price;
    private boolean isReserved;

    Product(String name, String dateIssue, String manufacturer, String countryOrigin, long price, boolean isReserved) {
        this.name = name;
        this.dateIssue = dateIssue;
        this.manufacturer = manufacturer;
        this.countryOrigin = countryOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    String getValues() {
        String info = "Objects name: " + name + ", dateIssue: " + dateIssue + ", manufacturer: " + manufacturer + ", countryOrigin:" + countryOrigin + ", price:" + price + ", isReserved:" + isReserved;
        return info;
    }
}
