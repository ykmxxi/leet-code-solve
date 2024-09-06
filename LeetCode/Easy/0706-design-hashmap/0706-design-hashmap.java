/*
    - 해시맵 구현
    - put(key, value), get(key), remove(key)
*/

class MyHashMap {

    private static final int SIZE = 1_000_000;
    private final Node[] hashMap;

    public MyHashMap() {
        hashMap = new Node[SIZE];
    }

    // key-value 저장, 이미 존재하는 key라면 업데이트
    public void put(int key, int value) {
        int idx = key % SIZE;
        if (hashMap[idx] == null) {
            hashMap[idx] = new Node(key, value);
            return;
        }
        // 해당 해시값에 데이터가 존재하면
        Node node = hashMap[idx];
        while (node != null) {
            if (node.key == key) { // 존재하는 key
                node.value = value;
                return;
            }
            if (node.next == null) {
                break;
            }
            node = node.next;
        }
        node.next = new Node(key, value);
    }

    // key에 해당하는 값을 조회, 없다면 -1 return
    public int get(int key) {
        int idx = key % SIZE;
        if (hashMap[idx] == null) {
            return -1;
        }
        Node node = hashMap[idx];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    // key에 해당하는 key-value 삭제
    public void remove(int key) {
        int idx = key % SIZE;
        if (hashMap[idx] == null) {
            return;
        }
        Node node = hashMap[idx];
        if (node.key == key) { // 첫 번째 노드이면
            if (node.next == null) {
                hashMap[idx] = null;
            } else {
                hashMap[idx] = node.next;
            }
        }
        // 연결 리스트로 존재하면
        Node prev = node;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }

    }

    private static class Node {

        int key, value;
        Node next;

        public Node(final int key, final int value) {
            this.key = key;
            this.value = value;
        }

    }

}
