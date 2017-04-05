package designpattern.Builder;

import java.util.ArrayList;
import java.util.List;

import designpattern.ordinaryfactory.ISender;
import designpattern.ordinaryfactory.MailSender;
import designpattern.ordinaryfactory.SmsSender;

public class Builder {
	private List<ISender> list = new ArrayList<ISender>();  
    
    public void produceMailSender(int count){  
        for(int i=0; i<count; i++){  
            list.add(new MailSender());  
        }  
    }  
      
    public void produceSmsSender(int count){  
        for(int i=0; i<count; i++){  
            list.add(new SmsSender());  
        }  
    }  
    public List<ISender> getList(){
    	return list;
    }
}
