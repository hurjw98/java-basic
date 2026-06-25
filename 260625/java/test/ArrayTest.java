package test;

import java.util.Scanner;

public abstract class ArrayTest {
    public String name;
    public int now_size;

    public int max_size; //  최대 크기
    public int[] list; // 배열

    public ArrayTest(String name) {
        // 배열 크기 초기화
        this.max_size = 5;
        System.out.println(name+"의 최대 크기 : "+this.max_size);
        /**
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print(name+"의 크기를 입력하세요 (자연수만 입력 가능) :");
            this.max_size = scanner.nextInt();
            scanner.nextLine();
            if(this.max_size > 0) {
                System.out.println(name+"의 최대 크기 :"+this.max_size);
                break;
            } else {
                System.out.println("입력한 값은 자연수가 아닙니다. :"+this.max_size);
            }
        }// while문
         */

        // 배열 초기화
        this.list = new int[this.max_size];

        // 이름 초기화
        this.name = name;
    }

    /*
     * 배열에 주어진 정수를 넣는다. (넣을 수 없는 경우 "에러" 출력)
     */
    public abstract void push(int k);

    /*
     * 배열에서 정수를 빼고, 그 수를 출력한다.
     * 만약 배열에 들어가 있는 정수가 없는 경우에는 "에러"를 출력한다.
     */
    public abstract void pop();

    /*
     * 배열에 들어가 있는 정수의 개수를 출력한다.
     */
    public void size() {
        System.out.print(name+"의 현재 사이즈 : ");
        System.out.println(now_size);
    }

    /*
     * 배열이 비어있으면 true, 아니면 false 를 출력한다.
     */
    public void empty() {
        System.out.print("empty : ");

        if(now_size > 0) {
            System.out.println(false);
            return;
        }
        System.out.println(true);
    }

}
