/*
    - 홀수 번째 모든 노드 다음에 짝수 번쨰 모든 노드가 오도록 구성
    - 즉, 인덱스로 보면 짝수 인덱스가 앞으로, 홀수 인덱스가 뒤로
    - O(1) 공간 복잡도, 시간 복잡도 O(n)에 해결
    - null인 연결 리스트도 존재
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        // early return
        if (head == null || head.next == null) {
            return head;
        }
        // 홀 짝 그룹을 구성한 후 홀수 그룹의 마지막 노드와 짝수 그룹의 head를 연결
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        // 그룹화
        // odd를 기준으로 반복문을 탈출하면 odd가 null로 끝나 그룹 연결이 불가능
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        // 그룹 연결
        odd.next = evenHead;
        return head;
    }
}