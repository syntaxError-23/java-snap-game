package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Player {

    private String name;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(Scanner scanner) {
        System.out.println("Enter player name: ");
        String userInput = scanner.nextLine();

        if(userInput.isBlank()){
            System.out.println("Default name used");
            System.out.println("Welcome " + this.name);
        } else {
            this.name = userInput;
            System.out.println("Welcome " + this.name);
        }
    }
}
