package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] book = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(sol.solution(book)); }
}


/**
 *  1. booktime 정수로 변환
 *  2. 오름차순 정렬
 *  3. 기존방 종료시간+10 <-> 가장 차이가 적은 배정 가능한방에 배정
 *  4. 안되면 새로운 방 생성 후 배정
* */

class Solution {
    public int solution(String[][] book_time) {
        List<int[]> times = new ArrayList<>();
        List<int[]> rooms = new ArrayList<>();


        //: 빼서 정수로 변환
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            times.add(new int[]{start, end});
        }


        //오름차순 정렬
        Collections.sort(times, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });



        for (int i = 0; i < times.size(); i++) {
            boolean reserve = false;

            //기존방에 배정가능할때
            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(j)[1] + 10 <= times.get(i)[0]) {
                    rooms.get(j)[1] = times.get(i)[1];
                    reserve = true;
                    break;
                }
            }


            //기존방중에 가능한 방이 없으면
            if (!reserve) {
                rooms.add(new int[]{times.get(i)[0], times.get(i)[1]});
            }
        }


        return rooms.size();
    }
}
