package com.twilio;
class PrimeRun implements Runnable {
    long minPrime;
    PrimeRun(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        // compute primes larger than minPrime
    	String play = "play";
    	Game game = new Game(ListMessage.receiveSpecificText(play));
    	game.play();
    }
}
