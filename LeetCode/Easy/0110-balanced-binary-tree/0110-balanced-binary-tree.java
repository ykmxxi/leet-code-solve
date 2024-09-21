/*
    - 이진 트리가 주어졌을 때 height-balanced 인지 판단
    - height-balanced: 모든 노드의 subtree 간 높이의 차가 1이하
*/

class Solution {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) { // 탐색할 트리의 root
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // subtree 중 균형이 깨진 서브트리가 존재하거나 둘의 높이 차이가 1 초과인 경우
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1; // 높이 반환
    }

}
