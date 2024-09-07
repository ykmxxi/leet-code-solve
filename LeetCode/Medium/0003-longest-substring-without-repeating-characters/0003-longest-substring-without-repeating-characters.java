/*
    - 문자열이 주어질 때, 가장긴 반복되는 문자가 없는 가장 긴 부분 문자열의 길이 반환
    - "abcabcbb" -> "abc, "bbbb" -> "b", "pwwkew" -> "kew"
    - 문자열의 길이는 0 ~ 5만
*/

import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.isBlank() || s.length() == 1) {
            return 1;
        }

        int maxLen = 1, L = 0, R = 0;
        Map<Character, Integer> used = new HashMap<>(); // key: 문자, value: 인덱스
        for (char c : s.toCharArray()) {
            if (used.containsKey(c) && L <= used.get(c)) { // 중복 문자 발생
                L = used.get(c) + 1; // 구간 시작점 한 칸 땡기기
            } else { // 중복 문자가 아님
                maxLen = Math.max(maxLen, R - L + 1);
            }
            used.put(c, R);
            R++;
        }
        return maxLen;
    }

}
