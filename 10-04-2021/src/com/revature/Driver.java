package com.revature;
import java.util.*;
import java.util.stream.Collectors;

public class Driver {
    public static boolean creditCardNumberCheck(long number) {
        System.out.println("Credit Card Number: " + number);
        // convert number to string
        String string = String.valueOf(number);
        // check if input length is valid
        if(string.length() > 19 || string.length() < 14) {
            return false;
        }
        // convert to list of numbers
        char[] digits = string.toCharArray();
        List<Integer> numbers = new ArrayList<>();
        for (int x = 0; x < digits.length; x++) {
            numbers.add(Character.getNumericValue(digits[x]));
        }

        // remove the last digit of sequence of numbers
        int lastDigit = numbers.remove(numbers.size() - 1);
        // reverse the list
        Collections.reverse(numbers);
        // double the value of every other element
        for(int x = 0; x < numbers.size(); x+=2) {
            numbers.set(x, numbers.get(x) * 2);
        }

        // add digits together if have more than 1 digit
        List<Integer> finalList = new ArrayList<>();
        for(int x = 0; x < numbers.size(); x++) {
            if(numbers.get(x) > 9) {
                String s = numbers.get(x).toString();
                int newX = Character.getNumericValue(s.charAt(0)) + Character.getNumericValue(s.charAt(1));
                finalList.add(newX);
                continue;
            }
            finalList.add(numbers.get(x));
        }
        // sum up the values
        int sum = 0;
        for (int x: finalList) {
            sum += x;
        }
        String s2 = String.valueOf(sum);

        // subtract the last digit of the sum from 10
        int result = 10 - Character.getNumericValue(s2.charAt(s2.length() - 1));

        // System.out for debugging
        System.out.println("Original Sequence: " + Arrays.toString(digits));
        System.out.println("Removed Last Digit: " + lastDigit);
        System.out.println("Doubled List: " + numbers);
        System.out.println("Final List: " + finalList.toString());
        System.out.println("Sum of Values: " + sum);
        System.out.println("Value: " + result);

        // return true or false
        return result == lastDigit;
    }
    public static void main(String[] args) {
        // sample runs
        System.out.println("Result: " + creditCardNumberCheck(123_456_789_123_456_789L));
        System.out.println();
        System.out.println("Result: " + creditCardNumberCheck(123_456_789L));
        System.out.println();
        System.out.println("Result: " + creditCardNumberCheck(789L));
        System.out.println();
        System.out.println("Result: " + creditCardNumberCheck(1234567890123456L));
        System.out.println();
        System.out.println("Result: " + creditCardNumberCheck(1234567890123452L));
    }
}
