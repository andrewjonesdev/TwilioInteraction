package com.twilio;


import static spark.Spark.post;

import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
//import com.twilio.twiml.*;
import com.twilio.twiml.MessagingResponse;

public abstract class ReturnSms {

	
	public static void reply(String to){
		
		post("/receive-sms", (req, res) -> {
			
			Message sms = new Message.Builder().to(to).body(new Body(ListMessage.receiveSMS(to))).build();
			
			MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();
			
			return twiml.toXml();
		
		});
		//return "It didn't work";
	}
}
