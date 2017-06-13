package com.twilio;

import java.util.concurrent.TimeUnit;

import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public abstract class CompareSms {
	public static final String ACCOUNT_SID = "AC3e674863086b91d4a48885977cd375cc";
	public static final String AUTH_TOKEN = "935959939532b59a79a49ae9046f60ea";
	
	
	public static boolean newMessage (String from){
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    //Long number = new Long(17033045506L);
    int count1= 0;
    int count2=0;
    int sleep = 3;
    ResourceSet<Message> messages = Message.reader().read();
    ResourceSet<Message> messages2 = Message.reader().read();
	count1 = 0;
    for (Message message : messages) {
    	if(message.getFrom().toString().equals(from)){
    		//System.out.println(message.getBody());
    		count1++;
    		//System.out.println(message.getFrom());
    		//System.out.println("Hello");
    		//break;
    		
    	}
    }
    do{

	    //System.out.println("Count1: "+count1);
	    	try{
	    		TimeUnit.SECONDS.sleep(sleep);
	    	}
	    	catch(InterruptedException e){
	    		
	    	}
	    	//To add delays for long responses to cut down on processing
	    	if(sleep<3){
	    		sleep++;
	    	}
	    	count2 = 0;
	        for (Message message2 : messages2) {
	        	if(message2.getFrom().toString().equals(from)){
	        		//System.out.println(message.getBody());
	        		count2++;
	        		//System.out.println(message.getFrom());
	        		//System.out.println("Hello");
	        		//break;
	        	}
	        }
	        //System.out.println("Count2: "+count2);
	        if(count1<count2){
	        	return true;
	        }
	        //System.out.println(sleep);
	        messages2 = Message.reader().read();
    }while(count1==count2);
    return false;
	}
	
	
	
	public static boolean newRequest (String play){
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    //Long number = new Long(17033045506L);
	    int count1= 0;
	    int count2=0;
	    int sleep = 3;
	    ResourceSet<Message> messages = Message.reader().read();
	    ResourceSet<Message> messages2 = Message.reader().read();
		count1 = 0;
	    for (Message message : messages) {
	    	if(message.getBody().toString().toLowerCase()/*.substring(0, play.length())*/.contains(play.toLowerCase())){
	    		//System.out.println(message.getBody());
	    		count1++;
	    		//System.out.println(message.getFrom());
	    		//System.out.println("Hello");
	    		//break;
	    		
	    	}
	    }
	    do{

		   // System.out.println("Count1: "+count1);
		    	try{
		    		TimeUnit.SECONDS.sleep(sleep);
		    	}
		    	catch(InterruptedException e){
		    		
		    	}
		    	//To add delays for long responses to cut down on processing
		    	if(sleep<3){
		    		sleep++;
		    	}
		    	count2 = 0;
		        for (Message message2 : messages2) {
		        	if(message2.getBody().toString().toLowerCase()/*.substring(0, play.length())*/.contains(play.toLowerCase())){
		        		//System.out.println(message.getBody());
		        		count2++;
		        		//System.out.println(message.getFrom());
		        		//System.out.println("Hello");
		        		//break;
		        	}
		        }
		        //System.out.println("Count2: "+count2);
		        if(count1<count2){
		        	return true;
		        }
		       // System.out.println(sleep);
		        messages2 = Message.reader().read();
	    }while(count1==count2);
	    return false;
		}
}
