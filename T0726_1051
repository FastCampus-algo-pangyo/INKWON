import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = num.charAt(j) - '0';
            }
        }

        int sq = 1;
        int max = Integer.min(N, M);
        for (int k = max; k >= 2; k--) {
            for (int i = 0; i < N - k + 1; i++) {
                for (int j = 0; j < M - k + 1; j++) {
                    if (arr[i][j] == arr[i + k - 1][j]
                            && arr[i][j] == arr[i][j + k - 1]
                            && arr[i][j] == arr[i + k - 1][j + k - 1])
                    {
                        if (sq < k) {
                            sq = k;
                        }
                    }
                }
            }
        }
        System.out.println(sq * sq);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}
