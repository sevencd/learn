package designpattern.abstractFactory;

import designpattern.ordinaryfactory.ISender;
import designpattern.ordinaryfactory.MailSender;

public class SendMailFactory implements Provider {

	public ISender produce() {
		// TODO Auto-generated method stub
        return new MailSender();  
	}

}
