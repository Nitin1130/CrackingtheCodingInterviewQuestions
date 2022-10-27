package Java;

import java.util.Arrays;
import java.util.Scanner;

public class CheckPermutation {

    private static String sort(String str1) {
        char[] content = str1.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    private static boolean checkPermutationSol1(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    private static boolean checkPermutationSol2(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        int[] letters = new int[128];
        char[] str1_arr = str1.toCharArray();
        for(char c: str1_arr) {
            letters[c]++;
        }
        for(int i = 0; i < str2.length(); i++) {
            int c = (int) str2.charAt(i);
            letters[c]--;
            if(letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void printOutput(boolean val) {
        if(val) {
            System.out.println("String is permutation");
        }
        else {
            System.out.println("String is not a permutation");
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter no. of tests to perform:- ");
        int tests = scan.nextInt();
        while(tests-- != 0) {
            System.out.println("Enter first String:- ");
            String str1 = scan.next();
            System.out.println("Enter second String:- ");
            String str2 = scan.next();
            System.out.println("Enter your choice of solution(1 or 2):- ");
            int choice = scan.nextInt();
            boolean ans = false;
            if(choice == 1) {
                ans = checkPermutationSol1(str1, str2);
            }
            else if(choice == 2) {
                ans = checkPermutationSol2(str1, str2);
            }
            printOutput(ans);

        }
    }

}
