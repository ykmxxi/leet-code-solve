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
        ListNode fast = head, slow = head;

        // 2칸씩 움직이는 fast 끝까지 갈 때까지 slow와 함께 진행
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 홀수 개인 경우 slow가 한 칸 더 앞으로 가도록 처리
        if (fast != null) {
            slow = slow.next;
        }

        // slow를 기준으로 역순 연결 리스트 생성
        ListNode rev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }
        // rev 연결 리스트를 끝까지 이동하며 비교
        while (rev != null) {
            // 역순 연결 리스트 rev와 기존 연결 리스트 head를 차례대로 비교
            if (rev.val != head.val)
                return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }

}
