/*
    - nums[i] + nums[j] + nums[k] == 0, i != j, i != k, j != k
    - 값 반환: 인덱스 상관 X -> 정렬 후 사용 가능
*/

import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // 이전 값과 같으면 중복되니 다음으로 넘어가기
                continue;
            }
            int target = -nums[i];
            int L = i + 1;
            int R = nums.length - 1;

            while (L < R) {
                if (nums[L] + nums[R] < target) {
                    L++;
                } else if (nums[L] + nums[R] > target) {
                    R--;
                } else {
                    ans.add(List.of(nums[i], nums[L], nums[R]));

                    while (L < R && nums[L] == nums[L + 1]) { 
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                }
            }
        }
        return ans;
    }
    
}
