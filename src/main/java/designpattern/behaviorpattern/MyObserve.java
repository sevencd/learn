package designpattern.behaviorpattern;

import java.util.Observable;
import java.util.Observer;

public class MyObserve implements Observer{

	public void update(Observable o, Object arg) {
		System.out.println("被监控对象内容发生变化");
	}

}
