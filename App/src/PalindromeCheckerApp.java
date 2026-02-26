import java.util.*;

public class PalindromeCheckerApp {

    static String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    static boolean stackPalindrome(String input) {
        String str = normalize(input);
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++)
            stack.push(str.charAt(i));

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != stack.pop())
                return false;
        }
        return true;
    }

    static boolean dequePalindrome(String input) {
        String str = normalize(input);
        Deque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++)
            deque.addLast(str.charAt(i));

        while(deque.size() > 1) {
            if(deque.removeFirst() != deque.removeLast())
                return false;
        }
        return true;
    }

    static boolean recursiveCheck(String str, int start, int end) {
        if(start >= end)
            return true;
        if(str.charAt(start) != str.charAt(end))
            return false;
        return recursiveCheck(str, start + 1, end - 1);
    }

    static boolean recursivePalindrome(String input) {
        String str = normalize(input);
        return recursiveCheck(str, 0, str.length() - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start, end;

        start = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        end = System.nanoTime();
        long stackTime = end - start;

        start = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        end = System.nanoTime();
        long dequeTime = end - start;

        start = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(input);
        end = System.nanoTime();
        long recursiveTime = end - start;

        System.out.println("\nResults");
        System.out.println("Stack: " + (stackResult ? "Palindrome" : "Not a Palindrome"));
        System.out.println("Time: " + stackTime + " ns");

        System.out.println("\nDeque: " + (dequeResult ? "Palindrome" : "Not a Palindrome"));
        System.out.println("Time: " + dequeTime + " ns");

        System.out.println("\nRecursion: " + (recursiveResult ? "Palindrome" : "Not a Palindrome"));
        System.out.println("Time: " + recursiveTime + " ns");
    }
}