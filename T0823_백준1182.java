import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, count = 0;
    static int[] seq;
    static int sum=0;

    public static void sub(int index) {
        if (index == N) {
            if (sum == S && sum != 0) {
                count++;
            }
            return;
        }
        sub(index + 1); //  포함하지 않는 경우

        sum+=seq[index];
        sub(index + 1); //  포함하는 경우
        sum-=seq[index];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        sub(0);
        System.out.println(count);
    }
}
