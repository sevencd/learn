package designpattern.ordinaryfactory;

public class FactoryTest {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		ISender sender = factory.produce("sms");
		sender.send();
	}

}
