package thread;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.apache.log4j.Logger;

public class CallableThread {
	public static void main(String[] args) {
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() throws Exception {
				System.out.println("aaa");
				return new Random().nextInt(100);
			}
		};
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		Thread callThread=new Thread(future);
		callThread.start();
		try {
			Thread.sleep(5000);// 可能做一些事情
			System.out.println(future.get());
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
