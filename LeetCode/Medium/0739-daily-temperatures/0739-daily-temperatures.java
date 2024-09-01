/*
    - 일일 기온이 주어질 때, 해당 날짜보다 따뜻해지는 날 까지 걸리는 일수
    - 미래에 따뜻해지는 날이 없으면 0
*/

import java.util.*;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!dq.isEmpty() && temperatures[dq.peek()] < temperatures[i]) {
                int idx = dq.pop();
                answer[idx] = i - idx;
            }
            dq.push(i);

        }
        return answer;
    }

}
