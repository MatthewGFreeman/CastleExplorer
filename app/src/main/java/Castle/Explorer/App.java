/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Castle.Explorer;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<String> bag = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Player playerOne = new Player(null, bag);
    public static void main(String[] args) {
        playerOne.greeting();
        playerOne.name = sc.nextLine();
        System.out.println("\tHello " + playerOne.name + "!");
        playerOne.playGame(playerOne.bag, sc);
    }
}