import java.util.Scanner;

public class PalindromeCheckerApp {

    static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean result = checkPalindrome(normalized);

        if(result)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}