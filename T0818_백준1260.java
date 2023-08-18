import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()); 

        graph = new ArrayList[N + 1];

     
        for (int i = 0; i <= N; i++) {    
            graph[i] = new ArrayList<>();
        } 
      //간선 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

      //노드, 간선 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

      //visited 초기화 후 dfs 함수 실행
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

      //visited 초기화 후 bfs 함수 실행
        visited = new boolean[N + 1];
        bfs(V);
    }


  
  
    private static void dfs(int v) {
    System.out.print(v + " ");
    visited[v] = true;

    for (int i = 0; i < graph[v].size(); i++) {
        int next = graph[v].get(i);
        if (!visited[next]) {    //방문한 곳이 아니라면 정렬된 다음 연결 노드로
            dfs(next);
            }
        }
    }



  
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {    //더 추가할 인접 노드가 없을때 poll 하고 출력
            int v = queue.poll();
            System.out.print(v + " ");

        for (int i = 0; i < graph[v].size(); i++) {  //방문한 곳이 아니라면 정렬된 다음 노드 방문처리 후 포함 원소 큐에 추가
                int next = graph[v].get(i);
                if (!visited[next]) {    
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
