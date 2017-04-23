package baseclass;

import java.util.concurrent.atomic.AtomicInteger;

public class IntegerTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static final int HASH_INCREMENT = 0x61c88647;

	public static void main(String[] args) {
		atomicInteger.getAndAdd(HASH_INCREMENT);
		System.out.println(atomicInteger.get());
	    System.out.println(atomicInteger.get()&15);
		atomicInteger.getAndAdd(HASH_INCREMENT);
		System.out.println(atomicInteger.get());
	    System.out.println(atomicInteger.get()&15);
		atomicInteger.getAndAdd(HASH_INCREMENT);
		System.out.println(atomicInteger.get());
	    System.out.println(atomicInteger.get()&15);
	}
	//将正整数字符串转换为数字
	public static int parseToInt(String s){
		int r=0;
		int i=0; int digit;
		while(i<s.length()){
			digit = s.charAt(i++)-'0';
			r=r*10+digit;
		}
		return r;
	}
	public static void getBytes(){
		byte[] a="ab".getBytes();
		
		System.out.println(a.length);
		System.out.println(a[0]);
		System.out.println(a[1]);

	}
	public static void atomicInteger(){
		AtomicInteger a=new AtomicInteger();
		System.out.println(a.getAndIncrement());
		System.out.println(a.intValue());

	}
	protected static class ThreadLocalMap{
		int a=2;
		int getA(){
			return a;
		}
	}
}
