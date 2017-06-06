package com.twilio;


import static spark.Spark.post;

import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
//import com.twilio.twiml.*;
import com.twilio.twiml.MessagingResponse;

public class ReceiveSms {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		post("/receive-sms", (req, res) -> {
			
			Message sms = new Message.Builder().body(new Body("I need to stop fucking around and get this masters degree!")).build();
		
			MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();

			return twiml.toXml();
		
		});
	}

}
