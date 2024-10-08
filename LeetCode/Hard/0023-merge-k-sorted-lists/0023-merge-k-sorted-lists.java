/*
    - k 개의 연결 리스트가 주어질 때, 각 연결 리스트를 오름차순으로 merge
    - lists[i]는 오름차순으로 정렬된 상태로 제공
*/

import java.util.*;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
            // 동일한 값이면 무시
            if (o1.val == o2.val)
                return 0;
                // 새로운 값(o1)이 기본 값(o2)보다 크면 뒤에 위치
            else if (o1.val > o2.val)
                return 1;
                // 작으면 앞에 위치
            else
                return -1;
        });

        ListNode root = new ListNode(0);
        ListNode tail = root;

        // 각 연결 리스트의 첫 번째 노드를 큐에 저장
        for (ListNode node : lists)
            if (node != null)
                pq.add(node);

        // 큐가 모두 빌때까지 반복
        while (!pq.isEmpty()) {
            // 우선순위에 따라 추출, 다음 노드로 이동
            tail.next = pq.poll();
            tail = tail.next;

            // 추출한 연결 리스트의 다음 노드는 다시 큐에 저장
            if (tail.next != null)
                pq.add(tail.next);
        }
        return root.next;
    }

}
