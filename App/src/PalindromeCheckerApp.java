import java.util.*;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {

    private String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public boolean checkPalindrome(String input) {
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
}

class DequeStrategy implements PalindromeStrategy {

    private String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public boolean checkPalindrome(String input) {
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
}

class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.checkPalindrome(input);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Algorithm");
        System.out.println("1. Stack Method");
        System.out.println("2. Deque Method");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy;

        if(choice == 1)
            strategy = new StackStrategy();
        else
            strategy = new DequeStrategy();

        PalindromeService service = new PalindromeService(strategy);

        if(service.execute(input))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}