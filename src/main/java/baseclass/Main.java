package baseclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	static IntegerTest.ThreadLocalMap t=new IntegerTest.ThreadLocalMap();
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		MyThreadLocal<IntegerTest> t=new MyThreadLocal<IntegerTest>();
	}

}
