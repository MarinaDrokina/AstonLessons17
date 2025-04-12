import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Animals cat1 = new Cat("Tom");
        cat1.run((ThreadLocalRandom.current().nextInt(0, 500)));
        cat1.swim((ThreadLocalRandom.current().nextInt(0, 500)));

        Animals dog1 = new Dog("Bobic");
        dog1.run((ThreadLocalRandom.current().nextInt(0, 800)));
        dog1.swim((ThreadLocalRandom.current().nextInt(0, 800)));

        Bowl bowl = new Bowl();
        bowl.addFoodBowl();

        Cat[] catsArr = new Cat[5];
        catsArr[0] = new Cat("Murka");
        catsArr[1] = new Cat("Samon");
        catsArr[2] = new Cat("KusKus");
        catsArr[3] = new Cat("Snowbal");
        catsArr[4] = new Cat("MrsNorris");
        for (int i = 0; i < catsArr.length; i++) {
            catsArr[i].feedCat(bowl);
        }
        System.out.println("Животных создано " + Animals.numberAnimals);
    }
}
