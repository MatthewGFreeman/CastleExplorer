package Castle.Explorer;
import java.util.Random;

public class Furniture {
    String name;

    /**
     * @param name
     */
    public Furniture(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public boolean hasCollectible() {
        int chance = 66;
        Random randomNumber = new Random();
        if (chance >= randomNumber.nextInt(100)) {
            return true;
        } else {
            return false;
        }
    }
}
