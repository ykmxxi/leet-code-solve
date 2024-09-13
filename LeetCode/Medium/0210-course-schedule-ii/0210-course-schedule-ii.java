/*
    - 0 ~ numCourses-1
*/
import java.util.*;

class Solution {
    
    List<Integer>[] adj;
    int[] indeg;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        indeg = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
            indeg[pre[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        
        
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            ans[idx] = x;
            idx++;
            
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) {
                    q.offer(y);
                }
            }
            
        }
        if (idx < numCourses) {
            return new int[0];
        }
        return ans;
    }

}
