import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] T, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N+1];
        P = new int[N+1];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(1, 0));
    }

    public static int solve(int day, int sum) {
        if(day > N) return sum;
        if(day + T[day] - 1 > N) return solve(day + 1, sum);
        return Math.max(solve(day + 1, sum), solve(day + T[day], sum + P[day]));
    }
}
