/*
    - 비어있지 않은 양수로 이루어진 연결 리스트
    - l1 = [2,4,3], l2 = [5,6,4] -> [3,4,2], [4,6,5] -> 342 + 465 = 807 -> [7,0,8]
    - 0이 처음으로 나오는 숫자는 없음
*/
import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. 각 리스트 reverse
        ListNode rev1 = reverse(l1);
        ListNode rev2 = reverse(l2);

        // 2. 덧셈
        BigInteger value = sum(rev1, rev2);

        // 3. 다시 뒤집은 후 node 생성
        ListNode node = null;
        ListNode prev = null;
        for (char ch : value.toString().toCharArray()) {
            node = new ListNode(ch - '0');
            node.next = prev;
            prev = node;
        }
        return node;
    }

    public ListNode reverse(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public BigInteger sum(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        while (l1 != null) {
            sb.append(l1.val);
            l1 = l1.next;
        }
        BigInteger v1 = new BigInteger(sb.toString());
        sb = new StringBuilder();
        while (l2 != null) {
            sb.append(l2.val);
            l2 = l2.next;
        }
        return v1.add(new BigInteger(sb.toString()));
    }
}
