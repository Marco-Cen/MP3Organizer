/*--------------------------------------------------------------------------------------*/
/*  MP3Summative.java  -  Description                                                       */
/*  Allow a user(s) to maintain collection(s) of something of your choice
[USE: Methods, Arrays, File handling, Searching and Sorting]
� Open and View the collection
� Add to the collection
� Search by each of 3 categories
� Sort by each of 3 categories
� Create a backup of the collection
� Delete an entry from the collection
� Allow multiple users to create other databases as well
The database should include at least three characteristics of each entry in the collection
 e.g. if program store names of MP3s in collection:(Try store title, artist's, category of song (hard rock, soft rock, R & B, Pop, Rap,etc.)
Add other useful features to enhance and improve the over-all program and its interface.

//R&B. Rap. Rock. Pop.
//(Genre.Title.Artist.Year)
								   */
/*--------------------------------------------------------------------------------------*/
/*  Author: Marco Cen                                                                             */
/*  Date: May 8th 2018                                                                               */
/*--------------------------------------------------------------------------------------*/
/*  Input:                                                                              */
/*  Output:                                                                             */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
import java.text.*;

public class MP3SummativeMarco
{
    static final int MAX = 100;

    //Clears display output screen
    static void cls () throws IOException
    {
	for (int i = 0 ; i < 50 ; i++)
	    System.out.println (" ");
    }


    //Create new user
    static void userAdd (String[] name) throws IOException
    {
	//Needed in order for user input to be considered in vMethod (Display function as well as 'stdin.readLine();'
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	System.out.println ();
	System.out.println ("Please enter the name of the new user: ");
	name [0] = stdin.readLine ();

	//Add onto original UserList txt doc
	BufferedWriter newUser = new BufferedWriter (new FileWriter ("userList.txt", true));
	newUser.newLine ();
	newUser.write (name [0]);

	//Create new separate txt doc with new name
	BufferedWriter userFile = new BufferedWriter (new FileWriter (name [0] + ".txt"));
	newUser.close ();
	userFile.close ();
    }


    //View overall collection of what user has choosen
    static void viewOverall (String[] name, String[] genre, String[] title, String[] artist, String[] year) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	//Reads collection of user chosen, sets counter on each line and reads it in program
	BufferedReader collection = new BufferedReader (new FileReader (name [0] + ".txt"));
	String line = null;
	int counter = 0;
	int i = 0;

	while ((line = collection.readLine ()) != null)
	{
	    //disaplys songs as well as sets counter on each line in txt doc
	    genre [counter] = line;
	    title [counter] = collection.readLine ();
	    artist [counter] = collection.readLine ();
	    year [counter] = collection.readLine ();
	    counter++;
	}

	//Find lenght of words in collection for displays (Genre.Title.Artist.Year)
	System.out.println ("________________________________________________________________________________");
	System.out.println ("||Genre:   |\t        Title:\t             |         Artist:         |Year: ||");
	System.out.println ("________________________________________________________________________________");
	for (i = 0 ; i < counter ; i++)
	{
	    int length = genre [i].length ();
	    String space = " ";  //Spacing on screen variable
	    for (int x = length ; x < 8 ; x++)
	    {
		space = space + " ";
	    }

	    int length2 = title [i].length ();
	    String space2 = " ";
	    for (int x = length2 ; x < 32 ; x++) //Spacing on display output screen
	    {
		space2 = space2 + " ";
	    }

	    int length3 = artist [i].length ();
	    String space3 = " ";
	    for (int x = length3 ; x < 24 ; x++)
	    {
		space3 = space3 + " ";
	    }

	    int length4 = year [i].length ();
	    String space4 = " ";
	    for (int x = length4 ; x < 5 ; x++)
	    {
		space4 = space4 + " ";
	    }

	    //Prevent need to scroll
	    if (i == 20 || i == 40 || i == 60) //limit of 20 songs per page
	    {
		//When user inputs, screen scrolls to next list of remaining songs
		System.out.println ();
		System.out.print ("\t\t\t--ENTER to Turn Next Page--");
		String clear = stdin.readLine ();
		System.out.println ("________________________________________________________________________________");
		System.out.println ("||Genre:   |\t        Title:\t             |         Artist:         |Year: ||");
		System.out.println ("________________________________________________________________________________");
	    }

	    //display content in collection neatly within borders
	    System.out.println ("||" + genre [i] + space + "|" + title [i] + space2 + "|" + artist [i] + space3 + "|" + year [i] + space4 + "||");
	}
	System.out.println ();
	System.out.println ("\t\tThere are " + counter + " songs in this collection.");
	System.out.println ("________________________________________________________________________________");
	System.out.println ();

