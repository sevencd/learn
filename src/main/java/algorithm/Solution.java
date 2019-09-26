package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    //leetcode002
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    //leetcode003
    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        int max = 1;
        String tmpStr;
        char c;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                c = s.charAt(j);
                tmpStr = s.substring(i, j);
                if (isInTheString(tmpStr, c)) {
                    break;
                }
                int subStrLen = tmpStr.length() + 1;
                if (subStrLen > max) {
                    max = subStrLen;
                }
            }
        }
        return max;
    }


    private boolean isInTheString(String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }
    //leetcode003
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    //leetcode014
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)return "";
        int len=strs.length;
        StringBuilder res=new StringBuilder();
        char c;
        for (int i = 0; i < strs[0].length(); i++) {
            c=strs[0].charAt(i);
            for (int j = 1; j <len ; j++) {
                if(strs[j].length()<i+1||strs[j].charAt(i)!=c){
                    return res.toString();
                }
            }
            res.append(c);
        }

        return res.toString();
    }
    //leetcode028 暴力匹配
    public int strStr(String haystack, String needle) {
        if(haystack==null)return -1;
        if(needle==null)return 0;
        int hlen=haystack.length();
        int nlen=needle.length();
        if(hlen<nlen)return -1;
        char[] harr=haystack.toCharArray();
        char[] narr=needle.toCharArray();
        //从主串的起始位置（或指定位置）开始与模式串的第一个字符比较，若相等，则继续逐个比较后续字符；否则从主串的下一个字符再重新和模式串的字符比较。依次类推，直到模式串成功匹配，返回主串中第一次出现模式串字符的位置，或者模式串匹配不成功，这里约定返回-1；
        int i=0,j=0;
        while (i<hlen&&j<nlen){
            if(harr[i]==narr[j]){
                ++i;++j;//如果i,j位置上的字符匹配成功就继续向后匹配
            }else {
                i = i - (j -1);            //i回溯到主串上一次开始匹配下一个位置的地方
                j = 0;                    //j重置，模式串从开始再次进行匹配
            }
        }
        if(j == nlen)                    //匹配成功
            return i - j;
        else
            return -1;                    //匹配失败
    }
    //leetcode796
    public boolean rotateString(String A, String B) {
        String s="hello";
        A=A+A;
        if(A.contains(B)){
            return true;
        }
        return false;
    }
}
