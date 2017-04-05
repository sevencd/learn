package designpattern.proxy;

public class Main {
	public static void main(String[] args) {
		IUserDao userDao=new UserDao();
		IUserDao userDaoProxy=(IUserDao) new MyDynamicHandler().getProxyInstance(userDao);
		userDaoProxy.save();
	}
}
