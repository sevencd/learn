package designpattern.factorymethed;

import designpattern.ordinaryfactory.ISender;

public class FactoryTest {

	public static void main(String[] args) {
        ISender sender = StaticSendFactory.produceMail();  
        sender.send(); 
	}

}
