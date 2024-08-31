/*
    - (, ), {, }, [, ] 3가지 괄호로 이루어진 문자열이 유효한지 판별
    - "()" true, "([]) true","(]" false
*/
import java.util.*;

class Solution {

    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                dq.push(ch);
            } else {
                if (dq.isEmpty()) {
                    return false;
                }
                if (ch == ')' && dq.peek() == '(') {
                    dq.pop();
                } else if (ch == '}' && dq.peek() == '{') {
                    dq.pop();
                } else if (ch == ']' && dq.peek() == '[') {
                    dq.pop();
                } else {
                    return false;
                }
            }
        }
        return dq.isEmpty();
    }

}
