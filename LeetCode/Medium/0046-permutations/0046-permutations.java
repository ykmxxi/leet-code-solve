/*
    - 중복없는 숫자들이 주어질 때, 가능한 모든 순열을 반환
*/

import java.util.*;

class Solution {

    boolean[] visit;
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        visit = new boolean[nums.length];
        ans = new ArrayList<>();

        int[] per = new int[nums.length];
        dfs(nums, per, 0);
        return ans;
    }

    public void dfs(int[] nums, int[] per, int depth) {
        if (depth == nums.length) {
            ans.add(Arrays.stream(per).boxed().toList());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            per[depth] = nums[i];
            dfs(nums, per, depth + 1);
            visit[i] = false;
            per[depth] = 0; // 순열을 만든 후 초기화, 값을 바꾸기 때문에 꼭 필요한 것은 아님
        }
    }

}
