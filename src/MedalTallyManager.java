/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kandy kochar
 */
// MedalTallyManager.java
import java.util.Arrays;

public class MedalTallyManager {

    // Constants for column indices in the medalData 2D array
    public static final int GOLD = 0;
    public static final int SILVER = 1;
    public static final int BRONZE = 2;
    public static final int NUM_MEDAL_TYPES = 3; // Number of columns for medal counts

    private int[][] medalData;       // Stores gold, silver, bronze counts for each country
    private int[] countryCodes;      // Stores the original country code for each row in medalData
    private int currentRowCount;     // Tracks the number of valid entries added

    private static final int MAX_COUNTRIES = 15;

    // A static array to map country codes (index) to country names
    // Index 0 is unused to align country code 1 with index 1, etc.
    public static final String[] COUNTRY_NAMES = {
        "N/A",           // Index 0 (unused)
        "Australia",     // Index 1
        "England",       // Index 2
        "Canada",        // Index 3
        "India",         // Index 4
        "Malaysia",      // Index 5
        "Pakistan",      // Index 6
        "Bermuda",       // Index 7
        "Cameroon",      // Index 8
        "Bahamas",       // Index 9
        "Singapore",     // Index 10
        "Kenya",         // Index 11
        "Sri Lanka",     // Index 12
        "Fiji",          // Index 13
        "Bangladesh",    // Index 14
        "Ireland"        // Index 15
    };

  // Constructor: Initializes the arrays
    public MedalTallyManager() {
        this.medalData = new int[MAX_COUNTRIES][NUM_MEDAL_TYPES];
        this.countryCodes = new int[MAX_COUNTRIES];
        this.currentRowCount = 0;
    }

   // Adds medal data for one country
    public boolean addMedalEntry(int countryCode, int gold, int silver, int bronze) {
        if (currentRowCount < MAX_COUNTRIES) {
            medalData[currentRowCount][GOLD] = gold;
            medalData[currentRowCount][SILVER] = silver;
            medalData[currentRowCount][BRONZE] = bronze;

            countryCodes[currentRowCount] = countryCode;

            currentRowCount++;
            return true;
        }
        return false; // Max entries reached
    }

    // Getter for medal data array
    public int[][] getMedalData() {
        return medalData;
    }

    // Getter for country codes array
    public int[] getCountryCodes() {
        return countryCodes;
    }

     // Getter for current number of rows (countries)
    public int getCurrentRowCount() {
        return currentRowCount;
    }

 // Calculates total gold, silver, and bronze medals across all countries
    public int[] calculateOverallMedalTotals() {
        int totalGold = 0;
        int totalSilver = 0;
        int totalBronze = 0;

        for (int i = 0; i < currentRowCount; i++) {
            totalGold += medalData[i][GOLD];
            totalSilver += medalData[i][SILVER];
            totalBronze += medalData[i][BRONZE];
        }
        return new int[]{totalGold, totalSilver, totalBronze};
    }

// Gets country name using its code
    public static String getCountryName(int countryCode) {
        if (countryCode > 0 && countryCode < COUNTRY_NAMES.length) {
            return COUNTRY_NAMES[countryCode];
        }
        return "Unknown Country";
    }

    // Generates the full formatted medal report
    public String generateReport() {
        StringBuilder sb = new StringBuilder();

     
         sb.append("--------------------------------------------\n");
        sb.append(String.format("%-15s %-8s %-8s %-8s%n", "Country", "Gold", "Silver", "Bronze"));
      
        sb.append("--------------------------------------------\n");

        // Individual country medal data
        for (int i = 0; i < currentRowCount; i++) {
            int currentCountryCode = countryCodes[i];
            String countryName = getCountryName(currentCountryCode);
            int gold = medalData[i][GOLD];
            int silver = medalData[i][SILVER];
            int bronze = medalData[i][BRONZE];

           
            sb.append(String.format("%-15s %8d %8d %8d%n", countryName, gold, silver, bronze));
        }

      
        sb.append("\n"); 
        int[] overallTotals = calculateOverallMedalTotals();
       
      sb.append("--------------------------------------------\n");
        sb.append(String.format("%15s %8d %8d %8d%n", "", overallTotals[GOLD], overallTotals[SILVER], overallTotals[BRONZE]));
        sb.append("\n"); 
        

        // --- Second Section: Medal Tally (Country: Total) ---
        sb.append("####Medal Tally####\n");
        for (int i = 0; i < currentRowCount; i++) {
            int currentCountryCode = countryCodes[i];
            String countryName = getCountryName(currentCountryCode);
            int countryTotal = ArrayUtilities.findRowTotal(medalData, i);
            // Uses %d for the number (which provides natural alignment)
            
            // Using a fixed-width for country name and then %d for number achieves this.
            sb.append(String.format("%-15s %d%n", countryName, countryTotal));
        }

        return sb.toString();
    }
}