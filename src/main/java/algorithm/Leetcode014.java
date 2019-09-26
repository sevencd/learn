package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leetcode014 {
    public static void main(String[] args) throws IOException {
        String[] line =new String[]{ "flower","flow","flight"};

        System.out.print(new Solution().longestCommonPrefix(line));
    }
}
