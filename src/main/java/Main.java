

import thread.Package;
import thread.PackageChannel;
import thread.RRWLock;
import thread.StampedLockPoint;
import thread.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.LongAdder;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
			// 新建 8 个工人
			final PackageChannel channel = new PackageChannel(8);
			// 开始工作
			channel.startWorker();
			// 为流水线添加包裹
			for(int i=0; i<100; i++) {
				thread.Package packagereq = new Package();
				packagereq.setAddress("test");
				packagereq.setName("test");
				channel.put(packagereq);
			}
		}
}
