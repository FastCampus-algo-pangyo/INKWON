import java.io.*;
import java.util.Stack;

public class T0721 {
    // 17413
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String text = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '<') {
                while(!stack.isEmpty()) {sb.append(stack.pop());}   //< 만나기전 문자열들 뱉어냄
                while(text.charAt(i) != '>') {
                    sb.append(text.charAt(i++));
                }
                    sb.append(text.charAt(i));


            }
            else if (text.charAt(i) == ' ') {
                while(!stack.isEmpty()) sb.append(stack.pop());     //  '공백' 만나기전 문자열들 뱉어냄
                    sb.append(text.charAt(i));
            } else
                    stack.push(text.charAt(i));
        }

                while(!stack.isEmpty()) sb.append(stack.pop());    // 최후의 '<' 나 '공백' 만나지 않은 text 뱉어냄


        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
