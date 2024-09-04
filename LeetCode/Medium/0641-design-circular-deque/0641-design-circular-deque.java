class MyCircularDeque {

    private Node head, tail;
    private int maxSize, curSize;

    // k = maxSize
    public MyCircularDeque(int k) {
        head = new Node(0);
        tail = new Node(0);
        head.right = tail;
        tail.left = head;
        maxSize = k;
        curSize = 0;
    }

    // 처음에 아이템을 추가하고 성공할 경우 true
    public boolean insertFront(int value) {
        if (isFull()) { // 가득 차 있으면
            return false;
        }
        // head <-> ... <-> tail
        // head <-> node <-> ... <-> tail
        Node node = new Node(value);
        node.right = head.right; // 추가된 노드는 head 포인터의 오른쪽 노드를 자신의 오른쪽 노드로
        node.left = head; // 왼쪽 노드는 head
        head.right.left = node; // head 기존 오른쪽 노드의 왼쪽을 새로운 노드로
        head.right = node; // head의 오른쪽 노드도 새로운 노드로
        curSize++;
        return true;
    }

    // 마지막에 아이템을 추가하고 성공할 경우 true
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        // head <-> ... <-> tail
        // head <-> ... <-> node <-> tail
        Node node = new Node(value);
        node.right = tail;
        node.left = tail.left;
        tail.left.right = node;
        tail.left = node;
        curSize++;
        return true;
    }

    // 처음 아이템을 삭제하고 성공할 경우 true
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        Node target = head.right; // 참조가 끊겨 GC
        head.right = target.right;
        target.right.left = head;
        curSize--;
        return true;
    }

    // 마지막 아이템을 삭제하고 성공할 경우 true
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        Node target = tail.left; // 참조가 끊겨 GC
        tail.left = target.left;
        target.left.right = tail;
        curSize--;
        return true;
    }

    // 처음 아이템을 조회, 비어 있으면 -1
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.right.val;
    }

    // 마지막 아이템을 조회, 비어 있으면 -1
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.left.val;
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean isFull() {
        return curSize == maxSize;
    }

    private static class Node {

        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }

    }

}
