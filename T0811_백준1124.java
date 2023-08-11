import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int A=0;
    static int B=0;
    static int result =0;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        A =scan.nextInt();
        B =scan.nextInt();

        for (int i = A; i <= B; i++) {

            int temp = i;
            int count = 0;
            for (int j = 2; j < i ; j++) {
                while(isPrime(j) && (temp%j==0) && temp>1){
                    count++;
                    temp /= j;
                }
            }

            if(isPrime(count)) {

            result++;
                System.out.println(i);

            }

        }

        System.out.println(result);
    }


    public static boolean isPrime(int num){

        if(num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
이렇게 바꿔도 시간 초과... ㅠㅠ



import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int A=0;
    static int B=0;
    static int result =0;
    static ArrayList<Integer> sosu = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        A =scan.nextInt();
        B =scan.nextInt();
        for (int i = 1; i < B; i++) {
            if(isPrime(i)) {
                sosu.add(i);
            }
        }

        for (int i = A; i <= B; i++) {

            int temp = i;
            int count = 0;
            System.out.println("i = " + i);



            for (int j = 2; j < i ; j++) {
                while( sosu.contains(j) && (temp%j==0)){
                    count++;
                    temp /= j;
                }
            }

            if(isPrime(count)) {

            result++;
                System.out.println(i);
            }

        }

        System.out.println(result);
    }


    public static boolean isPrime(int num){

        if(num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}
