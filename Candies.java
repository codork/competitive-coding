import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Collections;
import java.util.Arrays;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        long c[] = new long[n+2];
        for(int k=0; k<n+2; k++) {
            c[k] = 0;
        }
        long count = 0;
        int j = 1;
        if(arr[0] <= arr[1]) 
            c[0] = 1;
        else if(arr[0] > arr[1]) 
            c[0] = 2;
        count += c[0];
        int i;
        for(i=1; i<n-1; i++) {
            int minindex = i;
            if(arr[i-1] <= arr[i]) 
                minindex = i-1;
            else
                minindex = i+1;
            
            c[j] = c[minindex] + 1;
            count += c[j];
            j++;
        }
        if(arr[i-1] < arr[i])
            count += c[i-1] + 1;
        else 
            count += 1;
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
