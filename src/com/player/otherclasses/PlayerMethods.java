package com.player.otherclasses;
import jaco.mp3.player.MP3Player;
import java.io.File;
import javax.swing.JFileChooser;
import com.player.interfaces.*;
/**
 * PlayerMethods, contains the methods used for the program
 * @author Daniel Eriksson
 */


public class PlayerMethods implements PlayerInterface{
	//creates a File that we can store our file in.
	File file = new File("");
	//creates a mp3 player with file
	MP3Player player = new MP3Player(file);
	//creates a JFileChooser
	final JFileChooser fileChooser = new JFileChooser();
	//String to Store the filename of the file for usage in nowplaying/windowtitle
	private String fileName = "";		
	
	/**
	 * Stops the current file playing, lets you select a file with JFileChooser, sets the selected file name with setFileName and makes a new MP3Player setMp3Player, then plays the new file with the new mp3 player.
	 */
	public void open(){
		JFileChooser chooser = new JFileChooser();

		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			player.stop();
			File selectedFile = chooser.getSelectedFile();
			this.setFileName(selectedFile.getName());
			this.setMp3Player(new MP3Player(chooser.getSelectedFile()));
			player.play();
		}
	}
	/**
	 * getter file
	 * @return file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * setter file
	 * @param file contains the selected file
	 */
	public void setFile(File file) {
		this.file = file;
	}
	/**
	 * getter fileName	
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * setter fileName 
	 * @param fileName contains the name of the selected file
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * getter Mp3Player
	 * @return player
	 */
	public MP3Player getMp3Player() {
		return player;
	}

	/**
	 * setter Mp3Player
	 * @param mp3Player mp3player is saved here for use 
	 */
	public void setMp3Player(MP3Player mp3Player) {
		this.player = mp3Player;
	}
	/**
	 * plays the file selected
	 */
	public void play(){
		player.play();
	}
	/**
	 * pauses the file selected
	 */
	public void pause(){
		player.pause();
	}
	/**
	 * stops the file selected, sets file as a nonselected file and sets the string name to ""
	 */
	public void	stop(){
		player.stop();
		setFile(new File(""));
		setMp3Player(new MP3Player(file));
		setFileName("");
	}
	
}