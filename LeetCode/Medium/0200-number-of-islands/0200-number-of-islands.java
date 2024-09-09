/*
    - m(행) x n(열) 2차원 배열이 주어질 때, 1은 육지 0은 물을 의미한다
    - 섬의 개수를 세기
    - 1 <= m, n <= 300
*/

class Solution {

    boolean[][] visit;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int ans = 0;
        visit = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visit[i][j] || grid[i][j] == '0') { // 이미 방문한 점이거나 물이면 넘어가기
                    continue;
                }
                dfs(i, j, grid);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int x, int y, char[][] grid) {
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) {
                continue;
            }
            if (visit[nx][ny] || grid[nx][ny] == '0') {
                continue;
            }
            dfs(nx, ny, grid);
        }

    }

}
