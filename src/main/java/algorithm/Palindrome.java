package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        String s="1235665321";
        //changeString(s);
        Character c1=new Character('A');
        Character c2=new Character('A');
//		boolean result=isEqualIgnoreCase(c1,c2);
        boolean result=isPalindrome(s);
        if(result) {
            System.out.println(s);
        }else {
            System.out.println("false");
        }
    }
    public static boolean isPalindrome(String s) {
        if(s==null||s.length()==0) {
            return true;
        }
        String str=null;
        List<Character> c=new ArrayList<Character>();
        int i,j;
        for(i=0;i<s.length();i++) {
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                c.add(s.charAt(i));
            }
        }
        int n=s.length();
        int m = n>>1;
        double mm=n/2;
        System.out.println("总长度"+n+"中间数"+m+"中间数"+mm);

        System.out.println(c.toString());
        for(i=0,j=c.size()-1;i<c.size()/2;i++,j--) {
            if(!isEqualIgnoreCase(c.get(i),c.get(j))) {
                return false;
            }
        }
        return true;
    }

    //忽略大小写比较字符是否相等
    public static boolean isEqualIgnoreCase(Character c1,Character c2) {
        if(c1==null&&c2==null) {
            return true;
        }
        if((c1==null&&c2!=null)||(c1!=null&&c2==null)) {
            return false;
        }
        Character c11;
        if(c1.isUpperCase(c1)) {
            c11=c1.toLowerCase(c1);
        }else {
            c11=c1.toUpperCase(c1);
        }
        if(c1.equals(c2)||c11.equals(c2)) {
            return true;
        }
        return false;
    }
}
