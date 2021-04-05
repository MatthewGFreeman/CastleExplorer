package Castle.Explorer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FurnitureDao implements Dao<Furniture> {
    Connection connection;
    @Override
    public void insert(Furniture furniture) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into furniture(furnitureName) values (?)");
            pStatement.setString(1, furniture.getName());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Furniture> getAll() {
        List<Furniture> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from furniture");
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()) {
                Furniture temp = new Furniture(rSet.getString("furnitureName"));
                list.add(temp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Furniture e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Furniture e) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @param connection
     */
    public FurnitureDao(Connection connection) {
        this.connection = connection;
    }
    
}
