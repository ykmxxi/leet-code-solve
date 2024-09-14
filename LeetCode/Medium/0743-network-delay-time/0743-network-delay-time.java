/*
    - n 개의 노드(1 ~ n)이 주어질 때, 각 간선의 가중치가 주어진다
    - k번 노드에서 시작할 때 n개의 노드가 모두 신호를 받을 수 있는 최단 시간을 구하기
    - 모든 노드가 신호를 받을 수 없다면 -1 반환
    - 1 <= k <= n <= 100, 간선의 가중치 1 ~ 6,000, 정점을 잇는 간선은 유일함
*/

import java.util.*;

class Solution {

    List<Edge>[] adj;
    int[] dist;

    public int networkDelayTime(int[][] times, int n, int k) {
        adj = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj[u].add(new Edge(v, w));
        }

        int ans = 0;
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE; // 거리 배열을 무한대로 초기화
        }
        Queue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(k, 0));
        dist[k] = 0; // 시작 정점의 시간은 0

        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            if (dist[cur.idx] < cur.dist) { // 이미 갱신된 거리가 현재 꺼낸 정보보다 짧으면
                continue; // 무의미한 정보이므로 넘어감
            }
            for (Edge e : adj[cur.idx]) { // 연결된 간선 탐색
                if (dist[cur.idx] + e.weight >= dist[e.to]) { // 새로 찾은 정보가 더 크면 무의미함
                    continue;
                }
                dist[e.to] = dist[cur.idx] + e.weight;
                pq.offer(new Info(e.to, dist[e.to]));
            }
        }
        for (int i = 1; i <= n; i++) {
            // 모든 정점을 방문하지 못했으면 -1
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                ans = Math.max(ans, dist[i]);
            }
        }
        return ans;
    }

    static class Edge {

        int to, weight; // 해당 노드와 연결된 정점과 간선의 가중치

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

    }

    static class Info implements Comparable<Info> { // 우선순위 큐에 들어갈 정보

        int idx, dist; // idx 노드 까지의 최단 거리 정보

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Info o) { // 거리 기준 오름차순 정렬
            return this.dist - o.dist;
        }

    }

}
