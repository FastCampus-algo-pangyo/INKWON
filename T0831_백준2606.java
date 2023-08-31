import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static Set<Integer> visited = new HashSet<>();

    public static void dfs(int node) {
        if (visited.contains(node)) return;

        visited.add(node);
        for (int i = 0; i < graph.get(node).size(); i++) {
            int child = graph.get(node).get(i);
            dfs(child);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 미리 초기화....
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        int line = Integer.parseInt(br.readLine());

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);
        System.out.println(visited.size() - 1);
    }
}
