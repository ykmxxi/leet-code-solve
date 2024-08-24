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
        Arrays.sort(nums);
        return IntStream.range(0, nums.length)
                .filter(i -> i % 2 == 0)
                .map(i -> nums[i])
                .sum();
    }

}
