/*
    - points가 주어질 때, (0, 0)에서 가장 가까운 k개의 목록을 순서대로 출력
*/

import java.util.*;

class Solution {

    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> pq = new PriorityQueue<>();
        for (int[] p : points) {
            pq.offer(new Point(p, compute(p[0], p[1])));
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().p;
        }
        return ans;
    }

    public int compute(int x, int y) {
        return (x * x) + (y * y);
    }

    static class Point implements Comparable<Point> {

        int[] p;
        int dist;

        Point(int[] p, int dist) {
            this.p = p;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            return dist - o.dist; // 거리 기준 오름차순 정렬
        }

    }

}
