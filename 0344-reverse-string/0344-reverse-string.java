/*
    - char 배열 뒤집기 O(1) 추가 메모리로
    - 임시 배열 생성 X, 두 포인터를 이용해 swap
*/

class Solution {
    public void reverseString(char[] s) {
        int L = 0;
        int R = s.length - 1;
        
        while (L < R) {
            char tmp = s[L];
            s[L] = s[R];
            s[R] = tmp;
            
            L++;
            R--;
        }
        
    }
}