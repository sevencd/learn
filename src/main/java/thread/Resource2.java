package thread;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Resource2 {
	private boolean isSubTread = true;
	static Logger slflog = LoggerFactory.getLogger(Resource2.class);

	public synchronized void subProcess(int a) {
		while (!isSubTread) {
			try {
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		slflog.info("子线程开始轮询第"+(a+1)+"次");

		for (int i = 0; i < 40; i++) {
			slflog.info("子线程" + Thread.currentThread().getName() + "执行到"+(i+1));
		}

		isSubTread = false;

		notify();
	}

	public synchronized void mainProcess(int b) {
		while (isSubTread) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		slflog.info("主线程开始轮询第"+(b+1)+"次");

		for (int i = 0; i < 40; i++) {
			slflog.info("主线程" + Thread.currentThread().getName() +"执行到"+(i+1));
		}
		isSubTread = true;
		notify();
	}

}
