package designpattern.factorymethed;

import designpattern.ordinaryfactory.ISender;
import designpattern.ordinaryfactory.MailSender;
import designpattern.ordinaryfactory.SmsSender;

public class SendFactory {
	public  ISender produceMail() {
		return new MailSender();
	}

	public  ISender produceSms() {
		return new SmsSender();
	}
}
