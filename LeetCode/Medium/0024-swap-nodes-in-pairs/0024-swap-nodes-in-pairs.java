/*
    - 인접한 두 노드를 모두 swap하고 head 반환
    - 노드의 값을 수정하지 않고 해결(노드 자체만 변경)
    - [1,2,3,4] -> [2,1,4,3]
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        // 현재 노드와 다음 노드가 있으면 반복
        if (head != null && head.next != null) {
            // 다음 노드 선언
            ListNode p = head.next;
            // 다음 다음 노드를 파라미터로 전달하고 스왑된 값을 리턴 받음
            head.next = swapPairs(head.next.next);
            // 다음 다음 노드는 현재 노드로 지정
            p.next = head;
            // 다음 노드 리턴
            return p;
        }
        return head;
    }
}
