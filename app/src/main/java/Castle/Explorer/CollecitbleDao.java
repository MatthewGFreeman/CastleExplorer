package Castle.Explorer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollecitbleDao implements Dao<Collectible> {
    Connection connection;
    @Override
    public void insert(Collectible e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Collectible> getAll() {
        List<Collectible> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from collectible");
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) {
                Collectible temp = new Collectible(rSet.getString("name"));
                list.add(temp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
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
    public CollecitbleDao(Connection connection) {
        this.connection = connection;
    }
    
}
