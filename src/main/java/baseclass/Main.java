package baseclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
			Class<?> customerApplication = classLoader
					.loadClass("baseclass.Son");
			Constructor<?> constructor = customerApplication
					.getConstructor();
			/*Method m=customerApplication.getMethod("a", void.class);*/
			Son son=(Son) constructor.newInstance();
			ClassLoader classLoader2 = Son.class.getClassLoader();
			son.a("s");
			
			System.out.println("成功");
	}

}
