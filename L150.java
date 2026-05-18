import java.util.Stack;

public class L150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            switch (c) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int secondMinus = stack.pop();
                    int firstMinus = stack.pop();
                    stack.push(firstMinus - secondMinus);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int secondDiv = stack.pop();
                    int firstDiv = stack.pop();
                    stack.push(firstDiv / secondDiv);
                }
                default -> stack.push(Integer.parseInt(c));
            }
        }

        return stack.peek();        
    }
}
