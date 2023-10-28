import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        int start = 0; // Start of the current valid substring
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                
                if (stack.isEmpty()) {
                    result.append(S.substring(start + 1, i));
                    start = i + 1;
                }
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        scanner.close();

        String result = removeOuterParentheses(S);
        System.out.println(result);
    }
}
