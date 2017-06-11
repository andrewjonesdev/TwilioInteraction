package com.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {
	
	public static final String ACCOUNT_SID = "AC3e674863086b91d4a48885977cd375cc";
	public static final String AUTH_TOKEN = "935959939532b59a79a49ae9046f60ea";

	public static void send(String to, String from, String body){
		// TODO Auto-generated method stub
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		Message message = Message.creator(new PhoneNumber(to),new PhoneNumber(from),body).create();
	
		//System.out.println(message.getSid());
	}

}
