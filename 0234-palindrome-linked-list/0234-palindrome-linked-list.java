/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 단일 연결 리스트의 head가 주어질 때, 팰린드롬이면 true 반환
 */
import java.util.*;

class Solution {

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> dq = new ArrayDeque<>();
        while (head != null) {
            dq.push(head.val);
            head = head.next;
        }

        if (dq.size() == 1) {
            return true;
        }
        while (!dq.isEmpty() && dq.size() > 1) {
            if (dq.peekFirst() != dq.peekLast()) {
                return false;
            }
            dq.pollFirst();
            dq.pollLast();
        }
        return true;
    }

}
