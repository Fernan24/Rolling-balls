import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
	private static BufferedWriter writer;
	/**
	 * This method adds User credentials to file.
	 * @param username The User's username
	 * @param password The User's password
	 */
	public static void addUserToFile(String username,String password){
		File userData = new File("UserDataBaseP3.txt");
		try{

			FileWriter fileWriter = new FileWriter(userData, true);
			int initialHS=0;
			writer = new BufferedWriter(fileWriter);
			writer.write(username+" "+password+" "+ initialHS+" "+MyDate.getCurrentDate()+"\n");
			writer.flush();
			writer.close();

		} catch(IOException e) {
			System.out.println(e);
		}
	}
	/**
	 * This method gets all the users currently stored in the file and adds them to an array and returns the array
	 */
	public static String[] getListOfUsers(){
		File UserData = new File("UserDataBaseP3.txt");
		Scanner in;
		ArrayList<String> usernameList=new ArrayList<String>();
		try {
			in = new Scanner(UserData);
			while(in.hasNext()){
				String line= in.nextLine();
				String[] substr=line.split(" ");
				String username=substr[0];
				usernameList.add(username);
			}
			in.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] usernames= new String[usernameList.size()];
		for(int j=0;j<usernames.length;j++){
			usernames[j]=(String) usernameList.get(j);
		}

		return usernames;

	}
/**
 * this method checks if the inputed username and password correspond to those stored on the file
 * @param username entered username
 * @param password entered password
 * @return true if the credentials correspond, false if they dont
 */
	public static  boolean checkCredentials(String username, String password){
		boolean aprooved = false;
		Scanner in;
		File UserData = new File("UserDataBaseP3.txt");
		try{
			in=new Scanner(UserData);
			while(in.hasNextLine()) {
				String line= in.nextLine();
				String[] substr=line.split(" ");
				String Username=substr[0];
				Username=Username.trim();
				String Password=substr[1];
				Password=Password.trim();
				if(Username.equals(username)&& Password.equals(password)){
					aprooved=true;
				}
			} 
		}catch (FileNotFoundException e) {
			System.out.println("file does not exsist");
			e.printStackTrace();
		} 
		if (aprooved==false){
			return false;
		}else{
			return true;
		}


	}
	/**
	 * this method checks if the entered username has already been created
	 * @param user username entered
	 * @return true if the username exists, false if it doesn't 
	 */
	public static boolean checkForExistingUser(String user){
		Scanner in;
		File UserData = new File("UserDataBaseP3.txt");
		try{
			in=new Scanner(UserData);
			while(in.hasNextLine()) {
				String line= in.nextLine();
				String[] substr=line.split(" ");
				String Username=substr[0];
				Username=Username.trim();
				if(user.equals(Username)){
					return true;
				}
			}
			in.close();
		}catch(Exception e){
			System.out.println("file does not exsist 1");
		}
		return false;
	}
	/**
	 * sets the players to be the ones playing the game and stores in file
	 * @param player1 username that corresponds to player 1
	 * @param player2 username that corresponds to player 2
	 */
	public static void setCurrentPlayers(String player1, String player2){
		File currentPlayers= new File("CurrentPlayersP3.txt");
		try{
			FileWriter fileWriter = new FileWriter(currentPlayers, false); 
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(player1);
			bufferedWriter.newLine();
			bufferedWriter.write(player2);
			bufferedWriter.flush();
			bufferedWriter.close();
		}catch(FileNotFoundException e1){
			///
			System.out.println("file not found");
		}catch(Exception e){
			System.out.println(e);
		}

	}
	/**
	 * this method records that a game was played in a file
	 * @param winner username of the winner
	 * @param winScore score of the winner
	 * @param loser username of the looser
	 * @param lossScore score of the looser
	 * @param date the date the game was finished
	 */
	public static void gamePlayed(String winner, String winScore, String loser, String lossScore, String date){
		
		File history= new File("P3History.txt");
		try{
			FileWriter fileWriter = new FileWriter(history, true); 
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String game=winner+" "+winScore+" "+loser+" "+lossScore+" "+date+"\n";
			bufferedWriter.write(game);
			bufferedWriter.flush();
			bufferedWriter.close();
		}catch(FileNotFoundException e1){
			///
			System.out.println("file not found");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	/**
	 * this method gets the currently set players to play a game form the file
	 * @return an array that stores the usernames of those players, where the 
	 * first name is player 1 and the second is player2
	 */
	public static String[] getCurrentPlayer(){
		File playerfile = new File("CurrentPlayersP3.txt");
		Scanner in;
		String[] players= new String[2];
		try{
			in= new Scanner(playerfile);
			players[0]= in.nextLine();
			players[1]= in.nextLine();
			in.close();
		}catch(Exception e){
			System.out.println(e);	
		}
		return players;
	}
/**
 * this method gets the data from a file and returns it int he for of an arraylist where every line is
 * stored in a different position in the array list
 * @param file file to be read
 * @return the file in the form of an arraylist
 */
	public static ArrayList<String> fileToArrayList(File file){
		ArrayList<String> list = new ArrayList<String>();
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine()){
				String dumy=in.nextLine();
				list.add(dumy);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * this method updates the information stored in a file
	 * @param list list to update information
	 * @param user username data to change
	 * @param score score of the game played by correspoding username
	 * @param date the string for of the date of the game played
	 */
	public static void fileUpdate(ArrayList<String> list, String user, String score, String date){
		String newline="";
		ArrayList<String> updatedlist= new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			String[] line= list.get(i).split(" ");
			if(user.equals(line[0])&& Integer.parseInt(score)>Integer.parseInt(line[2])){
				newline=line[0]+" "+line[1]+" "+ score+" "+ date+"\n";
			}else{
				newline=list.get(i);
			}
			updatedlist.add(newline);
			
		}
		File currentPlayers= new File("UserDataBaseP3.txt");
		try{
			FileWriter fileWriter = new FileWriter(currentPlayers, false); 
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (String string : updatedlist) {
				bufferedWriter.write(string);
			}
		}catch(FileNotFoundException e1){
			System.out.println("file not found");
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}
	/**
	 * this method formats the help file to fit in the screen
	 * @param file file object
	 * @return string of the formated file
	 */
public static String readfile(File file){
	int index=0;
	String newstr="";
	ArrayList<String> list=new ArrayList<String>();
	Scanner in;
	try {
		in=new Scanner(file);
		while(in.hasNext()){
			index++;
			list.add(in.next());
			if(index==10){
				index=0;
				list.add("\n");
				
			}
			
		}
		for (String string : list) {
			newstr+=string+" ";
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return newstr;
	}
}



