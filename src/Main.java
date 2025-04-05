import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Animals Cat1 = new Cat(ThreadLocalRandom.current().nextInt(0, 500), "Tom");
        Cat1.run();
        Cat1.swim();

        Animals Dog1 = new Dog(ThreadLocalRandom.current().nextInt(0, 800), "Bobic");
        Dog1.run();
        Dog1.swim();

        Cat.addFoodBowl();

        Cat[] catsArr = new Cat[5];
        catsArr[0] = new Cat(0, "Murka");
        catsArr[1] = new Cat(0, "Samon");
        catsArr[2] = new Cat(0, "KusKus");
        catsArr[3] = new Cat(0, "Snowbal");
        catsArr[4] = new Cat(0, "MrsNorris");
        for (int i = 0; i < catsArr.length; i++) {
            catsArr[i].feedCat();
        }
        System.out.println("Животных создано " + Animals.numberAnimals);
    }
}
