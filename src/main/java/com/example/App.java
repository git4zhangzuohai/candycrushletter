package com.example;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Candy Crush Letter! choose one of the following options:");
        System.out.println("1. Remove consecutive characters");
        System.out.println("2. Replace consecutive characters with the character before it");
        System.out.print("Option: ");
        String option = scanner.nextLine();
        // if not 1 or 2, return
        if (!option.equals("1") && !option.equals("2")) {
            System.out.println("Invalid option. Please choose 1 or 2.");
            return;
        }

        System.out.print("Input: ");
        String input = scanner.nextLine();

        // check if input is empty and must a-z characters
        if (input.isEmpty() || !input.matches("[a-z]+")) {
            System.out.println("Invalid input. Please enter a string with a-z characters.");
            return;
        }
        Command<List<ProcessLog>> command = null;
        if (option.equals("1")) {
            command = new RemoveStringCommand(input);
        } else {
            command = new ReplaceStringCommand(input);
        }
        List<ProcessLog> logs = command.execute();
        Command<Void> printCommand = new PrintCommand(logs);
        printCommand.execute();

        scanner.close();
    }
}
