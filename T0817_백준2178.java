import java.io.*;
import java.util.*;

public class A {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[][] distance;
    static int[] dx = {-1, 0, 1, 0};  // Up, Right, Down, Left
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];

		//배열 입력
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }


		//bfs 함수 실행
        bfs(0, 0);




		// 결과 배열 출력
		for (int N = 0; N < distance.length; N++) { 
			for (int M = 0; M < distance[0].length; M++) {
				System.out.print(distance[N][M] + 1);
				System.out.print(" ");
			}
			System.out.println();
		}
    }


		
    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) { //가능한 곳으로 이동
                    if (maze[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[current[0]][current[1]] + 1;
                    }
                }
            }
        }
    }
}

