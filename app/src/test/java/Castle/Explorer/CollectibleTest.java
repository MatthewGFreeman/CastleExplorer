package Castle.Explorer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CollectibleTest {
    @Test
    public void checkCollectibleCreated(){
        Collectible collectible = new Collectible(null);
        assertNotNull(collectible);
    }

    @Test
    public void checkGetName(){
        Collectible gem = new Collectible("gem");
        assertEquals("gem", gem.getName());
    }

    @Test
    public void checkSetName(){
        Collectible ring = new Collectible(null);
        ring.setName("ring");
        assertEquals("ring", ring.getName());
    }
}
