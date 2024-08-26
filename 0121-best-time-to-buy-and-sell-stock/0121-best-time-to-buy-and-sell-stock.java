/*
- 한 번의 거래로 낼 수 있는 최대 이익을 산출
- 수익을 낼 수 없다면 0을 반환
*/

class Solution {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int price : prices) {
            min = Math.min(min, price); // 순회하면 minPrice 갱신
            max = Math.max(max, price - min); // 현재 최대 수익과 현재 가격에서 최소 가격을 뺀 수익을 비교해 갱신
        }
        return max;
    }

}
