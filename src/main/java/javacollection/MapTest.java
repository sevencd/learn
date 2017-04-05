package javacollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.annotation.SynthesizedAnnotation;

import com.csz.domain.Student;

public class MapTest {
	public static void main(String[] args) {
		testHashMap();
		System.out.println("****");
		testTreeMap();
		System.out.println("****");
		testLinkedHashMap();
	}
	private static void testHashMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("a", new Student());
		map.put("b", new Student());

		map.put("c", new Student());

		map.put("d", new Student());
		map.put("e", new Student());
	
		Set<Entry<String, Object>> e=map.entrySet();
		Iterator<Entry<String, Object>> iter=e.iterator();
		while(iter.hasNext()){
			Entry<String, Object> entry=iter.next();
			System.out.println(entry.getKey()+"***"+entry.getValue().toString());
		}

	}
	private static void testTreeMap(){
		Map<String,Object> map=new TreeMap<String,Object>();
		map.put("a", new Student());
		map.put("b", new Student());

		map.put("c", new Student());

		map.put("d", new Student());
		map.put("e", new Student());
	
		Set<Entry<String, Object>> e=map.entrySet();
		Iterator<Entry<String, Object>> iter=e.iterator();
		while(iter.hasNext()){
			Entry<String, Object> entry=iter.next();
			System.out.println(entry.getKey()+"***"+entry.getValue().toString());
		}

	}
	private static void testLinkedHashMap(){
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("a", new Student());
		map.put("b", new Student());

		map.put("c", new Student());

		map.put("d", new Student());
		map.put("e", new Student());
	
		Set<Entry<String, Object>> e=map.entrySet();
		Iterator<Entry<String, Object>> iter=e.iterator();
		while(iter.hasNext()){
			Entry<String, Object> entry=iter.next();
			System.out.println(entry.getKey()+"***"+entry.getValue().toString());
		}

	}
}
