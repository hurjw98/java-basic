package test;

// LIFO(Last In First Out, 후입선출)
public class StackTest extends ArrayTest {
    public int top_index = -1; // 가장 위

    public StackTest() {
        super("Stack");
    }

    /*
     * 스택에 주어진 정수를 넣는다. (넣을 수 없는 경우 "에러" 출력)
     */
    public void push(int k) {
        if(now_size==max_size) {
            System.out.println("push 에러");
            return;
        }

        // 인덱스 재설정
        top_index = (top_index + 1) % max_size;

        // 배열에 넣기
        System.out.println(top_index+"번째 push : "+k);
        list[top_index]=k;

        // 큐 크기 증가
        now_size++;
    }

    /*
     * 스택에서 위에 있는 정수를 빼고, 그 수를 출력한다.
     * 만약 스택에 들어가 있는 정수가 없는 경우에는 "에러"를 출력한다.
     */
    public void pop() {
        if(now_size<1) {
            System.out.println("pop 에러");
            return;
        }

        // 가장 위에 있는 정수 출력
        System.out.print(top_index+"번째 pop : ");
        System.out.println(list[top_index]);

        // 배열에서 빼기
        list[top_index]=0;

        // 인덱스 재설정
        top_index = (top_index - 1 + max_size) % max_size;

        // 큐 크기 감소
        now_size--;
    }


    /*
     * 스택의 가장 위에 있는 정수를 출력한다.
     * 만약 스택에 들어가 있는 정수가 없는 경우에는 "에러"를 출력한다.
     */
    public void top() {
        if(now_size<1) {
            System.out.println("top 에러");
            return;
        }

        // 가장 위에 있는 정수 출력
        System.out.print("가장 위에 있는 정수 : ");
        System.out.println(list[top_index]);

    }

}
