package designpattern.proxy;

public class UserDao implements IUserDao {

	@Override
	public void save() {
		System.out.println("添加用户成功");
	}

}
