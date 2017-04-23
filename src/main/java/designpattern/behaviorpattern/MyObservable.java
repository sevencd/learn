package designpattern.behaviorpattern;

import java.util.Observable;
import java.util.Observer;

public class MyObservable extends Observable {
	//注册观察者
	public void registObs(){
		
	}
	public static void main(String[] args) {
		Observer o=new MyObserve();
		MyObservable ob=new MyObservable();
		ob.addObserver(o);
		ob.setChanged();
		ob.notifyObservers();
	
	}
	@Override
	protected synchronized void setChanged() {
		// TODO Auto-generated method stub
		super.setChanged();
	}
}
