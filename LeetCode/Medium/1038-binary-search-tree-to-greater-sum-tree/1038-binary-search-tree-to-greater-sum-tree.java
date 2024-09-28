/*
    - BST의 루트가 주어질 때, 모든 노드의 값을 (원래 값 + 자신 보다 큰 노드 값들의 합)로 변경
    - root 무조건 존재
*/

class Solution {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root.right != null) {
            dfs(root.right);
        }
        sum += root.val;
        root.val = sum;
        if (root.left != null) {
            dfs(root.left);
        }
    }

}