	//Waits on user input before continuing program
	System.out.print ("\t\t\t--ENTER to Return to Menu--");
	String clear = stdin.readLine ();
	cls ();  //Calls vMethod to clear screen
	collection.close ();
    }


    //Add song of the user's choice to the collection
    static void addSong (String[] name) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	//Adds on to user chosen collection
	BufferedWriter write = new BufferedWriter (new FileWriter (name [0] + ".txt", true));
	System.out.println ();
	System.out.println ("For the song you want to add in this collection, what is the: ");
	System.out.print ("Genre: ");
	String genre = stdin.readLine ();
	write.write (genre);
	write.newLine ();

	System.out.print ("Title: ");
	String title = stdin.readLine ();
	write.write (title);
	write.newLine ();

	System.out.print ("Artist: ");
	String artist = stdin.readLine ();
	write.write (artist);
	write.newLine ();

	System.out.print ("Year: ");
	String year = stdin.readLine ();
	write.write (year);
	write.newLine ();

	write.close ();
    }


    //search for a song in the collection
    static void search (String[] name, String searchFor, String[] genre, String[] title, String[] artist, String[] year) throws IOException
    {
	//Needed in order for user input to be considered in vMethod
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	//Reads collection of user chosen, sets counter on each line and reads it in program
	BufferedReader collection = new BufferedReader (new FileReader (name [0] + ".txt"));
	String line = null;
	int counter = 0;
	while ((line = collection.readLine ()) != null)
	{
	    //reads & declares each line in collection
	    genre [counter] = line;
	    title [counter] = collection.readLine ();
	    artist [counter] = collection.readLine ();
	    year [counter] = collection.readLine ();
	    counter++;
	}
	System.out.println ();
	System.out.println ();
	System.out.println ("\t\t<<Search is being Processed...>>");
	System.out.println ();
	System.out.println ();

	//Waits for user input before clearing display screen and continuing with program
	System.out.print ("\t\t[Press ENTER to Complete Search]");
	String results = stdin.readLine ();
	cls ();

	System.out.println ("\t\t\t\tResults:");
	System.out.println ("\t\t------------------------------------------------");
	for (int i = 0 ; i < counter - 1 ; i++)
	{
	    //searchFor is what user entered, compare it with what is in collection and display if found
	    if (searchFor.equals (genre [i]) || searchFor.equals (title [i]) || searchFor.equals (artist [i]) || searchFor.equals (year [i]))
	    {
		System.out.println ("\t\t\t~ " + genre [i]);
		System.out.println ("\t\t\t~ " + title [i]);
		System.out.println ("\t\t\t~ " + artist [i]);
		System.out.println ("\t\t\t~ " + year [i]);
		System.out.println ("\t\t------------------------------------------------");
	    }
	}
	System.out.print ("\t\t\t--ENTER to Return to Menu--");
	String waiting = stdin.readLine ();
	System.out.println ();
	System.out.println ();
	collection.close ();
	cls ();
    }


    //Writes a backup txt doc of selected collection
    static void backUp (String[] name, String[] genre, String[] title, String[] artist, String[] year) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	//Reads collection of user chosen, sets counter on each line and reads it in program
	BufferedReader collection = new BufferedReader (new FileReader (name [0] + ".txt"));
	String line = null;
	int counter = 0;
	while ((line = collection.readLine ()) != null)
	{
	    genre [counter] = line;
	    title [counter] = collection.readLine ();
	    artist [counter] = collection.readLine ();
	    year [counter] = collection.readLine ();
	    counter++;
	}
	//Creates/writes new txt doc with collection chosen as backup
	BufferedWriter backup = new BufferedWriter (new FileWriter (name [0] + "_Backup.txt"));
	for (int i = 0 ; i < counter ; i++)
	{
	    //Replicate file
	    backup.write (genre [i]);
	    backup.newLine ();
	    backup.write (title [i]);
	    backup.newLine ();
	    backup.write (artist [i]);
	    backup.newLine ();
	    backup.write (year [i]);
	    backup.newLine ();
	}
	backup.close ();
	System.out.println ();
	System.out.println ("\t\\A backup file has been created for this user's collection/");
	System.out.println ();
	System.out.print ("\t\t\t--ENTER to Return to Menu--");
	String waiting = stdin.readLine ();
	cls ();
    }


    //Delete entry from selected collection
    static void delete (String[] name, String deleteSong, String[] genre, String[] title, String[] artist, String[] year) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	BufferedReader collection = new BufferedReader (new FileReader (name [0] + ".txt"));
	String line = null;
	int counter = 0;
	while ((line = collection.readLine ()) != null)
	{
	    genre [counter] = line;
	    title [counter] = collection.readLine ();
	    artist [counter] = collection.readLine ();
	    year [counter] = collection.readLine ();
	    counter++;
	}
	collection.close ();

	//Compares user's answer with collection content
	//If found, brings to bottom of collection
	for (int i = 0 ; i < counter ; i++)
	{
	    int compare = (deleteSong).compareTo (title [i]);
	    if (compare == 0)
	    {
		for (i = i ; i < counter ; i++)
		{
		    genre [i] = genre [i + 1];
		    title [i] = artist [i + 1];
		    artist [i] = artist [i + 1];
		    year [i] = year [i + 1];
		}
	    }
	}

	//Rewrite entire selected user's collection but because counter-1, deletes last entry (the song brought to bottom)
	BufferedWriter deleted = new BufferedWriter (new FileWriter (name [0] + ".txt"));
	for (int i = 0 ; i < (counter - 1) ; i++)
	{
	    deleted.write (genre [i]);
	    deleted.newLine ();
	    deleted.write (title [i]);
	    deleted.newLine ();
	    deleted.write (artist [i]);
	    deleted.newLine ();
	    deleted.write (year [i]);
	    deleted.newLine ();
	}
	System.out.println ("\t\\The song you desire to delete has been terminated/");
	System.out.println ();
	System.out.print ("\t\t\t--ENTER to Return to Menu--");
	String wait = stdin.readLine ();
	cls ();
	deleted.close ();
    }


    //Sort Collection depending on user's response
    static void sortCollection (String[] name, int sortR, String[] genre, String[] title, String[] artist, String[] year) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	BufferedReader collection = new BufferedReader (new FileReader (name [0] + ".txt"));
	String line = null;
	int count = 0;
	while ((line = collection.readLine ()) != null)
	{
	    genre [count] = line;
	    title [count] = collection.readLine ();
	    artist [count] = collection.readLine ();
	    year [count] = collection.readLine ();
	    count++;
	}
	collection.close ();

	//Start sorting depending on user's answer
	System.out.println ("You have decided to sort by: " + sortR + "!");
	String tempG, tempT, tempA, tempY;
	for (int i = (count - 1) ; i >= 1 ; i--)
	{
	    for (int j = 0 ; j < i ; j++)
	    {
		//Compare user's answer to content in collection
		int compare;
		if (sortR == 1)
		{
		    compare = (genre [j]).compareTo (genre [j + 1]);
		}
		else if (sortR == 2)
		{
		    compare = (title [j]).compareTo (title [j + 1]);

		}
		else if (sortR == 3)
		{
		    compare = (artist [j]).compareTo (artist [j + 1]);
		}
		else if (sortR == 4)
		{
		    compare = (year [j]).compareTo (year [j + 1]);
		}
		else
		{
		    compare = 0;
		}

		if (compare > 0)
		{
		    //Swap genres
		    tempG = genre [j];
		    genre [j] = genre [j + 1];
		    genre [j + 1] = tempG;

		    //Swap titles
		    tempT = title [j];
		    title [j] = title [j + 1];
		    title [j + 1] = tempT;

		    //Swap artist
		    tempA = artist [j];
		    artist [j] = artist [j + 1];
		    artist [j + 1] = tempA;

		    //Swap Year
		    tempY = year [j];
		    year [j] = year [j + 1];
		    year [j + 1] = tempY;
		}
	    }
	}

	System.out.println ("________________________________________________________________________________");
	System.out.println ("||Genre:   |\t        Title:\t             |         Artist:         |Year: ||");
	System.out.println ("________________________________________________________________________________");
	for (int i = 0 ; i < count ; i++)
	{
	    int length = genre [i].length ();
	    String space = " ";
	    for (int x = length ; x < 8 ; x++)
	    {
		space = space + " ";
	    }

	    int length2 = title [i].length ();
	    String space2 = " ";
	    for (int x = length2 ; x < 32 ; x++)
	    {
		space2 = space2 + " ";
	    }

	    int length3 = artist [i].length ();
	    String space3 = " ";
	    for (int x = length3 ; x < 24 ; x++)
	    {
		space3 = space3 + " ";
	    }

	    int length4 = year [i].length ();
	    String space4 = " ";
	    for (int x = length4 ; x < 5 ; x++)
	    {
		space4 = space4 + " ";
	    }

	    if (i == 20 || i == 40 || i == 60)
	    {
		//When user inputs, screen scrolls to next list of remaining songs
		System.out.println ();
		System.out.print ("\t\t\t--ENTER to Turn Next Page--");
		String clear = stdin.readLine ();
		System.out.println ("________________________________________________________________________________");
		System.out.println ("||Genre:   |\t        Title:\t             |         Artist:         |Year: ||");
		System.out.println ("________________________________________________________________________________");
	    }
	    System.out.println ("||" + genre [i] + space + "|" + title [i] + space2 + "|" + artist [i] + space3 + "|" + year [i] + space4 + "||");
	}
	System.out.println ();
	System.out.println ("\t\tThere are " + count + " songs in this collection.");
	System.out.println ("________________________________________________________________________________");
	System.out.println ();
	System.out.print ("\t\t\t--ENTER to Return to Menu--");
	String clear = stdin.readLine ();
	cls ();
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //MAIN METHOD
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main (String str[]) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");
	//Arrays declared to be used throughout program
	String[] user = new String [MAX]; //Name already in collection
	String[] name = new String [1];  //Name to be added
	String[] genre = new String [MAX];
	String[] title = new String [MAX];
	String[] artist = new String [MAX];
	String[] year = new String [MAX];

	//do while loop loops for swap users option #7
	String login;
	do
	{

	    //INTRODUCTION
	    System.out.println ();
	    System.out.println ("\t ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println ("\t{\t\tWelcome to the MP3 Collection!\t\t\t}");
	    System.out.println ("\t{\t\t    [Created by: Marco Cen]\t\t\t}");
	    System.out.println ("\t ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	    //Displays UserList from txtDoc and has user choose (or create a new user)
	    int option;
	    int count;
	    do
	    {
		System.out.println ("\t\t\tUser List: ");
		BufferedReader readUsers = new BufferedReader (new FileReader ("userList.txt"));
		String line = null;
		count = 0;
		while ((line = readUsers.readLine ()) != null)   //Loop until line is empty
		{
		    user [count] = line;  //Place counter beside name so each user numbered and user friendly
		    count++;
		    System.out.println ("\t\t\t\t" + count + ". " + line);
		}
		System.out.println ("\t\t\t\t" + (count + 1) + ". [Create a new user]");  //Create other Databases (1 of 7 options for lvl4)
		System.out.println ();
		System.out.println ("Please select an option from above: ");
		option = Integer.parseInt (stdin.readLine ());

		//VALIDATION
		if (option <= 0 || option > (count + 1))
		{
		    System.out.println ("\t\t\\Invalid Response. Please enter a number from above/");
		    System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		    System.out.println ();
		}
	    }
	    while (option <= 0 || option > (count + 1));


	    //If user selects to Create New User
	    name [0] = user [option - 1];  //set varible name [0] to what user chose
	    if (option == (count + 1))
	    {
		userAdd (name);  //Call up name array to Vmethod
	    }

	    //output what was selected from option
	    System.out.println ("You have selected [" + name [0] + "]");
	    System.out.println ();


	    //Brings up Menu after selecting/creating user
	    int choose;
	    do
	    {
		System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println ("\t\t{***Remember -- User input is Case Sensitive***}");
		System.out.println ("\tMenu: ");
		System.out.println ("\t\tEnter 0: End Session (To Switch to another Database/User)");
		System.out.println ("\t\tEnter 1: View Overall Collection");
		System.out.println ("\t\tEnter 2: Add Song to the Collection");
		System.out.println ("\t\tEnter 3: Search by Each of the 4 Categories");
		System.out.println ("\t\tEnter 4: Sort by Each of the 4 Categories");
		System.out.println ("\t\tEnter 5: Create Backup of the Collection");
		System.out.println ("\t\tEnter 6: Delete an Entry from Collection");
		System.out.println ("\t\tEnter 7: Recommend Song from Collection");
		System.out.println ();
		System.out.println ("Please enter a number from above: ");
		choose = Integer.parseInt (stdin.readLine ());
		System.out.println ();

		switch (choose)
		{
			//CASE ZERO: close
		    case 0:
			System.out.println ("\t\t \\Thank you. You have ended your session./");
			System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println ();
			break;

			//CASE ONE: open and view music collection
		    case 1:
			viewOverall (name, genre, title, artist, year);
			break;
			//CASE TWO: add to the music collection
		    case 2:
			System.out.println ("\t  ['Yes' -- To Continue] \t [Enter ANY KEY -- Return to Menu]");
			String songAddR = stdin.readLine ();
			if (songAddR.equals ("Yes"))
			{
			    addSong (name);
			}
			cls ();
			break;

			//CASE THREE: search by four categories
		    case 3:
			System.out.println ("\t  ['Yes' -- To Continue] \t [Enter ANY KEY -- Return to Menu]");
			String searchR = stdin.readLine ();
			if (searchR.equals ("Yes"))
			{
			    String searchFor;
			    System.out.println ();
			    System.out.println ("Please enter the (Genre/Title/Artist/Year) you seek in the collection: ");
			    searchFor = stdin.readLine ();
			    search (name, searchFor, genre, title, artist, year);
			}
			cls ();
			break;

			//CASE FOUR: sort by four categories
		    case 4:
			int sortR;
			do
			{
			    System.out.println ("\tThe 4 Categories: ");
			    System.out.println ("\t\t[1] Genre");
			    System.out.println ("\t\t[2] Title");
			    System.out.println ("\t\t[3] Artist");
			    System.out.println ("\t\t[4] Year");
			    System.out.println ();
			    System.out.print ("Which category would you like to sort by?  Number: ");
			    sortR = Integer.parseInt (stdin.readLine ());

			    //Determine user answer and carry out code accordingly
			    if ((sortR != 1) && (sortR != 2) && (sortR != 3) && (sortR != 4))
			    {
				System.out.println ("\t\t\\Invalid Response. Please Try Again/");
				System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println ();
			    }
			}
			while (sortR != 1 && sortR != 2 && sortR != 3 && sortR != 4);

			sortCollection (name, sortR, genre, title, artist, year);
			break;

			//CASE FIVE: create a backup of the music collection
		    case 5:
			System.out.println ("Are you sure you want to create a backup of this collection?");
			System.out.println ("\t  ['Yes' -- To Continue] \t [Enter ANY KEY -- Return to Menu]");
			String backUpR = stdin.readLine ();
			if (backUpR.equals ("Yes"))
			{
			    backUp (name, genre, title, artist, year);
			}
			break;

			//CASE SIX: delete an entry from the music collection
		    case 6:
			System.out.println ("\t  ['Yes' -- To Continue] \t [Enter ANY KEY -- Return to Menu]");
			String deleteR = stdin.readLine ();
			if (deleteR.equals ("Yes"))
			{
			    System.out.println ();
			    System.out.println ("Which Song would you like to delete? [Enter Title of Song]: ");
			    String deleteSong = stdin.readLine ();
			    delete (name, deleteSong, genre, title, artist, year);
			}
			break;

			//CASE 7: Recommend song from playlist
		    case 7:
			//Read user chosen txtfile collection and sets counter on each line
			BufferedReader collection = new BufferedReader (new FileReader (name [0] + ".txt"));
			String line = null;
			int countList = 0;
			while ((line = collection.readLine ()) != null)
			{
			    genre [countList] = line;
			    title [countList] = collection.readLine ();
			    artist [countList] = collection.readLine ();
			    year [countList] = collection.readLine ();
			    countList++;
			}
			String mostPicked;
			do
			{
			    //Random Number generator
			    Random generator = new Random ();
			    int number = generator.nextInt (countList);

			    //display reccomended song
			    System.out.println ("----------------------------[Recommended Song]---------------------------------- ");
			    System.out.println ("\t\t    || GENRE:\t---\t" + genre [number] + " ||");
			    System.out.println ("\t\t    || TITLE:\t---\t" + title [number] + " ||");
			    System.out.println ("\t\t    || ARTIST:\t---\t" + artist [number] + " ||");
			    System.out.println ("\t\t    || YEAR:\t---\t" + year [number] + " ||");

			    //System.out.println ("||   " + genre [number] + "   |\t" + title [number] + "\t|\t " + artist [number] + " | " + year [number] + "||");
			    System.out.println ("________________________________________________________________________________");

			    //Wait for user input before display another  recoomended song
			    System.out.print ("   [Press ENTER -- View Next Recommended]  [Enter ANY KEY -- Return to Menu]");
			    mostPicked = stdin.readLine ();
			    cls ();
			}
			while (mostPicked.equals (""));
			break;

			//DEFAULT CASE: FOR VALIDATION
		    default:
			System.out.println ("\t\t\\Invalid Response.Please enter a number from above./");
			System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println ();
			break;
		}
	    }
	    while (choose != 0)
		;

	    //Option to user after ended session to switch to another user
	    System.out.println ("Would you like to login into another Database/User?");
	    System.out.println ("\t[Enter 'Yes' -- To Continue]   [Enter ANY KEY -- Close Program]");
	    login = stdin.readLine ();
	    System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	    //If yes restarts whole program
	    if (!login.equals ("Yes"))
	    {
		System.out.println ("\t\t\tThanks for using the Program!");
		//After end program, shutsdown entire program and closes window after a few seconds
		try
		{
		    Thread.sleep (300);
		}
		catch (InterruptedException ie)
		{
		}
		System.exit (0);
	    }
	}
	while (login.equals ("Yes"));
    }
}


