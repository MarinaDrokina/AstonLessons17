import java.util.concurrent.ThreadLocalRandom;

public class Cat extends Animals {
    static int numberCats;
    public boolean isSatieted;
    static int bowl;

    Cat(int distance, String name) {
        super(distance, name);
        this.isSatieted = false;

        numberCats++;
        System.out.println("Котов создано " + numberCats);
    }

    public void run() {
        if (distance <= 200) System.out.println("Кот " + name + " пробежал " + distance + " м");
        else System.out.println("Кот " + name + " устал и не может бежать " + distance + " м");
    }


    public void swim() {
        System.out.println("Кот не умеет плавать");
    }

    public void feedCat() {
        int wantEat = ThreadLocalRandom.current().nextInt(10, 20);
        if ((bowl - wantEat) > 0) {
            this.isSatieted = true;
            bowl = bowl - wantEat;
            System.out.println("Кот " + name + " съел " + wantEat + " из миски и сыт");
        } else {
            System.out.println("Кот " + name + " требует еды и наполнить миску");
            addFoodBowl();
        }
    }

    public static void addFoodBowl() {
        bowl = ThreadLocalRandom.current().nextInt(50, 60);
        System.out.println("Миска наполнена = " + bowl);
    }
}