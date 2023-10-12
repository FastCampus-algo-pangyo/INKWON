import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        int[] result = solution(sequence, k);

        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] result = new int[2];

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += sequence[end];
                
                if (sum == k) {
                    if (result[0] == 0 && result[1] == 0 || (end - start) < (result[1] - result[0])) {
                        result[0] = start;
                        result[1] = end;
                    }
                }
            }
        }
        return result;
    }
}
