/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode node, ListNode prev) {
        if (node == null) { // 끝 도착, 기존 연결 리스트의 마지막 노드의 next가 node로 들어옴
            return prev;
        }
        ListNode next = node.next; // 현재 노드의 다음 요소
        node.next = prev; // 현재 노드의 다음 노드를 이전 노드로(역순 뒤집기)
        return reverse(next, node);
    }
}