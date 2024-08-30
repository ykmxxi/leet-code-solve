/*
    - left ~ right 까지를 역순으로 만들기
    - 위치는 1부터 시작
    - [1,2,3,4,5] left = 2, right = 4 -> [1,4,3,2,5]
    - 연결 리스트의 길이 1 ~ 500
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode prev = root; // left 전 노드

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next; // swap 시작점
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = prev.next;
            prev.next = start.next;
            start.next = start.next.next;
            prev.next.next = tmp;
        }
        return root.next;
    }
}
