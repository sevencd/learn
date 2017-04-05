package baseclass;

public class IntegerTest {
	public static void main(String[] args) {
		getBytes();

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
}
