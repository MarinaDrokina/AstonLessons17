abstract class Animals {

    static int numberAnimals;

    public int distance;
    public String name;

    public Animals(int distance, String name) {
        this.distance = distance;
        this.name = name;
        numberAnimals++;
    }

    public void run() {

        System.out.println(name + " пробежал " + distance + " м");
    }

    public void swim() {
        System.out.println(name + " проплыл " + distance + " м");
    }
}

