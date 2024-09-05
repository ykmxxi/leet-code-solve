import java.util.*;

/*
    - points가 주어질 때, (0, 0)에서 가장 가까운 k개의 목록을 순서대로 출력
*/

class Solution {

    public int[][] kClosest(int[][] points, int k) {
        // 원점과의 거리를 오름차순으로 정렬
        Arrays.sort(points, (o1, o2) -> {
            int val1 = compute(o1[0], o1[1]);
            int val2 = compute(o2[0], o2[1]);

            return Integer.compare(val1, val2);
        });

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }
    
    public int compute(int x, int y) {
        return (x * x) + (y * y);
    }

}
