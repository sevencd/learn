package designpattern.abstractFactory;

import designpattern.ordinaryfactory.ISender;
import designpattern.ordinaryfactory.MailSender;

public class SendMailFactory implements Provider {

	public ISender produce() {
        return new MailSender();
	}

}
