package hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int max = 0;
        Queue<Integer> que = new PriorityQueue<>(k);
        for(int i = 0; i < contests.length; i++){
            if(que.size() < k && contests[i][1] == 1){
                max += contests[i][0];
                que.offer(contests[i][0]);
            }
            else if(que.size() >= k && contests[i][0] > que.peek() && contests[i][1] == 1){
                int last = que.poll();
                max -= (last * 2);
                que.offer(contests[i][0]);
                max += contests[i][0];
            }else if (contests[i][1] == 0){
                max += contests[i][0];
            }else if (contests[i][1]  == 1){
                max -= contests[i][0];
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
