import java.util.HashMap;
import java.util.Map;

/*
    - nums.length 10^4(10,000)
    - -10억 <= nums[i] <= 10억 -> twoSum int 범위
    - 유효한 답은 1개만 존재 -> 동일한 값이 2개 존재하면 무조건 동일한 값들의 인덱스가 정답
*/
class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // key: nums[idx], value: idx
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
