/*
    - 1 ~ n 까지의 숫자 중 k개를 선택한 조합 반환
    - 1 <= n <= 20, 1 <= k <= n
*/

import java.util.*;

class Solution {

    List<List<Integer>> ans;
    int[] selected;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        selected = new int[k];
        rec(0, k, n, 0);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
        return ans;
    }

    public void rec(int depth, int k, int n, int prev) {
        if (depth == k) {
            ans.add(Arrays.stream(selected).boxed().toList());
            return;
        }
        for (int i = prev + 1; i <= n; i++) {
            selected[depth] = i;
            rec(depth + 1, k, n, i);
            selected[depth] = 0;
        }

    }

}
