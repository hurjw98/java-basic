package test;

// FIFO(First In First Out, 선입선출)
public class QueueTest extends ArrayTest {
    int front_index; // 가장 앞
    int back_index = -1; // 가장 뒤

    public QueueTest () {
        super("Queue");
    }

    /*
     * 큐에 주어진 정수를 넣는다. (넣을 수 없는 경우 "에러" 출력)
     */
    public void push(int k) {
        if(now_size==max_size) {
            System.out.println("push 에러");
            return;
        }

        // 인덱스 재설정
        back_index = (back_index + 1) % max_size;

        // 배열에 넣기
        System.out.println(back_index+"번째 push : "+k);
        list[back_index]=k;

        // 큐 크기 증가
        now_size++;
    }

    /*
     * 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다.
     * 만약 큐에 들어가 있는 정수가 없는 경우에는 "에러"를 출력한다.
     */
    public void pop() {
        if(now_size<1) {
            System.out.println("pop 에러");
            return;
        }

        // 가장 앞에 있는 정수 출력
        System.out.print(front_index+"번째 pop : ");
        System.out.println(list[front_index]);

        // 배열에서 빼기
        list[front_index]=0;

        // 인덱스 재설정
        front_index = (front_index + 1) % max_size;

        // 큐 크기 감소
        now_size--;
    }


    /*
     * 큐의 가장 앞에 있는 정수를 출력한다.
     * 만약 배열에 들어가 있는 정수가 없는 경우에는 "에러"를 출력한다.
     */
    public void front() {
        if(now_size<1) {
            System.out.println("front 에러");
            return;
        }

        // 가장 앞에 있는 정수 출력
        System.out.print("가장 앞에 있는 정수 : ");
        System.out.println(list[front_index]);
    }

    /*
     * 큐의 가장 뒤에 있는 정수를 출력한다.
     * 만약 큐에 들어가 있는 정수가 없는 경우에는 "에러"을 출력한다.
     */
    public void back() {
        if(now_size<1) {
            System.out.println("back 에러");
            return;
        }

        // 가장 뒤에 있는 정수 출력
        System.out.print("가장 뒤에 있는 정수 : ");
        System.out.println(list[back_index]);
    }

}
