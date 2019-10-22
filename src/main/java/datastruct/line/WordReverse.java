package datastruct.line;

public class WordReverse {
	private String str;
	public WordReverse(String str) {
		this.str=str;
	}
	public String doReverse(){
		ArrayStack<Character> c=new ArrayStack(str.length());
		for (int i = 0; i < str.length(); i++) {
			c.push(str.charAt(i));
		}
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
