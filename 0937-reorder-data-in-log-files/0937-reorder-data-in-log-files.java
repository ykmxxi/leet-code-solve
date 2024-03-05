/*
    - letter-logs: 알파벳 소문자로 이루어진 모든 단어
    - digit-logs: 숫자로 이루어진 모든 단어
    - 로그의 가장 앞부분은 식별자로 순서에 영향 X
    - letter-logs가 digit-logs보다 먼저 오게하며 letter-log는 사전순으로 정렬
    - letter-log가 동일할 경우 식별자순으로
    - digit-log는 입력 순서대로 정렬
*/

import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();
        
        for (String s : logs) {
            String[] arr = s.split(" ");
            
            if (Character.isDigit(arr[1].charAt(0))) { // 숫자면
                digit.add(s);
            } else { // 문자면
                letter.add(s);
            }
        }
        
        letter.sort((s1, s2) -> {
            String[] a1 = s1.split(" ", 2); // 식별자와 나머지 부분으로 나누기
            String[] a2 = s2.split(" ", 2);
            
            if (a1[1].compareTo(a2[1]) != 0) {
                return a1[1].compareTo(a2[1]);
            }
            return a1[0].compareTo(a2[0]);
        });
        
        letter.addAll(digit);
        
        return letter.toArray(new String[letter.size()]);
    }
}