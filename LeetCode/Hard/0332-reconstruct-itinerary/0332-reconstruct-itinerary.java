/*
    - tickets.get() = [from, to]
    - "JFK"에서 시작하는 일정을 구성, 일정이 여러 개 존재하면 사전식 정렬로 빠른 일정을 반환
*/

import java.util.*;

class Solution {

    Map<String, Queue<String>> adj;

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new LinkedList<>();
        adj = new HashMap<>();

        // 인접리스트 구성
        for (List<String> t : tickets) {
            String from = t.get(0);
            String to = t.get(1);
            adj.computeIfAbsent(from, val -> new PriorityQueue<>()).offer(to);
        }

        dfs("JFK", ans);

        return ans;
    }

    public void dfs(String airport, List<String> ans) {
        while (adj.containsKey(airport) && !adj.get(airport).isEmpty()) { // key 존재 && 남은 티켓이 존재하면
            dfs(adj.get(airport).poll(), ans);
        }
        ans.addFirst(airport); // DFS가 끝나면 최종 위치는 도착지, 결과를 출발지까지 앞으로 삽입
    }

}
