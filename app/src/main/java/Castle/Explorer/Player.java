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
            List<Furniture> furniture = new ArrayList<Furniture>();

            //Start of connection to DB
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
            System.out.println("\n###################################################################");
            System.out.println("################     Thanks for playing!     ######################");
            System.out.println("###################################################################");
            playing = false;
        }
    }
    private void playerChoice(String choice, ArrayList<String> pack, Furniture pieceOfFurniture, Scanner sc) {
        //Start of connection to db
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

        if(choice.equals("1")) {
            if(pieceOfFurniture.hasCollectible()) {
                Collectible foundItem = collectibles.get(randomNumber.nextInt(collectibles.size()));
                System.out.println("\tYou found a " + foundItem.name + "!");
                System.out.println("\tWhat would you like to do?");
                System.out.println("\t1. Put the " + foundItem.name + " in my bag.");
                System.out.println("\t2. Leave it where it is.");
                String nextChoice = sc.nextLine();

                while(!nextChoice.equals("1") && !nextChoice.equals("2")) {
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("###################################################################");
                    System.out.println("Well, you couldn't possibly do that.");
                    System.out.println("###################################################################");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Please select 1 or 2 to continue.");
                    System.out.println("\tWhat would you like to do?");
                    System.out.println("\t1. Put the item in my bag.");
                    System.out.println("\t2. Leave it where it is.");
                    nextChoice = sc.nextLine();
                }
                if(nextChoice.equals("1")) {
                    pack.add(foundItem.name);
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("###################################################################");
                    System.out.println("You put the " + foundItem.name + " in your bag!");
                    System.out.println("You now have " + pack.size() + " item(s) in your bag.");
                    System.out.println("You need " + (3 - pack.size()) + " more item(s) to win!");
                    System.out.println("###################################################################");
                } else {
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("###################################################################");
                    System.out.println("You leave the " + foundItem.name + " alone.");
                    System.out.println("You have " + pack.size() + " item(s) in your bag.");
                    System.out.println("You need " + (3 - pack.size()) + " more item(s) to win!");
                    System.out.println("###################################################################");
                }
            } else {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("###################################################################");
                System.out.println("The " + pieceOfFurniture.name + " was empty!");
                System.out.println("###################################################################");
                System.out.println("-------------------------------------------------------------------");
            }
        } else if(choice.equals("2")){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("###################################################################");
            System.out.println("You leave the " + pieceOfFurniture.name + " alone and keep searching.");
            System.out.println("###################################################################");
        } else if(choice.equals("3")) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("###################################################################");
            System.out.println("You decide to leave the castle without filling your bag.");
            System.out.println("###################################################################");
            System.out.println("-------------------------------------------------------------------\n");

            pack.add(" ");
            pack.add(" ");
            pack.add(" ");
        } else {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("###################################################################");
            System.out.println("You can't do that! You leave the " + pieceOfFurniture.name + " alone");
            System.out.println("###################################################################");
        }
    }
    
}
