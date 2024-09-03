/*
 - 원형 큐(Circular Queue): 선형 데이터 구조, FIFO 구조
 - 마지막 요소와 첫 번쨰 요소가 연결되어 있음(Ring Buffer)
 - 큐 자료구조 사용 X
 */

class MyCircularQueue {

    private final int size;
    private final int[] q;
    private int curSize;
    private int front;
    private int rear;

    public MyCircularQueue(int k) { // k: 원형 큐의 사이즈
        size = k;
        q = new int[size];
        curSize = 0;
        front = 0;
        rear = -1; // 요소 삽입 시 rear 증가, 첫 요소를 삽입하면 front == rear
    }

    // 큐에 element 삽입, 성공 시 true 반환
    public boolean enQueue(int value) {
        if (isFull()) { // 큐가 가득 차 있으면 실패
            return false;
        }
        rear = (rear + 1) % size; // rear 갱신
        q[rear] = value;
        curSize++; // size 증가
        return true;
    }

    // 큐의 처음 요소 제거, 성공 시 true 반환
    public boolean deQueue() {
        if (isEmpty()) { // 큐가 비어있으면 실패
            return false;
        }
        front = (front + 1) % size; // front 갱신
        curSize--; // size 감소
        return true;
    }

    // 큐의 처음 요소 반환, 큐가 비어있으면 -1
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return q[front];
    }

    // 큐의 마지막 요소 반환, 큐가 비어있으면 -1
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return q[rear];
    }

    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return curSize == 0;
    }

    // 큐가 가득 차 있는지 확인
    public boolean isFull() {
        return curSize == size;
    }

}
