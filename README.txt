Fernando A Rodriguez  May 13, 2015

Read this to ensure that you run the program correctly. 

This program is a game in which you interact with moving balls and shoot balls and they move to it other balls. it also stores data from games into files like highest score, score of winner, score of looser, who is winner and who is looser and the date the game was played. Unfortunately in this program the game has not been implemented. You can only see the panel of the game but no interaction will happen if attempted. The only interaction here is with the Java menu on the top and buttons on every other window.

To run this program from the terminal the first thing you have to do is extract the contents of the zip file.

In this case i’m going to asume you saved the file in desktop. I will also asume that you have already installed the JDK (java development kit). If you don’t have there please proceed to java.sun.com and download the JDK and make sure this program’s file is saved on your desktop.

After you have verified the pre conditions stated above the procedure described below should work:

	1)Open terminal.
	2)Write “ls” and hit enter to list the contents of the directory you are in. (note never to write the quotation marks ”” this is only to clarify what you have to write, only write what is between the quotation marks).
	3)Make sure that the desktop is included in the list. if not please go to the internet to find why it is not appearing.
	4)Write “cd Desktop” and hit enter.
	5)Write “ls” and hit enter.
	6)The file name P3_802137210 should appear on the list. Write “cd P3_802137210”.
	7)write “ls” and hit enter.
	8)The file name src should be listed. Write “cd src” and hit enter.
	9)write “ls” and hit enter.  
	10)The InItFrame.java should be listed. Write “javac InItFrame.java” to compile the program and hit enter.
	11)After compiling it there should not be any errors assuming you followed the instructions carefully, now write “java InItFrame” to run the program.
	12)A window will appear with 3 buttons. The instructions are pretty strait forward just choose which ever option you would like. 

***It is important to note that preliminary information has been added to files to ensure the program runs correctly. There are 2 usernames that have been added Which in this case are “Fernando” and “Luis” they also have passwords which are “1111” and “2222” respectively. This is for the user database p3 file. The other data in this file is the current highest score of each one of them and the date it was achieved. if the score is 0 then the date corresponds to the date when the user was created.
The historyp3 file contains one entry of one game that was played. this contains the winner, the looser, the score of each one respectively and the date which this game was played. In This implementation a game played is simulated by entering information in a window named Game emulator. entering the correct information will add an entry to the history file.
The current players file contains the currently selected players that will be used to run the simulation of the game and the only players that can be selected in the game emulator.
	

