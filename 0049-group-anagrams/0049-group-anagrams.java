/*
    - 주어진 strs의 개수는 10,000 이하
    - 각각의 단어의 길이는 0 ~ 100
*/

import java.util.*;

class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] arr = s.toCharArray();
            
            Arrays.sort(arr); // 알파벳 사전순으로 정렬
            
            String key = String.valueOf(arr);
            
            if (!map.containsKey(key)) { // 처음 나오는 단어이면
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
            
        }
        
        return new ArrayList<>(map.values());
    }
}