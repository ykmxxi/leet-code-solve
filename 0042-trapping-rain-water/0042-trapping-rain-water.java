/*
    - 0 이상의 정수가 주어질 때 비온 후 얼마나 많은 물이 쌓일 수 있는지 계산
    - 1 <= n(height.length) <= 2 * 10^4, 0 <= height[i] <= 10^5
    - 최대값 약 20억, int 범위
 */
class Solution {

    public int trap(int[] height) {
        int ans = 0;
        int L = 0, R = height.length - 1;
        int lm = height[L], rm = height[R];

        while (L < R) {
            if (lm <= rm) { // 왼쪽 구간의 최대 높이가 오른쪽 구간의 최대 높이보다 낮으면
                ans += lm - height[L];
                L++; // 왼쪽 땡기기
                lm = Math.max(lm, height[L]);
            } else {
                ans += rm - height[R];
                R--; // 오른쪽 땡기기
                rm = Math.max(rm, height[R]);
            }
        }
        return ans;
    }

}
