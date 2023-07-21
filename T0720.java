import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class T0720 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("테스트케이스 수 입력");
        int T = Integer.valueOf(br.readLine());

        Queue<Integer> Qnum = new LinkedList<>();
        Queue<Integer> Qpri  = new LinkedList<>();

        //각 테스트 케이스 별 루프
        for (int i = 0; i < T; i++) {


        System.out.println("배열 길이 입력");
        int n = Integer.valueOf(br.readLine());
            System.out.println("조회 원하는 번호 입력");
        int m = Integer.valueOf(br.readLine());
            for (int j = 0; j < n; j++) {
                System.out.println("각 항목별 우선순위 입력");
        int pri = Integer.valueOf(br.readLine());
                Qnum.add(j);
                Qpri.add(pri);
            }

            int result = 1;

        while(!Qnum.isEmpty()){

            int cur = Qnum.poll();
            boolean check = true;
            int max;
            //문서 전체 탐색 , 최대값 비교 코드

            //현재보다 높은 우선순위 -> 현재큐 맨뒤로
            if(check == false){
                Qnum.add(cur);
                Qpri.add(cur);
            }
            //현재와 같은 번호일때 출력
            else{
                if(cur==m){
                    System.out.println(result);
                }else{
                    result++;
                }
            }

        }



        }


    }
}
