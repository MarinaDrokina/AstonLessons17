public class Dog extends Animals {
    static int numberDogs;

    Dog(int distance, String name) {
        super(distance, name);

        numberDogs++;
        System.out.println("Собак создано " + numberDogs);
    }

    public void run() {
        if (distance <= 500) System.out.println("Собака " + name + " пробежал " + distance + " м");
        else System.out.println("Собака " + name + " устала и не может бежать " + distance + " м");
    }

    public void swim() {
        if (distance <= 10) System.out.println("Собака " + name + " проплывает " + distance + " м");
        else System.out.println("Собака " + name + " не может проплыть " + distance + " м");
    }
}
