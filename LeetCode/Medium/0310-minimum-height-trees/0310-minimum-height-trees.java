/*
    - 트리: 두 정점이 유일한 경로로 이어진 cycle 없는 무방향 그래프
    - 0 ~ (n-1) 노드와 edges가 주어질 때, 한 노드를 루트로 설정했을 때 최소 높이를 갖는 트리들을 반환
    - 높이는 root ~ leaf 경로의 개수
    - 모든 노드에 대해 BFS 진행 -> 시간 초과
*/

import java.util.*;

class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        // 인접 리스트 생성
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        List<Integer> leaf = new ArrayList<>();
        // 연결된 노드가 1개만 존재 -> leaf -> 최소 높이의 트리 root 후보가 되지 못함
        for (int i = 0; i < n; i++) {
            if (adj[i].size() == 1) {
                leaf.add(i);
            }
        }
        // 리프 노드들을 차례대로 제거
        // 1개 or 2개가 남을 때 까지 반복 -> 남은 노드가 3개 이상인 경우는 리프 제거 가능
        while (n > 2) {
            n -= leaf.size();
            List<Integer> newLeaf = new ArrayList<>();
            for (int l : leaf) {
                int to = adj[l].get(0);
                adj[l].remove((Object) to);
                adj[to].remove((Object) l);
                if (adj[to].size() == 1) {
                    newLeaf.add(to);
                }
            }
            leaf = newLeaf;
        }
        return leaf; // 마지막에 남은 리프 노드들이 최소 높이 트리의 root
    }

}
