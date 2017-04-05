package designpattern.factorymethed;

import designpattern.ordinaryfactory.ISender;
import designpattern.ordinaryfactory.MailSender;
import designpattern.ordinaryfactory.SmsSender;

public class StaticSendFactory {
	public static ISender produceMail() {
		return new MailSender();
	}

	public static ISender produceSms() {
		return new SmsSender();
	}
}
