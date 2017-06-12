package com.twilio;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class ListMessage {
  // Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC3e674863086b91d4a48885977cd375cc";
	public static final String AUTH_TOKEN = "935959939532b59a79a49ae9046f60ea";

  public static String receiveSMS(String from){
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    //Long number = new Long(17033045506L);
    ResourceSet<Message> messages = Message.reader().read();
    //String bin = "";
    // Loop over messages and print out a property for each one.
    /*for (Message message : messages) {
    	if(message.getTo().equals("+17032935022")){
    		System.out.println(message.getBody());
    		System.out.println(message.getFrom());
    		System.out.println(message.getFrom().toString());
    		System.out.println(Long.parseLong(message.getFrom().toString().substring(1)));
    		Long longer = new Long (Long.parseLong(message.getFrom().toString().substring(1)));
    		System.out.println(longer.compareTo((number)));
    		System.out.println(message.getFrom().toString().equals("+17033045506"));
    	}
    }*/
    for (Message message : messages) {
    	if(message.getFrom().toString().equals(from)){
    		//System.out.println(message.getBody());
    		return message.getBody();
    		//System.out.println(message.getFrom());
    		//System.out.println("Hello");
    		//break;
    	}
    
    }
    return "No Message Sent From This User";
    
    /*for (Message message : messages) {
    	Long longer = new Long (Long.parseLong(message.getFrom().toString().substring(0)));
    	if( longer.compareTo((number))==1 ){
    		System.out.println(message.getBody());
    		System.out.println(message.getFrom());
    		System.out.println("hi");
    	}
    	
    }   */
    	
    
    
  }
  public static String receiveSpecificText(String play){
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    //Long number = new Long(17033045506L);
	    ResourceSet<Message> messages = Message.reader().read();
	    //String bin = "";
	
	    for (Message message : messages) {
	    	if(message.getBody().toString().toLowerCase()/*.substring(0, play.length())*/.equals(play.toLowerCase())){
	    		//System.out.println(message.getBody());
	    		System.out.println(message.getFrom().toString());
	    		return message.getFrom().toString();
	    		//System.out.println(message.getFrom());
	    		//System.out.println("Hello");
	    		//break;
	    	}
	    
	    }
	    return "No Message Sent with this value";
	    

	    
	  }
}