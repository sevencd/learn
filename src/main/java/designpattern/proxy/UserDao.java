package designpattern.proxy;

public class UserDao implements IUserDao {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("添加用户成功");
	}

}
