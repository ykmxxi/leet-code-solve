/**
 * Collection Framework의 Stack(Deque) 사용해 큐 구현
 * Deque 인터페이스가 제공하는 기능 활용 가능
 */

import java.util.*;

class MyQueue {

    private final Deque<Integer> in; // 요소 삽입
    private final Deque<Integer> out; // 요소 추출

    public MyQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    // 큐에 엘리먼트를 삽입
    public void push(int x) {
        in.push(x);
    }

    // 큐의 앞 요소(먼저 들어온 요소)를 제거
    public int pop() {
        moveToOut();
        return out.pop();
    }

    // 큐의 앞 요소를 조회
    public int peek() {
        moveToOut();
        return out.peek();
    }

    private void moveToOut() {
        if (out.isEmpty()) { // 추출 스택이 비어있을 때만 옮겨야 FIFO 구조 유지
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    // 큐가 비어있는지 확인
    public boolean empty() {
        return in.size() == 0 && out.size() == 0;
    }

}
