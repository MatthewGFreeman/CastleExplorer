package Castle.Explorer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class FurnitureTest {
    @Test
    public void checkFurnitureCreated(){
        Furniture furniture = new Furniture(null);
        assertNotNull(furniture);
    }

    @Test
    public void checkGetName(){
        Furniture chair = new Furniture("chair");
        assertEquals("chair", chair.getName());
    }

    @Test
    public void checkSetName(){
        Furniture locker = new Furniture(null);
        locker.setName("locker");
        assertEquals("locker", locker.getName());
    }

    @Test
    public void checkHasCollectible(){
        Furniture chair = new Furniture("chair");
        assertNotNull(chair.hasCollectible());
    }

}
