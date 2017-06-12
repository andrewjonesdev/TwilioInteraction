package com.twilio;import com.twilio.SendSms;import com.twilio.base.ResourceSet;import com.twilio.rest.api.v2010.account.Message;/** * Class Game - the main class of the "Zork" game. * * Author:  Michael Kolling * Version: 1.1 * Date:    March 2000 *  *  This class is the main class of the "Zork" application. Zork is a very *  simple, text based adventure game.  Users can walk around some scenery. *  That's all. It should really be extended to make it more interesting! *  *  To play this game, create an instance of this class and call the "play" *  routine. *  *  This main class creates and initialises all the others: it creates all *  rooms, creates the parser and starts the game.  It also evaluates the *  commands that the parser returns. */class Game {    private Parser parser;    private Room currentRoom;    private static String to ="+17033045506";    private static String from ="+17032935022";	public static final String ACCOUNT_SID = "AC3e674863086b91d4a48885977cd375cc";	public static final String AUTH_TOKEN = "935959939532b59a79a49ae9046f60ea";	int previous = 0;    int current = 0;                /**     * Create the game and initialise its internal map.     */    public Game()     {        createRooms();        parser = new Parser();    }    public Game(String toUser)     {        createRooms();        parser = new Parser();        to = toUser;    }    /**     * Create all the rooms and link their exits together.     */    public static String getTo(){    	return to;    }    public static String getFrom(){    	return from;    }    private void createRooms()    {        Room outside, lab, tavern, gblock, office;              // create the rooms        outside = new Room("outside G block on Peninsula campus");        lab = new Room("a lecture theatre in A block");        tavern = new Room("the Seahorse Tavern (the campus pub)");        gblock = new Room("the G building");        office = new Room("the computing admin office");                // initialise room exits        outside.setExits(null, lab, gblock, tavern);        lab.setExits(null, null, null, outside);        tavern.setExits(null, outside, null, null);        gblock.setExits(outside, office, null, null);        office.setExits(null, null, null, gblock);        currentRoom = outside;  // start game outside    }    /**     *  Main play routine.  Loops until end of play.     */    public void play()     {                    printWelcome();        // Enter the main command loop.  Here we repeatedly read commands and        // execute them until the game is over.                        boolean finished = false;        while (! finished)        {            Command command = parser.getCommand();            finished = processCommand(command);        }        SendSms.send(to, from,"Thank you for playing.  Good bye.");    }    /**     * Print out the opening message for the player.     */    private void printWelcome()    {    	String output = "";        output+="\n";        output+=("Welcome to Zork!");        output+="\n";        output+=("Zork is a new, incredibly boring adventure game.");        output+="\n";        output+=("Type 'help' if you need help.");        output+="\n";        output+="\n";        output+=(currentRoom.longDescription());        output+="\n";        SendSms.send(to, from, output);    }    /**     * Given a command, process (that is: execute) the command.     * If this command ends the game, true is returned, otherwise false is     * returned.     */    private int messageCount(){    	int i = 0;        ResourceSet<Message> messages = Message.reader().read();        for (Message message : messages) {        	i++;        }        return i;    }    private boolean processCommand(Command command)     {    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);    //Long number = new Long(17033045506L);    //ResourceSet<Message> messages = Message.reader().read();    	        if(command.isUnknown())        {        	SendSms.send(to, from,"I don't know what you mean...");            return false;        }        String commandWord = command.getCommandWord();        if (commandWord.equals("help"))            printHelp();        else if (commandWord.equals("go"))            goRoom(command);        else if (commandWord.equals("quit"))        {            if(command.hasSecondWord())            	SendSms.send(to, from,"Quit what?");            else                return true;  // signal that we want to quit        }            return false;}    // implementations of user commands:    /**     * Print out some help information.     * Here we print some stupid, cryptic message and a list of the      * command words.     */    private void printHelp()     {    	String output = "";    	    	output += ("You are lost. You are alone. You wander");    	output += "\n";    	output += ("around at Monash Uni, Peninsula Campus.");    	output += "\n";    	output += "\n";        output += ("Your command words are:");        output += "\n";        SendSms.send(to, from,output);        parser.showCommands();    }    /**      * Try to go to one direction. If there is an exit, enter the new     * room, otherwise print an error message.     */    private void goRoom(Command command)     {        if(!command.hasSecondWord())        {            // if there is no second word, we don't know where to go...        	SendSms.send(to, from,"Go where?");            return;        }        String direction = command.getSecondWord();        // Try to leave current room.        Room nextRoom = currentRoom.nextRoom(direction);        if (nextRoom == null)        	SendSms.send(to, from,"There is no door!");        else         {            currentRoom = nextRoom;            SendSms.send(to, from, currentRoom.longDescription());        }    }}