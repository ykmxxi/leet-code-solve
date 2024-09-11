/*
    - 모든 부분집합을 return
    - 중복된 부분집합은 허용하지 않는다 -> 부분집합은 조합
    - 모든 집합은 공집합과 자기 자신을 부분집합으로 갖는다
*/

import java.util.*;

class Solution {

    List<List<Integer>> ans;
    int[] sel;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<>()); // 모든 집합은 공집합을 부분집합으로 갖는다
        ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList())); // 자기 자신을 부분집합으로 갖는다

        for (int i = 1; i < nums.length; i++) {
            sel = new int[i];
            rec(0, i, nums, -1);
        }
        return ans;
    }

    public void rec(int depth, int cnt, int[] nums, int start) {
        if (depth == cnt) {
            ans.add(Arrays.stream(sel).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start + 1; i < nums.length; i++) {
            sel[depth] = nums[i];
            rec(depth + 1, cnt, nums, i);
            sel[depth] = 0;
        }
    }

}
