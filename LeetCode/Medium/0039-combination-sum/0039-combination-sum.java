/*
    - 중복없는 숫자 배열이 주어질 때, 합이 target이 되는 조합을 반환
    - 같은 숫자를 여러 번 선택해도 된다(중복 조합 가능)
    - 30개의 숫자가 모두 40일 때 최대 합이 1200 -> int 범위
*/

import java.util.*;

class Solution {

    List<List<Integer>> ans;
    int[] selected;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (candidates[0] * i > target) {
                break;
            }
            selected = new int[i];
            rec(0, i, candidates, target, 0, 0);
        }
        return ans;
    }

    public void rec(int depth, int cnt, int[] cand, int target, int sum, int start) {
        if (sum > target || (depth == cnt && sum != target)) {
            return;
        }
        if (sum == target && depth == cnt) {
            ans.add(Arrays.stream(selected).boxed().collect(Collectors.toList()));
            return;
        }
        // 중복 조합이기 때문에 이전에 시작한 인덱스부터 시작
        for (int i = start; i < cand.length; i++) {
            selected[depth] = cand[i];
            rec(depth + 1, cnt, cand, target, sum + cand[i], i);
            selected[depth] = 0;
        }

    }

}
