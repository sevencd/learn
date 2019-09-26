package javacollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import algorithm.LRULinkedMap;
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

		map.put("e", new Student());

		map.put("d", new Student());
		map.put("c", new Student());
	
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

		map.put("e", new Student());

		map.put("d", new Student());
		map.put("c", new Student());
	
		Set<Entry<String, Object>> e=map.entrySet();
		Iterator<Entry<String, Object>> iter=e.iterator();
		while(iter.hasNext()){
			Entry<String, Object> entry=iter.next();
			System.out.println(entry.getKey()+"***"+entry.getValue().toString());
		}

	}
	private static void testLinkedHashMap(){
		LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75F, true){
			@Override
			protected boolean removeEldestEntry(Map.Entry<String, String> eldes) { // 实现自定义删除策略，否则行为就和普遍Map没有区别
				return size() > 3;
			}
		};
		accessOrderedMap.put("Project1", "Valhalla");
		accessOrderedMap.put("Project2", "Panama");
		accessOrderedMap.put("Project3", "Loom");
		accessOrderedMap.forEach( (k,v) -> {
			System.out.println(k +":" + v);
		});
		// 模拟访问
		accessOrderedMap.get("Project2");
		accessOrderedMap.get("Project2");
		accessOrderedMap.get("Project3");
		System.out.println("Iterate over should be not afected:");
		accessOrderedMap.forEach( (k,v) -> {
			System.out.println(k +":" + v);
		});
		// 触发删除
		accessOrderedMap.put("Project4", "Mission Control");
		System.out.println("Oldes entry should be removed:");
		accessOrderedMap.forEach( (k,v) -> {// 遍历顺序不变
			System.out.println(k +":" + v);
		});
	}
}
