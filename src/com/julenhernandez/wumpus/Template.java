package com.julenhernandez.wumpus;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ColorModel;
import java.io.InputStream;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Template extends JPanel{

	
	//Array of Box objects, it's the board
	private static Box[][] board = new Box[10][10];
	
	private int xPos = 0;
	private int yPos = 0;
	private int arrows = 3;
	
	static Random randomGenerator = new Random();
	
	static JFrame frame;
	static JTextArea msg;
	static JTextArea txtArrows;
	
	private KeyLis listener;
	
	public Template() {

		
		 listener = new KeyLis();
		 this.setFocusable(true);
	     this.requestFocus();
	     this.addKeyListener(listener);
		
		
		JButton bl = new JButton();
		bl.setIcon(new ImageIcon("res/left.png"));
        bl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if(arrows<=0){
            		JOptionPane.showMessageDialog(frame, "You don't have more arrows");
            	}else{
            	arrows--;
            	txtArrows.setText("Remaining arrows: " + arrows);
            	doIWin(xPos-1, yPos);
            	frame.validate();
            	frame.repaint();
            	}
            	
    	     requestFocus();
                
            }
        });
        bl.setBounds(320, 76, 52, 20);
        frame.add(bl);
        

		JButton br = new JButton();
		br.setIcon(new ImageIcon("res/right.png"));
        br.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if(arrows<=0){
            		JOptionPane.showMessageDialog(frame, "You don't have more arrows");
            	}else{
            	arrows--;
            	txtArrows.setText("Remaining arrows: " + arrows);
            	doIWin(xPos+1, yPos);
            	frame.validate();
            	frame.repaint();
            	}
                
            requestFocus();
            }
        });
        br.setBounds(406, 76, 52, 20);
        frame.add(br);
        

		JButton bu = new JButton();
		bu.setIcon(new ImageIcon("res/up.png"));
        bu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if(arrows<=0){
            		JOptionPane.showMessageDialog(frame, "You don't have more arrows");
            	}else{
            	arrows--;
            	txtArrows.setText("Remaining arrows: " + arrows);
            	doIWin(xPos, yPos-1);
            	frame.validate();
            	frame.repaint();
            	}
            	
            	
            	requestFocus(); 
            }
        });
        bu.setBounds(380, 20, 20, 52);
        frame.add(bu);


        
		JButton bd = new JButton();
		bd.setIcon(new ImageIcon("res/down.png"));
        bd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if(arrows<=0){
            		JOptionPane.showMessageDialog(frame, "You don't have more arrows");
            	}else{
            	arrows--;
            	txtArrows.setText("Remaining arrows: " + arrows);
            	doIWin(xPos, yPos+1);
            	frame.validate();
            	frame.repaint();
            	}
            	
            	requestFocus();
            }
        });
        bd.setBounds(380, 100, 20, 52);
        frame.add(bd);
        
        JLabel imgWarn = new JLabel();
        imgWarn.setBounds(300, 140, 192, 155);
        imgWarn.setIcon(new ImageIcon(("res/bubble.png")));
        frame.add(imgWarn);
        
        msg = new JTextArea(5, 10);
        msg.setBounds(336,220, 120, 55);
        msg.setBackground(new Color(238,238,238));
        frame.add(msg);
        
        txtArrows = new JTextArea(5, 10);
        txtArrows.setBounds(330,00,120,20);
        txtArrows.setBackground(new Color(238,238,238));
        txtArrows.setText("Remaining arrows: " + arrows);
        frame.add(txtArrows);
        
      

		
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLUE);
		//g2d.fillOval(0, 0, 30, 30);
		//g2d.drawOval(0, 50, 30, 30);		
		//g2d.drawRect(0, 0, 30, 30);
		//g2d.drawRect(30, 0, 30, 60);
		//g2d.drawRect(60, 0, 60, 90);
		//g2d.fillRect(0, 0, 30, 30);
		//g2d.drawRect(50, 50, 30, 30);
		
		//To make 10 squares in the first line
		for(int j=0; j<10;j++){
			for(int i = 0; i < 10; i++){
				g2d.drawRect(i*30, j*30, 30, 30);
			}
		}
		g2d.setColor(Color.RED);
		g2d.fillRect(xPos*30, yPos*30, 30, 30);
			

		//g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
	
	
	
	//Initializes a empty board
	public static void createBoard(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				board[i][j] = new Box();
			}
		}
	}
	
	public static void addWumpusAndWarn(){

		 
		int x = randomGenerator.nextInt(10);
		int y = randomGenerator.nextInt(10);

		
		board[x][y].setWumpus(true);
		
		
		
		try {
		    board[x-1][y-1].setSmell(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
		    System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x][y-1].setSmell(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x+1][y-1].setSmell(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		
		try{
		    board[x-1][y].setSmell(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x+1][y].setSmell(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		
		try{
		    board[x-1][y+1].setSmell(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x][y+1].setSmell(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x+1][y+1].setSmell(true);
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}

		

	}


	public static void addPitAndWarn(){
		Random randomGenerator = new Random();
		int x = randomGenerator.nextInt(10);
		int y = randomGenerator.nextInt(10);

		
		board[x][y].setPit(true);
		
		try {
		    board[x-1][y-1].setBreeze(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
		    System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x][y-1].setBreeze(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x+1][y-1].setBreeze(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		
		try{
		    board[x-1][y].setBreeze(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x+1][y].setBreeze(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		
		try{
		    board[x-1][y+1].setBreeze(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x][y+1].setBreeze(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x+1][y+1].setBreeze(true);
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}

		

	}
	
	
	public static void addBatAndWarn(){
		Random randomGenerator = new Random();
		int x = randomGenerator.nextInt(10);
		int y = randomGenerator.nextInt(10);

		
		board[x][y].setBat(true);
		
		try {
		    board[x-1][y-1].setNoise(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
		    System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x][y-1].setNoise(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x+1][y-1].setNoise(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		
		try{
		    board[x-1][y].setNoise(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x+1][y].setNoise(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		
		try{
		    board[x-1][y+1].setNoise(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x][y+1].setNoise(true);
		}catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}
		try{
		    board[x+1][y+1].setNoise(true);
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("outOfRange, don´t mind");
		}

		

	}
	
	
	
	public static void main(String[] args){
		
		createBoard();
		addWumpusAndWarn();
		addPitAndWarn();
		addPitAndWarn();
		addBatAndWarn();
		addBatAndWarn();
		
		
		
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                frame = new JFrame("Wumpus");
        		frame.getContentPane().add(new Template());
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setSize(500, 340);
        		frame.setVisible(true);
        		
            }
        });
		
		
		
	}
	
	public boolean canMove(int xPos, int yPos){
		if((xPos<10 && xPos>=0) && (yPos<10 && yPos>=0)){
			return true;
		}else{
			return false;
		}
	}
	
	public void doIFall(int xPos, int yPos){
		if(board[xPos][yPos].isPit()){
			JOptionPane.showMessageDialog(frame, "You have fallen in a pit and you are died");
		}
	}
	
	public void doIWumpus(int xPos, int yPos){
		if(board[xPos][yPos].isWumpus()){
			JOptionPane.showMessageDialog(frame, "You have been eaten by the wumpus");
		}
	}
	
	public void doIBat(int xPos, int yPos){
		if(board[xPos][yPos].isBat()){
			this.xPos = randomGenerator.nextInt(10);
			this.yPos = randomGenerator.nextInt(10);
			frame.validate();
			frame.repaint();
		}
	}
	
	public void doIWin(int xPos, int yPos){
		if(board[xPos][yPos].isWumpus()){
			JOptionPane.showMessageDialog(frame, "CONGRATULATIONS YOU WIN !");
			frame.validate();
			frame.repaint();
		}
	}
	
	
	
	
	public class KeyLis extends KeyAdapter {
		
		String str;
	    @Override
	    public void keyPressed(KeyEvent e) {
	       switch (e.getKeyCode()) {
	       case KeyEvent.VK_LEFT:
	    	   if(canMove(xPos-1,yPos)){
	    	   xPos--;
	    	   str = "";
	    	   msg.setText(str);
	    	   

	    	   
	    	   if(board[xPos][yPos].isBreeze()){
	    		   str+="I feel a Breeze\n";
	    	   }
	    	   
	    	   if(board[xPos][yPos].isSmell()){
	    		   str+="I Smell something\n";
	    	   }
	    	   
	    	   if(board[xPos][yPos].isNoise()){
	    		   str+="I hear Noise\n";
	    	   }
	    	   msg.setText(str);
	    	   
	    	   doIFall(xPos, yPos);
	    	   doIWumpus(xPos, yPos);
	    	   doIBat(xPos, yPos);
	    	   
	    	   
           	   frame.revalidate();
           	   frame.repaint();
	    	   }
	          break;
	       case KeyEvent.VK_RIGHT:
	    	   if(canMove(xPos+1,yPos)){
	    	   xPos++;
	    	   str = "";
	    	   msg.setText(str);

	    	   
	    	   if(board[xPos][yPos].isBreeze()){
	    		   str+="I feel a Breeze\n";
	    	   }
	    	   
	    	   if(board[xPos][yPos].isSmell()){
	    		   str+="I Smell something\n";
	    	   }
	    	   
	    	   if(board[xPos][yPos].isNoise()){
	    		   str+="I hear Noise\n";
	    	   }
	    	   msg.setText(str);
	    	   
	    	   doIFall(xPos, yPos);
	    	   doIWumpus(xPos, yPos);
	    	   doIBat(xPos, yPos);
	    	   
           	   frame.revalidate();
           	   frame.repaint();
	    	   }
	          break;
	       case KeyEvent.VK_UP:
	    	   if(canMove(xPos,yPos-1)){
	    	   yPos--;
	    	   str = "";
	    	   msg.setText(str);

	    	   
	    	   if(board[xPos][yPos].isBreeze()){
	    		   str+="I feel a Breeze\n";
	    	   }
	    	   
	    	   if(board[xPos][yPos].isSmell()){
	    		   str+="I Smell something\n";
	    	   }
	    	   
	    	   if(board[xPos][yPos].isNoise()){
	    		   str+="I hear Noise\n";
	    	   }
	    	   msg.setText(str);
	    	   
	    	   doIFall(xPos, yPos);
	    	   doIWumpus(xPos, yPos);
	    	   doIBat(xPos, yPos);
	    	   
           	   frame.revalidate();
           	   frame.repaint();
	    	   }
	          break;
	       case KeyEvent.VK_DOWN:
	    	   if(canMove(xPos,yPos+1)){
	    	   yPos++;
	    	   str = "";
	    	   msg.setText(str);

	    	   
	    	   if(board[xPos][yPos].isBreeze()){
	    		   str+="I feel a Breeze\n";
	    	   }
	    	   
	    	   if(board[xPos][yPos].isSmell()){
	    		   str+="I Smell something\n";
	    	   }
	    	   
	    	   if(board[xPos][yPos].isNoise()){
	    		   str+="I hear Noise\n";
	    	   }
	    	   msg.setText(str);
	    	   
	    	   doIFall(xPos, yPos);
	    	   doIWumpus(xPos, yPos);
	    	   doIBat(xPos, yPos);
	    	   
           	   frame.revalidate();
           	   frame.repaint();
	    	   }
	          break;
	       }
	    }
	 }
	


}
