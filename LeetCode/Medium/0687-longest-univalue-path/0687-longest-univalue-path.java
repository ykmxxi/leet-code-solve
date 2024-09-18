/*
    - 같은 값을 갖는 가장 긴 경로를 찾기
*/
class Solution {
    
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (node.left != null && node.val == node.left.val) { // 왼쪽 자식과 같으면 +1
            left++;
        } else { // 다르면 초기화
            left = 0;
        }
        if (node.right != null && node.val == node.right.val) { // 오른쪽 자식과 같으면 +1
            right++;
        } else {
            right = 0;
        }

        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
    
}
