/*
    - numCourses 개의 코스가 존재, [1, 0]: 1 코스를 완료하기 위해 0을 끝내야 한다는 뜻
    - 모든 코스를 끝낼 수 있는지 여부를 확인 -> 인접 리스트가 순환 구조를 갖으면 false
    - 코스의 번호는 0 ~ (numCourses-1)
*/

import java.util.*;

class Solution {

    List<Integer>[] adj; // 인접 리스트
    int[] indeg;
    boolean[] visit;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        indeg = new int[numCourses];
        visit = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>(); // adj[i]: i 코스가 선행 조건이 되는 코스들
        }
        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]); // pre[1] 은 pre[0] 이전에 완료해야 한다
            indeg[pre[0]]++;
        }

        // 위상 정렬이 가능하면 cycle이 없는 방향 그래프
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        int min = Integer.MAX_VALUE;
        if (q.isEmpty()) { // in-degree 0인 코스가 없다면 제일 작은 indeg를 갖는 코스 찾기
            for (int i = 0; i < indeg.length; i++) {
                if (min > indeg[i]) {
                    min = indeg[i];
                    q.clear();
                    q.offer(i);
                    continue;
                }
                if (min == indeg[i]) {
                    q.offer(i);
                }
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            cnt++;
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) {
                    q.offer(y);
                }
            }

        }
        return cnt == numCourses;
    }

}
