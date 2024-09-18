/*
    - 이진 트리를 반전시켜 반환
    - 반전: 자식 노드의 위치를 swap, left -> right, right -> left
*/

class Solution {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if (node != null) {
            // 자식 노드 swap
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            // swap한 노드에 대해 invert 진행
            invert(node.left);
            invert(node.right);
        }
    }

}
