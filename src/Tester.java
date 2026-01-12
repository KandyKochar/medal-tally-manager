/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kandy kochar
 */
// Tester.java
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to get input
        MedalTallyManager manager = new MedalTallyManager(); // Create an object to manage medal data


        int entryCount = 0;
        final int MAX_ENTRIES = 15; //Set max entries 

          // Loop to get medal data from user
        while (entryCount < MAX_ENTRIES) {
                System.out.print("Enter medals data with country code and medal count separated by commas, 0 when done : ");
            String inputLine = scanner.nextLine();
            
            if (inputLine.trim().equals("0") || inputLine.trim().startsWith("0,")) {
                   break;
            }

            try {
                String[] parts = inputLine.split(",");
                // Validate input format
                if (parts.length != 4) {
                    System.out.println("Invalid input format. Please use: countryCode,gold,silver,bronze");
                    continue; // Ask for input again
                }

                int countryCode = Integer.parseInt(parts[0].trim());
                int gold = Integer.parseInt(parts[1].trim());
                int silver = Integer.parseInt(parts[2].trim());
                int bronze = Integer.parseInt(parts[3].trim());

                // Validate country code against known countries
                if (countryCode <= 0 || countryCode >= MedalTallyManager.COUNTRY_NAMES.length) {
                    System.out.println("Invalid Country Code. Please enter a code between 1 and " + (MedalTallyManager.COUNTRY_NAMES.length - 1) + ".");
                    continue; // Ask for input again
                }

                // Add data to the manager
                boolean added = manager.addMedalEntry(countryCode, gold, silver, bronze);
                if (!added) {
                   
                    break; // This break is still important to stop the loop if max entries are hit
                }
                entryCount++;

            } catch (NumberFormatException e) {
                System.out.println("Invalid number format in input. Please ensure medal counts are integers.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        // Display the results 
        if (manager.getCurrentRowCount() > 0) {
          
            System.out.println(manager.generateReport());
        } else {

        }

    
    }
}