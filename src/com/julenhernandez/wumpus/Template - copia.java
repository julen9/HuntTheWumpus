package com.julenhernandez.wumpus;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Template extends JFrame {

	
	//Array of Box objects, it's the board
	private static Box[][] board = new Box[10][10];
	
	private int xPos = 1;
	private int yPos = 1;
	
	static JPanel contentPane;
	
	public Template() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 397, 310);
		contentPane = new JPanel();
		setContentPane(contentPane);
		//frame.setSize(317, 310);

		
		
		
		JButton btnInicializar = new JButton("Derecha");
        btnInicializar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	xPos=xPos+1;
            	System.out.println(xPos);
                repaint();
            }
        });
        btnInicializar.setBounds(380, 100, 140, 23);
        contentPane.add(btnInicializar);
	
		
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.RED);
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

		Random randomGenerator = new Random();
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
		addBatAndWarn();
		addBatAndWarn();
		
		Template t = new Template();
		t.setVisible(true);
		
	
		
	}
}
