package designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicHandler implements InvocationHandler {
	private Object targetObject;


	public Object getProxyInstance(Object targetObject) {
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(),
				this);

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj = null;
		beforeLog();
		obj = method.invoke(targetObject, args);
		afterLog();
		return obj;
	}

	private void afterLog() {
		System.out.println("after log");
	}

	private void beforeLog() {
		System.out.println("before log");

	}

}
