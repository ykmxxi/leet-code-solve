/*
    - k 개의 연결 리스트가 주어질 때, 각 연결 리스트를 오름차순으로 merge
    - lists[i]는 오름차순으로 정렬된 상태로 제공
*/

import java.util.*;

class Solution {

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            ListNode cur = list;
            while (cur != null) {
                pq.offer(cur);
                cur = cur.next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode node = head;
        while (!pq.isEmpty()) {
            node.next = pq.poll();
            node = node.next;
        }
        node.next = null; // 마지막 노드가 갖고 있는 기존 next 참조 끊기

        return head.next;
    }

}
