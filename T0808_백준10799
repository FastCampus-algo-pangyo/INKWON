import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int result = 0;
        int temp = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    temp -= 1;
                    result += temp;
                }
                if (s.charAt(i - 1) == ')') {
                    result += 1;
                    temp-=1;
                }
            } else if (s.charAt(i) == '(') {
                temp += 1;
            }


        }
            System.out.println(result);
    }
}
