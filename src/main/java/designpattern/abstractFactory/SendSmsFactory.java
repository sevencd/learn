package designpattern.abstractFactory;

import designpattern.ordinaryfactory.ISender;
import designpattern.ordinaryfactory.SmsSender;

public class SendSmsFactory implements Provider {

	public ISender produce() {
		// TODO Auto-generated method stub
        return new SmsSender();  
	}

}
