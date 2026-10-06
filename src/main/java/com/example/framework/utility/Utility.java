package com.example.framework.utility;

public class Utility {

    public static void main(String[] args) {

        System.out.println("Utility class is ready.");
//        printFibonacci(10);
        checkStringPalindrome("madam");
    }

    public static void printFibonacci(int n) {
        int first = 0, second = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");
            int temp = first + second;
            first = second;
            second = temp;
        }
    }


    public static void checkStringPalindrome(String input){

        String reverse = "";
        char[] rs = input.toCharArray();

        for(int i = rs.length-1; i>=0 ; i--){
             reverse += input.charAt(i);
        }
        System.out.println("reverse = "+ reverse);
    }
}
