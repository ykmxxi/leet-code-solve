/*
    - 금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력
    - 대소문자 구분 X, 마침표 쉼표 등은 무시
*/

import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        
        List<String> bans = new ArrayList<>(Arrays.asList(banned));
        Map<String, Integer> cnts = new HashMap<>();
        
        for (String word : words) {
            if (bans.contains(word)) {
                continue;
            }
            cnts.put(word, cnts.getOrDefault(word, 0) + 1);
        }
        
        
        return Collections.max(cnts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}