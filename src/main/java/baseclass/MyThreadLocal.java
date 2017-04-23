package baseclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyThreadLocal<T> extends ThreadLocal<T> {
	private T t;
	@Override
	public T initialValue(){
		return t;
	}

}
