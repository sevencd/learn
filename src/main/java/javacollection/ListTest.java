package javacollection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("a");list1.add("d");list1.add("b");
		Object[] str=list1.toArray();
		Object[] a=new Object[6];
		System.arraycopy(str,1,a,0,2);
		System.out.println(a[0]);
		System.out.println(a[1]);


		/*ArrayList e=new ArrayList(8);


		ArrayList<ArrayList> array=new ArrayList();
		list2.addAll(list1);
		Iterator iter=list2.iterator();
		while (iter.hasNext()){
			System.out.println(iter.next());
		}*/
	}

	

	private static void for1(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			list.remove(i);
		}
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
		}
		System.out.println(list.size());
	}
	private static void for2(List<String> list) {
		for(String s:list){
			list.remove(s);

		}
		for(String s:list){
			System.out.print(s);

		}
	}

}
