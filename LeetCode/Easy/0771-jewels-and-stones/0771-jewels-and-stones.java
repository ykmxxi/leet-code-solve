/*
    - jewels: 보석, stones: 돌, 돌의 각 문자가 타입일 때 돌에 보석이 몇 가지 존재하는가
    - 대소문자 구분: 'a' 와 'A'는 다른 타입
*/
import java.util.*;

class Solution {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char j : jewels.toCharArray()) {
            set.add(j);
        }

        int cnt = 0;
        for (char s : stones.toCharArray()) {
            if (set.contains(s)) {
                    cnt++;
            }
        }
        return cnt;
    }

}
