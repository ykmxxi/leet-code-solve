/*
    - 가장 빈번한 숫자 k개를 반환
    - O(n log n) 이내의 시간 복잡도
*/

import java.util.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(); // 빈도 수 기준 내림차순
        for (int key : cnt.keySet()) {
            pq.offer(new Info(key, cnt.get(key)));
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().val;
        }
        return ans;
    }

    static class Info implements Comparable<Info> {
        int val;
        int cnt;

        Info(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info o) {
            return o.cnt - this.cnt;
        }

    }

}
