package baseclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.csz.domain.Student;

public class MapTest {
	/*private static ThreadLocal<Student> threadLocal = new ThreadLocal<Student>();

	public void threadLocalTest() {
		for (int i = 0; i < 10; i++) {
			Student stu = new Student(i);
			threadLocal.set(stu);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(threadLocal.get().getId());
		}
	}
*/
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		for (int i = 0; i < 2; i++) {
			Student stu = new Student(i);
			System.out.println(stu.hashCode());
			map.put(stu, i);
		}
		for (int i = 0; i < 2; i++) {
			Student stu = new Student(i);
			System.out.println(stu.hashCode());
			map.put(stu, i);
		}
		 Set<Map.Entry<Student, Integer>> set=map.entrySet();
		 for (Iterator<Entry<Student, Integer>> iterator = set.iterator(); iterator.hasNext();) {
			Map.Entry<Student, Integer> entry = iterator.next();
			System.out.println(entry.getKey().getId()+"---"+entry.getValue());

		}
		 Set<Student> s= map.keySet();
		 for (Iterator<Student> iterator2 = s.iterator(); iterator2.hasNext();) {
			Student student = (Student) iterator2.next();
			map.get(student);
			System.out.println(student.getId()+"---"+map.get(student));
		}
		 System.out.println(s.size());
		 
	}

}
