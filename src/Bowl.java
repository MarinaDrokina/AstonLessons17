import java.util.concurrent.ThreadLocalRandom;

public class Bowl {
    int bowl;

    public void addFoodBowl() {
        bowl = ThreadLocalRandom.current().nextInt(50, 60);
        System.out.println("Миска наполнена = " + bowl);
    }
}
