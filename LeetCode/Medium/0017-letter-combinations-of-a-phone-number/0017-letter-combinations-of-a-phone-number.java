/*
    - 2~9 숫자를 포함한 문자열이 주어질 떄, 가능한 문자 조합을 반환(정답은 아무렇게 정렬해서)
    - 2(a, b, c) 3(d, e, f) 4(g, h, i) 5(j, k, l) 6(m, n ,o)
    - 7(p, q, r, s) 8(t, u, v) 9(w, x, y, z)
*/

import java.util.*;

class Solution {

    public static Map<String, List<String>> str;

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        str = new HashMap<>();
        str.put("2", List.of("a", "b", "c"));
        str.put("3", List.of("d", "e", "f"));
        str.put("4", List.of("g", "h", "i"));
        str.put("5", List.of("j", "k", "l"));
        str.put("6", List.of("m", "n", "o"));
        str.put("7", List.of("p", "q", "r", "s"));
        str.put("8", List.of("t", "u", "v"));
        str.put("9", List.of("w", "x", "y", "z"));

        List<String> ans = new ArrayList<>();
        dfs(digits, ans, "", 0);
        return ans;
    }

    public static void dfs(String digits, List<String> ans, String word, int depth) {
        if (word.length() == digits.length()) {
            ans.add(word);
            return;
        }
        for (String s : str.get(digits.substring(depth, depth + 1))) {
            dfs(digits, ans, word.concat(s), depth + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }

}
