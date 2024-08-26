/*
- answer[i] = nums[i]를 제외한 모든 배열 요소의 곱
- 나눗셈을 사용하지 않고 O(n) 시간 내에 풀이
 - for() i = 0 ~ nums.length - 1
 - for() j = 0 ~ nums.length - 1 except i
 - O(N^2)
- 배열의 길이: 2 이상 10만(10^5) 이하, 요소: -30 이상 30 이하
- O(1) 추가 공간 복잡성 문제를 해결
- 곱셈의 값은 32 bit 인트 범위를 보장 -> 최대값 최소값 고민 X
*/

class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        int a = 1;
        for (int i = 0; i < nums.length; i++) { // 왼쪽 곱셈
            answer[i] = a; // 정답에 자신의 이전 인덱스 까지의 곱이 담긴다: answer[i] = nums[1] ~ nums[i - 1]곱
            a *= nums[i];
        }
        // answer[nums.length - 1]의 경우 정답이 담겨져 있음
        a = 1;
        for (int i = nums.length - 1; i >= 0; i--) { // 오른쪽 곱셈
            answer[i] *= a; // 곱하지 않은 값들을 오른쪽 요소부터 곱해줌, answer[i]의 경우 nums[i + 1] ~ nums[끝]
            a *= nums[i];
        }
        return answer;
    }

}
