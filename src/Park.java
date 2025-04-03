class Park {
    public Attraction[] attractionsArray = new Attraction[5];

    void addAttractions() {
        attractionsArray[0] = new Attraction();
        attractionsArray[1] = new Attraction();
        attractionsArray[2] = new Attraction();
        attractionsArray[3] = new Attraction();
        attractionsArray[4] = new Attraction();
    }

    static class Attraction {
        private String name;
        private String openingHours;
        private long price;

        void setValues(String name, String openingHours, long price) {
            this.name = name;
            this.openingHours = openingHours;
            this.price = price;
        }
    }
}

