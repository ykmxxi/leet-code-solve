/*
    - 모든 중복 문자를 제거한 문자열, 사전식 순서로 정렬해 반환
    - 문자열은 소문자로만 구성되어 있는 1 ~ 10,000 길이의 문자열
    - "bcabc" -> "abc", "cbacdcbc" -> "acdb"
*/
import java.util.*;

class Solution {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Boolean> used = new HashMap<>();
        Deque<Character> dq = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {
            count.put(ch, count.get(ch) - 1); // 문자를 꺼내서 사용
            if (used.get(ch) != null && used.get(ch)) { // 이미 사용한 문자이면 건너뛰기
                continue;
            }
            while (!dq.isEmpty() && ch < dq.peek() && count.get(dq.peek()) > 0) {
                char c = dq.pop();
                used.put(c, false);
            }
            dq.push(ch);
            used.put(ch, true);
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }
        return sb.toString();
    }

}
