import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {


        LinkedList<Integer> deque = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;

        System.out.println("큐의 길이 입력");
        int N = sc.nextInt();
        System.out.println("원하는 숫자의 개수 입력");
        int M = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] want = new int[M];

        for(int i = 0; i < M; i++) {    // 원하는 숫자 담음
            System.out.println("원하는 숫자" + M +"개 입력");
            int temp = 0;
            while(true) {
                temp = sc.nextInt();
                if(temp<=N) {
                    want[i] = temp;
                    break;
                }
                else{
                    System.out.println("다시입력");
                }
            }
            }


        for(int i = 0; i < M; i++) {
            int half;
            int a = deque.indexOf(want[i]);
            half = deque.size() / 2;

            if(a <= half) {
                for(int j = 0; j < a; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    System.out.println("2번 연산 수행");
                    System.out.println(deque);
                    count++;
                }
            }
            else {
                for(int j = 0; j < deque.size() - a; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    System.out.println("3번 연산 수행");
                    System.out.println(deque);
                    count++;
                }

            }
            deque.pollFirst();
        }

        System.out.println(count);


    }
}
