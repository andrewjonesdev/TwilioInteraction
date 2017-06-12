package com.twilio;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.twilio.ReturnSms;

public class TestGame {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Game game = new Game();
		//game.play();
		//System.out.println("play".substring(0,4));
	
		int sleep = 3;
		String play = "play";
		boolean temp = false;
		//ArrayList <Game> games =  new ArrayList();
		ArrayList <PrimeRun> threads =  new ArrayList();
	    do{
	    	do{
	    	temp = CompareSms.newRequest(play);
	    	
	    	}while(!temp);
	    	threads.add(new PrimeRun(143));
	        new Thread(threads.get(threads.size()-1)).start();
	    		//games.add(new Game(ListMessage.receiveSpecificText(play)));
	    		//games.get(games.size()-1).play();
	    		//System.out.println(games.size());
	        try {
				TimeUnit.SECONDS.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}while(true);	
		
		
		//ReturnSms.reply("+17033045506");
	}

}
