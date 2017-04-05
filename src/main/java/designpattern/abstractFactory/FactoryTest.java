package designpattern.abstractFactory;

import designpattern.ordinaryfactory.ISender;

public class FactoryTest {

	public static void main(String[] args) {
		Provider provider = new SendMailFactory();
		ISender sender = provider.produce();
		sender.send();
	}

}
