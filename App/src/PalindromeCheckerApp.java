import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < processed.length(); i++) {
            deque.addLast(processed.charAt(i));
        }

        boolean isPalindrome = true;

        while(deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if(front != rear) {
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}