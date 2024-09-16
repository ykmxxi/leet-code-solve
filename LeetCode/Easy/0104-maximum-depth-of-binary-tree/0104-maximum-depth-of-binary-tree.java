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
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
