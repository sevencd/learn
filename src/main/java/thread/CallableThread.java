package thread;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.apache.log4j.Logger;

public class CallableThread {
	public static <T> T run(Callable<T> callable) throws InterruptedException, ExecutionException {

		FutureTask<T> future = new FutureTask<T>(callable);
		Thread callThread = new Thread(future);
		callThread.start();
		return future.get();
	}

	public static <T> T runByPool(Callable<T> callable) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<T> future = threadPool.submit(callable);
		return future.get();
	}

	public static void main(String[] args) {
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() throws Exception {
				System.out.println("aaa");
				return new Random().nextInt(100);
			}
		};
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		Thread callThread = new Thread(future);
		callThread.start();
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
