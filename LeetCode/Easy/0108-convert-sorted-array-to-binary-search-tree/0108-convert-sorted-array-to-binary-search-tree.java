/*
    - 오름차순 정렬된 배열을 높이 균형 BST로 변환
*/

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);

        dfs(root, mid, 0, nums.length - 1, nums);
        return root;
    }

    public void dfs(TreeNode root, int rootIdx, int low, int high, int[] nums) {
        // 왼쪽 서브트리 생성
        int left = rootIdx - 1;
        if (left >= low) {
            root.left = new TreeNode(nums[(low + left) / 2]);
            dfs(root.left, (low + left) / 2, low, left, nums);
        }
        // 오른쪽 서브트리 생성
        int right = rootIdx + 1;
        if (right <= high) {
            root.right = new TreeNode(nums[(right + high) / 2]);
            dfs(root.right, (right + high) / 2, right, high, nums);
        }
    }

}
