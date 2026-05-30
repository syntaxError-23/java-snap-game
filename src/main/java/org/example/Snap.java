package org.example;


import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardGame{

    public Snap() {
        super("Snap");
    }

    Scanner scanner = new Scanner(System.in);

    public void playGame(){

        Player p1 = new Player("Player 1");


//        System.out.println("Enter player name: ");
//
//        if(Objects.equals(scanner.nextLine(), "")){
//            System.out.println("Default name used");
//            System.out.println("Welcome " + p1.getName());
//        } else {
//            p1.setName(scanner.nextLine());
//            System.out.println("Welcome " + p1.getName());
//        }

    }
}
