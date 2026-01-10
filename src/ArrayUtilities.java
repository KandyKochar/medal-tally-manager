/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kandy kochar
 */
// ArrayUtilities.java
public class ArrayUtilities {

 
    // Calculates the sum of elements in a specific row of a 2D array.
    // Used to find total medals for one country.
    public static int findRowTotal(int[][] data, int rowIndex) {
      // Basic check for invalid array or row index
        if (data == null || rowIndex < 0 || rowIndex >= data.length) {
            System.err.println("Error: Invalid array or row index provided to findRowTotal.");
            return -1; // Indicate an error
        }

        int rowSum = 0;
        // Iterate through the columns of the specified row
        for (int j = 0; j < data[rowIndex].length; j++) {
            rowSum += data[rowIndex][j];
        }
        return rowSum;
    }
}