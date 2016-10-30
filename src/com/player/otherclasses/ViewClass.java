package com.player.otherclasses;
import javax.swing.JFrame;
import javax.swing.JLabel;

import jaco.mp3.player.MP3Player;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.event.ActionEvent;

public class ViewClass extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;

	private JButton stopButton = new JButton();
	private JButton playButton = new JButton();
	private JButton pauseButton = new JButton();
	private JButton exitButton = new JButton();
	private JButton openButton = new JButton();
	private JButton xkcdButton = new JButton();
	private JButton hideXkcdButton = new JButton(); 
	private JLabel nowPlaying = new JLabel();
	private JLabel relevantXkcd = new JLabel(); 
	
	
	PlayerMethods PM = new PlayerMethods();
	//final JFileChooser fileChooser = new JFileChooser();

	private String title = "Mp3Player";

	


	public ViewClass(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createUI();
		addActionListeners();
		
	}

	private void createButtons(){

		stopButton.setText("Stop");
		stopButton.setIcon(new ImageIcon("icons\\stopp.jpg"));
		stopButton.setBounds(10, 123, 100, 50);
		getContentPane().add(stopButton);

		playButton.setText("Play");
		playButton.setIcon(new ImageIcon("icons\\playp.jpg"));
		playButton.setBounds(10, 62, 100, 50);
		getContentPane().add(playButton);

		pauseButton.setText("Pause");
		pauseButton.setIcon(new ImageIcon("icons\\pausep.jpg"));
		pauseButton.setBounds(120, 62, 100, 50);
		getContentPane().add(pauseButton);

		exitButton.setText("Exit");
		exitButton.setIcon(new ImageIcon("icons\\exitp.jpg"));
		exitButton.setBounds(10, 184, 210, 50);
		getContentPane().add(exitButton);

		openButton.setText("Open");
		openButton.setIcon(new ImageIcon("icons\\openp.jpg"));
		openButton.setBounds(120, 123, 100, 50);
		getContentPane().add(openButton);
		
		xkcdButton.setText("Relevant xkcd");
		xkcdButton.setBounds(10, 240, 210, 50);
		getContentPane().add(xkcdButton);
		
		hideXkcdButton.setText("Hide xkcd");
		hideXkcdButton.setBounds(10, 240, 210, 50);
		

	}
	public void createLabels(){
		nowPlaying.setBounds(10, 10, 210, 40);
		nowPlaying.setText("Now Playing: ");
		getContentPane().add(nowPlaying);
		
		
		//test
		
		relevantXkcd.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/relevantxkcd.png")));
		relevantXkcd.setBounds(230, 100, 332, 478);
		
	}

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
	 * Method for creating UI
	 *
	 * @param none
	 * @return none
	 */

	public void createUI() {
		// Setting some properties of the application

		setTitle(title);
		setSize(245, 340);
		setVisible(true);
		getContentPane().setLayout(null);

		createButtons();
		createLabels();

	}
		
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == stopButton){
			System.out.println("Stop pressed");
			PM.stop();
			setTitle(title);
			nowPlaying.setText("Now Playing: ");
		}
		if (e.getSource() == playButton){
			System.out.println("Play pressed");
			PM.play();
			setTitle("Mp3 Player: " + PM.getFileName());
		}
		if (e.getSource() == pauseButton){
			System.out.println("Pause pressed");
			PM.pause();
		}
		if (e.getSource() == exitButton){
			System.out.println("Exit pressed");
			System.exit(0);
		}
		if (e.getSource() == openButton){
			System.out.println("Open pressed");
			PM.open();
			nowPlaying.setText("Now Playing: " + PM.getFileName());
			setTitle("Mp3 Player: " + PM.getFileName());

		}
		if (e.getSource() == xkcdButton){
			System.out.println("xkcd pressed");
			getContentPane().add(relevantXkcd);
			setSize(600, 645);
			getContentPane().remove(xkcdButton);
			getContentPane().add(hideXkcdButton);
			repaint();
			
		}
		if (e.getSource() == hideXkcdButton){
			System.out.println("hidexkcd pressed");
			getContentPane().remove(relevantXkcd);
			setSize(245, 340);
			getContentPane().remove(hideXkcdButton);
			getContentPane().add(xkcdButton);
			repaint();
			
		}
	}
}