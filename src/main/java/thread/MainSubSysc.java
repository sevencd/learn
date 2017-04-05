package thread;

public class MainSubSysc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Resource2 r=new Resource2();
		
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<50;i++){
					r.subProcess(i);
				}
			}
		}).start();
		for(int j=0;j<50;j++){
			r.mainProcess(j);
		}
	}

}
