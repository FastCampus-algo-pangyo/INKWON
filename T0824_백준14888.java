import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE;      //result와최대 최소 비교하기 위한 상 
    static int min = Integer.MAX_VALUE;
    static int[] num;
    static int[] operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
            System.out.println("연산자 상태 = " + "+="+operator[0]+"-="+operator[1]+"/="+operator[2]+"*="+operator[3]);

      
        recur(1, num[0]);          //메인 재귀함수

        System.out.println(max);
        System.out.println(min);
    }

    public static void recur(int index, int result) {

                                  //최대 index도착했을때 최대값과 최소값의 종착 출력
        if (index == N) {
            if (result > max) {
                    max = result;}
                if (result < min) {
                    min = result;
                }
            return;
        }


      
        for (int j = 0; j < 4; j++) {       //연산자마다 가능한 경우 재귀 루프
            if (operator[j] > 0) {
                operator[j]--;
                
                switch (j) {
                    case 0:
                        recur(index + 1, result + num[index]);
                        break;
                    case 1:
                        recur(index + 1, result - num[index]);
                        break;
                    case 2:
                        recur(index + 1, result * num[index]);
                        break;
                    case 3:
                        if (num[index] != 0) { // 0으로 나누는 경우를 방지
                            if (result < 0) {
                                recur(index + 1, -((-result) / num[index]));
                            } else {
                                recur(index + 1, result / num[index]);
                            }
                        }
                        break;
                }

                operator[j]++;
            }
        }
    }
}
