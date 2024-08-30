/*
    - 인접한 두 노드를 모두 swap하고 head 반환
    - 노드의 값을 수정하지 않고 해결(노드 자체만 변경)
    - [1,2,3,4] -> [2,1,4,3]
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        node.next = head;

        // 시작 노드 0: 연결 리스트의 head를 next로 갖는 임시 노드
        while (node.next != null && node.next.next != null) {
            // node: 현재 노드, a: 현재 노드의 다음 노드, b: 현재 노드의 다음 다음 노드
            ListNode a = node.next;
            ListNode b = node.next.next;

            // swap후 다음 노드를 설정
            a.next = b.next;
            // swap
            node.next = b;
            node.next.next = a;

            // swap 후 2칸 이동
            node = node.next.next;
        }
        return temp.next;
    }
}
