/*
    - jewels: 보석, stones: 돌, 돌의 각 문자가 타입일 때 돌에 보석이 몇 가지 존재하는가
    - 대소문자 구분: 'a' 와 'A'는 다른 타입
*/
import java.util.*;

class Solution {

    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stone = new HashMap<>();

        for (char jewel : jewels.toCharArray()) {
            if (!stone.containsKey(jewel)) {
                stone.put(jewel, 0);
            }
        }

        for (char s : stones.toCharArray()) {
            if (stone.containsKey(s)) {
                stone.put(s, stone.getOrDefault(s, 0) + 1);
            }
        }

        return stone.values().stream().mapToInt(i -> i).sum();
    }

}
