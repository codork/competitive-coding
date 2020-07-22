/*
In Byteland they have a very strange monetary system.

Each Bytelandian gold coin has an integer number written on it. 
A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. 
But these numbers are all rounded down (the banks have to make a profit).

You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.

You have one gold coin. What is the maximum amount of American dollars you can get for it?

Input
The input will contain several test cases (not more than 10). Each testcase is a single line with a number n, 0 <= n <= 1 000 000 000. It is the number written on your coin.

Output
For each test case output a single line, containing the maximum amount of American dollars you can make.
*/

import java.util.*;

public class Coins {
    public static int[] maxD;

    public static int maxDollars(int n) {
        //n=12 -> 6, 4, 3 -> 3, 2, 1 + 2, 1, 1 + 1, 1, 0 max(maxDollars(x), x) 
        //n=24 -> 12, 8, 6 -> 26
        //n=1 -> 1, n=2 -> max(n/2 + n/3 + n/4, n) = max((1+0+0), 2) = 2
        if(n==0)
            return 0;
        if(n==1) 
            return 1;
        if(maxD[n] != -1)
            return maxD[n];
        return maxD[n] = Math.max((maxDollars(n/2) + maxDollars(n/3) + maxDollars(n/4)), n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        maxD = new int[n+1];
        maxD[0] = 0;
        for(int i=1; i<n+1; i++) 
            maxD[i] = -1;
        System.out.println(maxDollars(n));

    }
}