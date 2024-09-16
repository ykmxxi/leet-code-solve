/*
    - 이진 트리의 root가 주어질 때 최대 깊이를 반환
    - 노드의 번호는 0 ~ 10,000, 각 노드의 값은 -100 ~ 100
*/

import java.util.*;

class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) { // early return
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            depth++;
            int cnt = q.size(); // 해당 레벨의 노드 개수
            for (int i = 0; i < cnt; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return depth;
    }

}
