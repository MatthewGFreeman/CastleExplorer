package Castle.Explorer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private static final Random randomNumber = new Random();
    String name;
    ArrayList<String> bag;
    /**
     * @param name
     * @param bag
     */
    public Player(String name, ArrayList<String> bag) {
        this.name = name;
        this.bag = bag;
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
    /**
     * @return the bag
     */
    public ArrayList<String> getBag() {
        return bag;
    }
    /**
     * @param bag the bag to set
     */
    public void setBag(ArrayList<String> bag) {
        this.bag = bag;
    }
    
    public void greeting() {
        System.out.println("###################################################################");
        System.out.println("###############     Welcome to the Castle     #####################");
        System.out.println("###################################################################");
        System.out.println("\tYour goal is to collect three items.");
        System.out.println("\tAs you search the castle you will come across some furniture.");
        System.out.println("\tSearch these pieces to find collectible items.");
        System.out.println("\tPlace the collectibles in your bag.");
        System.out.println("\tCollect three items to win!");
        System.out.println("\tWhat is your name?");
    }
    public void playGame(ArrayList<String> pack, Scanner sc) {
        boolean playing = true;
        while(playing) {
            //Implement connection and build list here
            // Furniture chest = new Furniture("Chest");
            // Furniture bookcase = new Furniture("Bookcase");
            // Furniture chair = new Furniture("Chair");
            // Furniture locker = new Furniture("Locker");
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
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            while(pack.size() < 3){
                System.out.println("-------------------------------------------------------------------");
    
                Furniture searchableItem = furniture.get(randomNumber.nextInt(furniture.size()));
                System.out.println("\t# You find a " + searchableItem.name + "! \n");
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Search " + searchableItem.name + ".");
                System.out.println("\t2. Leave it alone and keep looking");
                System.out.println("\t3. Leave the castle");
                String input = sc.nextLine();
                
                playerChoice(input, pack, searchableItem, sc);
            }
            System.out.println("###################################################################");
            System.out.println("################     Thanks for playing!     ######################");
            System.out.println("###################################################################");
            playing = false;
        }
    }
    private void playerChoice(String choice, ArrayList<String> pack, Furniture pieceOfFurniture, Scanner sc) {
        //Implement another connection and build this list
        Collectible gem = new Collectible("Gem");
        Collectible ring = new Collectible("Ring");
        Collectible necklace = new Collectible("Necklace");
        Collectible[] collectibles = {gem, ring, necklace};

        if(choice.equals("1")) {
            if(pieceOfFurniture.hasCollectible()) {
                Collectible foundItem = collectibles[randomNumber.nextInt(collectibles.length)];
                System.out.println("\tYou found a " + foundItem.name + "!");
                System.out.println("\tWhat would you like to do?");
                System.out.println("\t1. Put the " + foundItem.name + " in my bag.");
                System.out.println("\t2. Leave it where it is.");
                String nextChoice = sc.nextLine();

                while(!nextChoice.equals("1") && !nextChoice.equals("2")) {
                    System.out.println("Invalid command!");
                    System.out.println("\tWhat would you like to do?");
                    System.out.println("\t1. Put the item in my bag.");
                    System.out.println("\t2. Leave it where it is.");
                    nextChoice = sc.nextLine();
                }
                if(nextChoice.equals("1")) {
                    pack.add(foundItem.name);
                    System.out.println("You put the " + foundItem.name + " in your bag!");
                    System.out.println("You now have " + pack.size() + " item(s) in your bag.");
                    System.out.println("You need " + (3 - pack.size()) + " more item(s) to win!");
                } else {
                    System.out.println("You leave the " + foundItem.name + " alone.");
                    System.out.println("You have " + pack.size() + " item(s) in your bag.");
                    System.out.println("You need " + (3 - pack.size()) + " more item(s) to win!");
                }
            } else {
                System.out.println("The " + pieceOfFurniture.name + " was empty!");
            }
        } else if(choice.equals("2")){
            System.out.println("You leave the " + pieceOfFurniture.name + " alone and keep searching.");
        } else if(choice.equals("3")) {
            System.out.println("You decide to leave the castle without filling your bag.");
            pack.add(" ");
            pack.add(" ");
            pack.add(" ");
        } else {
            System.out.println("Invlaid command!");
        }
    }
    
}
