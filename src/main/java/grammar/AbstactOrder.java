package grammar;

import java.util.HashMap;
import java.util.Map;

import baseclass.IntegerTest;
import baseclass.Main;

public  class AbstactOrder implements A {
	public void b() {
		HashMap<String, String> m;
	}

	@Override
	public void a(int a) {
		// TODO Auto-generated method stub
		System.out.println(a);
	}

	@Override
	public void a(String a) {
		// TODO Auto-generated method stub
		System.out.println(a+"dj");
	}
	public  static void main(String[] args){
		new AbstactOrder().a("3");
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("a", 1);
		int a=map.get("a");
		
	}
}
