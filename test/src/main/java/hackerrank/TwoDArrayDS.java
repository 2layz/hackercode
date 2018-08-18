package hackerrank;

import java.util.Scanner;

public class TwoDArrayDS {
    public static void main(String ... args){
        int arr [][] = readArray();
        int max = findMax(arr);
        System.out.println(max);
    }

    private static int findMax(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        while(i < 4) {
            for (int j = 0; j < 4; j++) {
                int sum = arr[i][j]+arr[i][j+1]+arr[i][j+2];
                sum += arr[i+1][j+1];
                sum += arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                if(sum > max){
                    max = sum;
                }
            }
            i++;
        }
        return max;
    }

    private static int[][] readArray() {
        int [][] arr = new int[6][6];
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        in.close();
        return arr;
    }
}
