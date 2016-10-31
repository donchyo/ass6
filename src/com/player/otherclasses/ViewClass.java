package com.player.otherclasses;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * ViewClass, contains the methods for the GUI
 * @author Daniel Eriksson
 */

public class ViewClass extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;

	//creates all the buttons/labels used
	private JButton stopButton = new JButton();
	private JButton playButton = new JButton();
	private JButton pauseButton = new JButton();
	private JButton exitButton = new JButton();
	private JButton openButton = new JButton();
	private JButton xkcdButton = new JButton();
	private JButton hideXkcdButton = new JButton(); 
	private JLabel nowPlaying = new JLabel();
	private JLabel relevantXkcd = new JLabel(); 
	
	//string that holds the text for the title of the window
	private String title = "Mp3 Player";
	
	//creates a new PlayerMethods object
	PlayerMethods PM = new PlayerMethods();

	/**
	 * Sets close default to EXIT_ON_CLOSE, calls createUI() to create the UI and adds action listeners with addActionListerners()
	 */
	public ViewClass(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createUI();
		addActionListeners();
		
	}
	/**
	 * adds all the buttons and corresponding icons to them
	 */
	private void createButtons(){

		stopButton.setText("Stop");
		stopButton.setIcon(new ImageIcon("icons\\stopp.jpg"));
		stopButton.setBounds(230, 60, 100, 50);
		getContentPane().add(stopButton);

		playButton.setText("Play");
		playButton.setIcon(new ImageIcon("icons\\playp.jpg"));
		playButton.setBounds(10, 60, 100, 50);
		getContentPane().add(playButton);

		pauseButton.setText("Pause");
		pauseButton.setIcon(new ImageIcon("icons\\pausep.jpg"));
		pauseButton.setBounds(120, 60, 100, 50);
		getContentPane().add(pauseButton);

		exitButton.setText("Exit");
		exitButton.setIcon(new ImageIcon("icons\\exitp.jpg"));
		exitButton.setBounds(10, 120, 210, 50);
		getContentPane().add(exitButton);

		openButton.setText("Open");
		openButton.setIcon(new ImageIcon("icons\\openp.jpg"));
		openButton.setBounds(340, 60, 100, 50);
		getContentPane().add(openButton);
		
		xkcdButton.setText("Relevant xkcd");
		xkcdButton.setBounds(230, 120, 210, 50);
		getContentPane().add(xkcdButton);
		
		hideXkcdButton.setText("Hide xkcd");
		hideXkcdButton.setBounds(230, 120, 210, 50);
		

	}
	/**
	 * adds the now playing label aswell as the relevant xkcd label
	 */
	public void createLabels(){
		nowPlaying.setBounds(10, 10, 430, 40);
		nowPlaying.setText("Now Playing: ");
		getContentPane().add(nowPlaying);
		
		relevantXkcd.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/relevantxkcd.png")));
		relevantXkcd.setBounds(20, 200, 340, 480);
		
	}
	/**
	 * adds ActionListeners to the buttons that need them
	 */
	private void addActionListeners(){
		stopButton.addActionListener(this);
		playButton.addActionListener(this);
		pauseButton.addActionListener(this);
		exitButton.addActionListener(this);
		openButton.addActionListener(this);
		xkcdButton.addActionListener(this);
		hideXkcdButton.addActionListener(this);
	}
	
	/**
	 * creates the frame, sets it visible, sets layout to null, calls, createButtons and createLabels
	 */
	public void createUI() {
		// Setting some properties of the application

		setTitle(title);
		setSize(465, 230); //465x230
		//setVisible(true);
		getContentPane().setLayout(null);

		createButtons();
		createLabels();

	}
		
	/**
	 * depending on what button is pressed, things will happen
	 */
	public void actionPerformed(ActionEvent e) {
		//if stop button pressed, stops music, sets windowtitle to the default title and sets the nowplaying label to its default value
		if (e.getSource() == stopButton){
			PM.stop();
			setTitle(title);
			nowPlaying.setText("Now Playing: ");
		}
		//if play button pressed, plays music, sets windowtitle to the file name and sets the nowplaying label to the filename
		if (e.getSource() == playButton){
			PM.play();
			setTitle("Mp3 Player: " + PM.getFileName());
		}
		//if pause button pressed, pauses music, 
		if (e.getSource() == pauseButton){
			PM.pause();
		}
		// if the exit button is pressed the program closes with System.exit(0);
		if (e.getSource() == exitButton){
			System.exit(0);
		}
		// if the openbutton is pressed the open method is called and the now playinglabel is set to nowplaying filename, the title of the window is set to mp3player + filename
		if (e.getSource() == openButton){
			PM.open();
			nowPlaying.setText("Now Playing: " + PM.getFileName());
			setTitle("Mp3 Player: " + PM.getFileName());

		}
		//if the xkcdbutton is pressed the label with the image as icon is added, the size of the window is increasedd, the button pressed
		// is rmeoved and replaced with hideXkcdButton, then repaint() is called because that apparently refreshes things so it works properly
		if (e.getSource() == xkcdButton){
			getContentPane().add(relevantXkcd);
			setSize(465, 800);
			getContentPane().remove(xkcdButton);
			getContentPane().add(hideXkcdButton);
			repaint();
			
		}
		//if the hide button is pressed the button is removed, the size is set back to the original size, the image is removed, the xkcdButton is readded and repaint() is called to update things.
		if (e.getSource() == hideXkcdButton){
			getContentPane().remove(relevantXkcd);
			setSize(465, 230); //465x230
			getContentPane().remove(hideXkcdButton);
			getContentPane().add(xkcdButton);
			repaint();
			
		}
	}
}