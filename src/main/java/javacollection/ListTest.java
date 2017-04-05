package javacollection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		System.out.println(list.size());
		//for2(list);

		

	}

	

	private static void for1(List<String> list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			list.remove(i);
		}
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
		}
		System.out.println(list.size());
	}
	private static void for2(List<String> list) {
		// TODO Auto-generated method stub
		for(String s:list){
			list.remove(s);

		}
		for(String s:list){
			System.out.print(s);

		}
	}

}
