import java.util.*;


class Solution {
    public int solution(String[][] book_time) {
        List<int[]> times = new ArrayList<>();
            List<int[]> rooms = new ArrayList<>();

            for (int i = 0; i < book_time.length; i++) {
                int start = Integer.parseInt(book_time[i][0].replace(":", ""));
                int end = Integer.parseInt(book_time[i][1].replace(":", ""));
                times.add(new int[]{start, end});
            }


            Collections.sort(times, new Comparator<int[]>() {

                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });


            for (int i = 0; i < times.size(); i++) {
                boolean reserve = false;

                for (int j = 0; j < rooms.size(); j++) {
                    if (rooms.get(j)[1] + 10 <= times.get(i)[0]) {
                        rooms.get(j)[1] = times.get(i)[1];
                        reserve = true;
                        break;
                    }
                }


                // 기존 방들에 들어갈 자리가 없다면 새로운 방 생성
                if (!reserve) {
                    rooms.add(new int[]{times.get(i)[0], times.get(i)[1]});
                }
            }


            return rooms.size();
        }
}
