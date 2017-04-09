package designpattern.proxy;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

public class Main {
	public static void main(String[] args) {
		Class c=UserDao.class;
		
		IUserDao userDao=null;
		try {
			userDao = (IUserDao) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		IUserDao userDaoProxy=(IUserDao) new MyDynamicHandler().getProxyInstance(userDao);
		userDaoProxy.save();
		IUserDao userDaoProxy2=(IUserDao) buildProxyObject(userDao,UserDao.class.getInterfaces());
		userDaoProxy2.save();

	}
	public static Object buildProxyObject(Object target, Class<?>[] targetIntf) {
		Object proxyObject;
		ProxyFactory pf = null;
		pf = new ProxyFactory();
		pf.addInterface(targetIntf[0]);
		pf.setTarget(target);
		proxyObject = pf.getProxy();
		return proxyObject;
	}
}
