package com.cb.numbers2string_java;

import java.util.Scanner;

/**
 * Created by connelblaze.
 *
 * The program accepts numbers ranging from 0-999
 * Then converts it to the string form.
 * e.g: If you enter; 3, output: three.
 */
public class num2words {
    // main method
    public static void main(String[] args) {
        // infinite for loop to keep accepting numbers
        for (; ;) {
            System.out.println("Enter a number");
            Scanner input = new Scanner(System.in);
            int okay = input.nextInt();

            // calls start ()
            System.out.println(start(okay));
            System.out.println();
        }
    }

    // start method
    private static String start (int n) {
        //to hold the results
        String res = "";

        //arrays of small numbers
        String[] smallnumbers = {
                "zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen",
        };

        //arrays of medium numbers
        String[] tensNumber = {
                "", "", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety",
        };

        int hundreds = n/100;
        int tensUnits = intMod(n, 100);

        // zero rule
        if (n == 0) {
            res = smallnumbers[n];
        }

        // check if the number is greater than 0 and not less than 99
        if (hundreds != 0) {
            res += smallnumbers[hundreds] +" hundred";
            if (tensUnits != 0) {
                res += " and ";
            }
        }

        int tens = tensUnits / 10;
        int units = intMod(tensUnits, 10);

        // check if the number is in tens or units
        if (tens >= 2) {
            res += tensNumber[tens];
            if (units != 0) {
                res += "-"+smallnumbers[units];
            }
        } else if (tensUnits != 0) {
            res += smallnumbers[tensUnits];
        }

        // return the
        return res;
    }

    // It firstly divides the dividend and divisor and
    // then returns an integer that is equal to the remainder
    private static int intMod(int a, int b) {
        return Math.floorMod(a,b);
    }
}
