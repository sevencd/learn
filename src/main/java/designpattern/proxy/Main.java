package designpattern.proxy;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

public class Main {
	public static void main(String[] args) {
		IUserDao userDao=new UserDao();
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
