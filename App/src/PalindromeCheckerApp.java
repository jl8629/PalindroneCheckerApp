import java.util.Scanner;

public class PalindromeCheckerRecursive {

    static boolean isPalindrome(String str, int start, int end) {
        if(start >= end)
            return true;

        if(str.charAt(start) != str.charAt(end))
            return false;

        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean result = isPalindrome(processed, 0, processed.length() - 1);

        if(result)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}