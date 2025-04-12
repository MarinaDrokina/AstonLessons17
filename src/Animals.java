abstract class Animals {

    static int numberAnimals;

    public String name;

    public Animals(String name) {
        this.name = name;
        numberAnimals++;
    }

    public void run(int distance) {

        System.out.println(name + " пробежал " + distance + " м");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м");
    }
}

