package designpattern.abstractFactory;

import designpattern.ordinaryfactory.ISender;
import designpattern.ordinaryfactory.SmsSender;

public class SendSmsFactory implements Provider {

	public ISender produce() {
        return new SmsSender();
	}

}
