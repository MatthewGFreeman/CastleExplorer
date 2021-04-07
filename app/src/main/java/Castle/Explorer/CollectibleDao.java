package Castle.Explorer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectibleDao implements Dao<Collectible> {
    Connection connection;
    @Override
    public void insert(Collectible collectible) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into furniture(furnitureName) values (?)");
            pStatement.setString(1, collectible.getName());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Collectible> getAll() {
        List<Collectible> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from collectible");
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) {
                Collectible temp = new Collectible(rSet.getString("collectibleName"));
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Collectible e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Collectible e) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @param connection
     */
    public CollectibleDao(Connection connection) {
        this.connection = connection;
    }
    
}
