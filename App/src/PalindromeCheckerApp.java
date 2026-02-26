import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {

    static Node head = null;

    static void insert(char c) {
        Node newNode = new Node(c);
        if(head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    static Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static boolean isPalindrome() {
        if(head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        Node tempSecond = secondHalf;

        while(tempSecond != null) {
            if(firstHalf.data != tempSecond.data)
                return false;
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for(int i = 0; i < processed.length(); i++) {
            insert(processed.charAt(i));
        }

        if(isPalindrome())
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}