package com.csz.designpattern;

import java.util.Observable;
import java.util.Observer;

public class MyObserve implements Observer{

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("被监控对象内容发生变化");
	}

}
