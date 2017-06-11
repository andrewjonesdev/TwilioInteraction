package com.twilio;

import static spark.Spark.post;

import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;


public class SmsInteract {

	public static final String ACCOUNT_SID = "AC3e674863086b91d4a48885977cd375cc";
	public static final String AUTH_TOKEN = "935959939532b59a79a49ae9046f60ea";

	public static void send(String to, String from, String body) {
		// TODO Auto-generated method stub
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		//Message message = Message.creator(new PhoneNumber("+17033045506"),new PhoneNumber("+17032935022"),"Andrew is texting you, reply").create();
		/*Message message = new Message.Builder().to(to).from(from).body(new Body(body)).build();
		MessagingResponse twiml = new MessagingResponse.Builder().message(message).build();
		 try {
	            System.out.print(twiml.toXml());
	        } catch (TwiMLException e) {
	            e.printStackTrace();
	        }
		*/
		//System.out.println(message.getSid());
	}
	
	public static void reply(String to, String body){
		
		post("/receive-sms", (req, res) -> {
			
			Message sms = new Message.Builder().to(to).body(new Body(body)).build();
		
			MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();

			return twiml.toXml();
		
		});
			
	}

}
