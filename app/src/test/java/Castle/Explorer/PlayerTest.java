package Castle.Explorer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void checkPlayerCreated(){
        Player player = new Player(null, null);
        assertNotNull(player);
    }

    @Test
    public void checkGetName(){
        Player player = new Player("Player name", null);
        assertEquals("Player name", player.getName());
    }
    
    @Test
    public void checkSetName(){
        Player player = new Player(null, null);
        player.setName("Player name");
        assertEquals("Player name", player.name);
    }

    @Test
    public void checkGetBag(){
        ArrayList<String> bag = new ArrayList<>();
        Player player = new Player(null, bag);
        assertEquals(bag, player.getBag());
    }

    @Test
    public void checkSetBag(){
        ArrayList<String> bag = new ArrayList<>();
        Player player = new Player(null, null);
        player.setBag(bag);
        assertEquals(bag, player.bag);
    }

    @Test
    public void checkFurnitureListPopulated(){
        List<Furniture> furniture = new ArrayList<Furniture>();

        //Start of connection to DB
        // Logger log = org.appache.logging.log4j.LogManager.getLogger(App.class.getName());
        String url = "jdbc:postgresql://localhost:5432/castle";
        String username = "castle";
        String password = "p4ssw0rd";
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            FurnitureDao fDao = new FurnitureDao(connection);
            
            furniture = fDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(5, furniture.size());
    }

    @Test
    public void checkCollectibleListPopulated(){
        String url = "jdbc:postgresql://localhost:5432/castle";
        String username = "castle";
        String password = "p4ssw0rd";
        List<Collectible> collectibles = new ArrayList<Collectible>();

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            CollectibleDao cDao = new CollectibleDao(connection);
            
            collectibles = cDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(3, collectibles.size());
    }
}
