package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArrays {


    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] ms = new int[queries.length];
        Map<String, Integer> stringCount = getCounts(strings);
        for(int i = 0; i < queries.length; i++){
            if(stringCount.containsKey(queries[i])){
                ms[i] = stringCount.get(queries[i]);
            }
        }

        return ms;
    }

    private static Map<String, Integer> getCounts(String[] strings){
        Map<String, Integer> stringCount = new HashMap<>();
        for(int j = 0; j< strings.length; j++){
            if(stringCount.containsKey(strings[j])){
                int count = stringCount.get(strings[j]);
                stringCount.put(strings[j], (count+1));
            }else{
                stringCount.put(strings[j], 1);
            }
        }
        return stringCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
