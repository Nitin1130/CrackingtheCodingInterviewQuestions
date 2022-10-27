package Java;

import java.util.Scanner;

public class IsUnique {

    private static boolean isUniqueSol1(String str) {
        // considering the string as ascii with 128-character alphabet
        if(str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128]; // boolean array of length same as 128-character alphabet
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val]) {
                // Already found this char in the string
                return false;
            }
            // set value of idx true if not found
            char_set[val] = true;
        }
        // returns true if the string does not contain duplicates
        return true;
    }

    private static boolean isUniqueSol2(String str) {
        int checker = 0;
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void printOutput(boolean check) {
        if(check) {
            System.out.println("The String is Unique");
        }
        else {
            System.out.println("The String is not Unique");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter no. of tests to perform:- ");
        int tests = scan.nextInt();
        while(tests-- != 0) {
            System.out.println("Enter the String to check:- ");
            String str = scan.next();
            System.out.println("Enter choice of Solution(1 or 2):- ");
            int choice = scan.nextInt();
            boolean ans = false;
            if(choice == 1) {
                ans = isUniqueSol1(str);
            }
            else if(choice == 2) {
                ans = isUniqueSol2(str);
            }
            printOutput(ans);
        }
    }
}