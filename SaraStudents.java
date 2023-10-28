import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class SaraStudents {
    public int maxChocolates(ListNode head) {
        if (head == null) {
            return 0;
        }

        int n = 0;
        ListNode current = head;

        // Count the number of nodes in the linked list
        while (current != null) {
            n++;
            current = current.next;
        }

        int[] chocolates = new int[n];
        current = head;

        // Store the chocolates in an array
        for (int i = 0; i < n; i++) {
            chocolates[i] = current.val;
            current = current.next;
        }

        int maxChocolatesReceived = 0;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int studentChocolates = chocolates[start] + chocolates[end];
            maxChocolatesReceived = Math.max(maxChocolatesReceived, studentChocolates);
            start++;
            end--;
        }

        return maxChocolatesReceived;
    }

    public static void main(String[] args) {
        SaraStudents sara = new SaraStudents();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students (N): ");
        int n = scanner.nextInt();

        ListNode head = null;
        ListNode tail = null;

        System.out.println("Enter the chocolates in the boxes (space-separated): ");
        for (int i = 0; i < 2 * n; i++) {
            int chocolate = scanner.nextInt();
            ListNode newNode = new ListNode(chocolate);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        scanner.close();

        int result = sara.maxChocolates(head);
        System.out.println("Max Chocolates Received: " + result);
    }
}
