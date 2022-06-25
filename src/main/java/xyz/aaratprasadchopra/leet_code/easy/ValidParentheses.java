package xyz.aaratprasadchopra.leet_code.easy;

import java.util.ArrayDeque;

public class ValidParentheses {
    public static boolean validParentheses(String exp) {
        if (exp == "")
            return false;

        var stack = new ArrayDeque<Character>();

        for (char c : exp.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || c == '<') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            switch (c) {
                case ')':
                    if (stack.peek() != '>' || stack.peek() != ']' || stack.peek() != '}')
                        stack.pop();
                    else
                        return false;
                    break;
                case ']':
                    if (stack.peek() != ')' || stack.peek() != '}' || stack.peek() != '>')
                        stack.pop();
                    else
                        return false;
                    break;
                case '}':
                    if (stack.peek() != ')' || stack.peek() != ']' || stack.peek() != '>')
                        stack.pop();
                    else
                        return false;
                    break;
                case '>':
                    if (stack.peek() != ')' || stack.peek() != ']' || stack.peek() != '}')
                        stack.pop();
                    else
                        return false;
                    break;
            }
        }

        return stack.isEmpty();
    }
}
