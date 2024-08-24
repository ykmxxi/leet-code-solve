/*
- n개의 페어를 이용해 min(a, b)의 합으로 만들 수 있는 가장 큰 수를 찾기
- e.g.
 - nums = [1,4,3,2], min(1, 2) + min(3, 4) = 1 + 3 = 4
 - nums = [6,2,6,5,1,2], min(2,1) + min(2,5) + min(6,6) = 1 + 2 + 6 = 9
- 모두 10^4, 배열의 길이 = 2 * 10^4일 때, 10^8 -> 1억(int 범위)
*/
import java.util.*;

class Solution {

    public int arrayPairSum(int[] nums) {
        int ans = 0;
        // 정렬 후 2개씩 묶어서 계산
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) { // 0, 2, 4 idx의 값이 pair의 min
                ans += nums[i];
            }
        }
        return ans;
    }

}
