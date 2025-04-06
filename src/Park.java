class Park {
    private static int attractionCount = 0;

    private Attraction[] attractionsArray = new Attraction[5];

    void addAttraction(String name, String openingHours, long price) {
        if (attractionCount == 5) {
            System.out.println("Нет места для аттракционов в парке");
        } else {
            attractionsArray[attractionCount] = new Attraction(name, openingHours, price);
            attractionCount++;
        }
    }

    static class Attraction {
        private String name;
        private String openingHours;
        private long price;

        Attraction(String name, String openingHours, long price) {
            this.name = name;
            this.openingHours = openingHours;
            this.price = price;
            System.out.println("Добавился аттракцион - " + name);
        }

    }
}

