import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> unheard = new ArrayList<>(); //듣보 입력
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        ArrayList<String> unseen = new ArrayList<>(); //보도 입력
        for (int i = 0; i < M; i++) {
            unseen.add(br.readLine());
        }
        // 각 배열 오름차순 정렬
        Collections.sort(unheard); 
        Collections.sort(unseen);

        ArrayList<String> result = new ArrayList<>();
        int i = 0, j = 0;
        // 중복 비교 
        while (i < N && j < M) {
            int k = unheard.get(i).compareTo(unseen.get(j));
            if (k == 0) {
                result.add(unheard.get(i));
                i++;
                j++;
            } else if (k < 0) {
                i++;
            } else {
                j++;
            }
        }

        //결과 출력
        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}
