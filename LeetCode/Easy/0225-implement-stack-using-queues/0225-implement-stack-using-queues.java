/**
 * Collection Framework의 Queue를 사용해 스택 구현
 * Queue 인터페이스가 제공하는 기능 활용 가능
 */

import java.util.*;

class MyStack {

    private final Queue<Integer> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    // x 스택에 삽입
    public void push(int x) {
        // 큐 제일 뒤에 삽입
        stack.offer(x);

        // x가 제일 앞에 오도록 순회
        for (int i = 0; i < stack.size() - 1; i++) {
            int val = stack.poll();
            stack.offer(val);
        }
    }

    // 스택의 첫 번째 엘리먼트를 삭제
    public int pop() {
        return stack.poll();
    }

    // 스택의 첫 번째 엘리먼트를 가져온다, stack의 peek()
    public int top() {
        return stack.peek();
    }

    // 스택이 비어 있는지 여부를 리턴
    public boolean empty() {
        return this.stack.isEmpty();
    }

}
