package datastruct.line;

import java.util.Queue;

public class WordReverse {
	private String str;
	public WordReverse(String str) {
		this.str=str;
	}
	public String doReverse(){
		CharStack c=new CharStack(str.length());
		for (int i = 0; i < str.length(); i++) {
			c.push(str.charAt(i));
		}
	/*	char[] newC=new char[str.length()];
		for (int i = 0; i < str.length()&&!c.isEmpty(); i++) {
			newC[i]=c.pop();
		}
		String s=new String(newC);*/
		String output="";
		while(!c.isEmpty()){
			char t=c.pop();
			output+=t;
		}
		return output;
	}
	public static void main(String[] args) {
		WordReverse r=new WordReverse("北京欢迎你");
		System.out.println(r.doReverse());
		java.util.PriorityQueue<?> pq;
	}
}
