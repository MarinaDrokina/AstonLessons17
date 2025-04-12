import java.util.concurrent.ThreadLocalRandom;

public class Cat extends Animals {
    static int numberCats;
    public boolean isSatieted;

    Cat(String name) {
        super(name);
        this.isSatieted = false;

        numberCats++;
        System.out.println("Котов создано " + numberCats);
    }

    public void run(int distance) {
        if (distance <= 200) System.out.println("Кот " + name + " пробежал " + distance + " м");
        else System.out.println("Кот " + name + " устал и не может бежать " + distance + " м");
    }

    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }

    public void feedCat(Bowl bowl) {
        int wantEat = ThreadLocalRandom.current().nextInt(10, 20);
        if ((bowl.bowl - wantEat) > 0) {
            this.isSatieted = true;
            bowl.bowl = bowl.bowl - wantEat;
            System.out.println("Кот " + name + " съел " + wantEat + " из миски и сыт");
        } else {
            System.out.println("Кот " + name + " требует еды и наполнить миску");
            bowl.addFoodBowl();
        }
    }
}