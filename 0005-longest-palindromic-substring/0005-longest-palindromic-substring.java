/*
    - 가장 긴 팰린드롬을 출력하기
    - 일단 팰린드롬을 찾아서 왼쪽, 오른쪽 각각 확장시켜 보기
*/

class Solution {

    int left, maxLen;

    void solve(String s, int start, int end) {
        // 투 포인터가 유효한 범위 내에 있고 양쪽 끝 문자가 일치하는 팰린드롬인 경우 범위 확장
        int L = start;
        int R = end;

        while (L >= 0 && R < s.length()) {
            if (s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            } else {
                break;
            }
        }

        // 멈춘 구간은 L (팰린드롬) R => 실제 팰린드롬의 길이는 (R - 1) - (L + 1) + 1 = R - L - 1
        if (maxLen < R - L - 1) {
            left = L + 1;
            maxLen = R - L - 1;
        }
    }

    public String longestPalindrome(String s) {
        int len = s.length();

        if (len < 2) { // 길이가 1이면 그대로 반환
            return s;
        }

        for (int i = 0; i < len - 1; i++) {
            solve(s, i, i + 1); // 팰린드롬이 되려면 짝수(2, 4, ...) or 3(1, 3, ...) "aa" or "aba"
            solve(s, i, i + 2);
        }

        return s.substring(left, left + maxLen);
    }
    
}
