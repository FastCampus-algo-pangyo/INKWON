import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T0719 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());


        long[] li = new long[117];
        li[1] = li[2] = li[3] = 1;
        for (int i = 4; i <= a; i++) {
            li[i] = li[i - 1] + li[i - 3];
        }
        System.out.print(li[a]);
    }
}
