/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication4;
import java.util.Random;
/**
 *
 * @author Administrator
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numberOfRandomNumbers = 30;
        Random random = new Random();

        System.out.println("S/No.  Decimal Number  Binary Number  Remarks");
        System.out.println("---------------------------------------------");

        for (int i = 1; i <= numberOfRandomNumbers; i++) {
            double decimalNumber = Math.round(random.nextDouble() * 1000.0) / 1000.0; // Generating up to 3 decimal points
            String binaryNumber = convertDecimalToBinary(decimalNumber);
            String remarks = determineRemarks(decimalNumber, binaryNumber);

            System.out.printf("%-6d  %-14.3f  %-13s  %s%n", i, decimalNumber, binaryNumber, remarks);
    }
    
    }

public static String convertDecimalToBinary(double decimalNumber) {
        int integerValue = (int) decimalNumber;
        double fractionalPart = decimalNumber - integerValue;
        StringBuilder binaryBuilder = new StringBuilder(Integer.toBinaryString(integerValue));

        if (fractionalPart > 0) {
            binaryBuilder.append(".");
            int maxFractionalDigits = 12; // Up to 3 decimal places in binary
            while (fractionalPart > 0 && binaryBuilder.length() <= maxFractionalDigits) {
                fractionalPart *= 2;
                binaryBuilder.append((int) fractionalPart);
                fractionalPart -= (int) fractionalPart;
            }
        }

        return binaryBuilder.toString();
    }

    public static String determineRemarks(double decimalNumber, String binaryNumber) {
    double decimalRounded = Math.round(decimalNumber * 100000.0) / 100000.0; // Round to 5 decimal points
    String binaryRounded = convertDecimalToBinary(decimalRounded);
    
    // Pad binary representation with zeros to match length of rounded binary
    int diff = binaryRounded.length() - binaryNumber.length();
    if (diff > 0) {
        StringBuilder paddedBinary = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            paddedBinary.append("0");
        }
        paddedBinary.append(binaryNumber);
        binaryNumber = paddedBinary.toString();
    }

    if (binaryNumber.equals(binaryRounded)) {
        return "Exactly";
    } else {
        return "Approximate";
    }
}

}





