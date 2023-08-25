
/* 
1. 입력받은 두개의 노드의 공통 조상을(효율적으로)찾아서
2. 각 노드부터 공통조상까지의 거리를 합하여 출력 
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최대 노드 번호 입력(안쓰임)
        int n = Integer.parseInt(br.readLine());

        // 두 노드 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        // 부모 자식들 간의 관계 개수 입력
        int m = Integer.parseInt(br.readLine());

        // 부모 자식 관계를 저장할 hashmap
        Map<Integer, Integer> family = new HashMap<>();

        // 관계 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            family.put(child, parent);
        }

        //선택한 두노드의 조상들(몇명일지모름)을 list 로 받아서
        //둘이 공통 조상이 있는지 2번 노드를 (검색이 빠른 자료구조인) hashset에 넣고 1번 조상들중에 있는지 검색
        List<Integer> ancestors1 = getAncestors(family, node1);
        List<Integer> acnestors2 = getAncestors(family, node2);
        Set<Integer> sameAncestor = new HashSet<>(acnestors2);

        //공통 없어서 result 갱신 안될경우 이대로 -1로 출력
        int result = -1;

        //공통 조상이 나온다면 1번의 공통조상까지의 거리 'i'와 , 2번의 공통조상까지의 거리를 합하여 result로 전달
        for (int i = 0; i < ancestors1.size(); i++) {
            if (sameAncestor.contains(ancestors1.get(i))) {
                result = i + acnestors2.indexOf(ancestors1.get(i));
                break;
            }
        }

        System.out.println(result);
    }

    public static List<Integer> getAncestors(Map<Integer, Integer> map, int node) {
        List<Integer> ancestors = new ArrayList<>();   //반환 리스트

        //부모가 있으면, 부모를 node에 재 갱신해서 최종 조상님까지 ancestors 리스트에 순서대로 저장.
        while (map.containsKey(node)) {
            ancestors.add(node);
            node = map.get(node);
        }
        ancestors.add(node);  // 마지막 조상 노드 추가

        return ancestors;
    }
}
