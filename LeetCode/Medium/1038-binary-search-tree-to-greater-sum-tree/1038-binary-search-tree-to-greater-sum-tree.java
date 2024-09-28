
/*
    - BST의 루트가 주어질 때, 모든 노드의 값을 (원래 값 + 자신 보다 큰 노드 값들의 합)로 변경
    - root 무조건 존재
*/

import java.util.*;

class Solution {

    Deque<Integer> dq = new ArrayDeque<>();
    Deque<Integer> prefix = new LinkedList<>();

    public TreeNode bstToGst(TreeNode root) {
        // BST 중위 순회 -> 오름차순 정렬 순서대로 방문
        dfs(root);
        // 중위 순회 결과 계산
        int sum = 0;
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            sum += cur;
            prefix.push(sum); // 누적합을 스택에 저장
        }

        // 다시 중위 순회를 돌며 값을 변경
        change(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        dq.push(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }

    public void change(TreeNode root) {
        if (root.left != null) {
            change(root.left);
        }
        root.val = prefix.poll();
        if (root.right != null) {
            change(root.right);
        }
    }

}
