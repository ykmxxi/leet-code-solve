/*
    - 이진 트리의 root가 주어질 때, 두 노드 사이의 가장 긴 경로를 반환
    - ex) 1(left:2, right:3), 2(left:4, right:5) -> 4-2-1-3 -> 3
    - root 기준 왼쪽 서브트리와 오른쪽 서브트리가 무조건 가장 긴 경로를 갖는 것은 아님
    - 즉, root를 포함한 길이가 가장 길다는 보장이 없음, 모든 노드를 root 라고 생각하고 순회
*/

class Solution {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // root의 왼쪽 서브트리의 최대 깊이 + 오른쪽 서브트리의 최대 깊이
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 모든 노드를 root로 봤을 떄 왼쪽/오른쪽 서브트리 값을 계속 갱신
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

}
