package ttt.gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

import ttt.listeners.MListener;

public class Frame extends JFrame{
	static Frame FRAME;
	Image img;
	static Font f = new Font("Arial", 12,100);
	static boolean playing = true;
	static boolean turn = true;
	static String s = "";
	static int[][] board = new int[3][3];
	public Frame(){
		setTitle("Tic Tac Toe");
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(new MListener());
	}
	public static void main(String[] args){
		init();
	}
	private static void init(){
		FRAME = new Frame();
	}
	public void paint(Graphics g){
		img = createImage(600,600);
		paintComponent(img.getGraphics());
		g.drawImage(img, 0, 0, 600, 600, this);
	}
	public void paintComponent(Graphics g){
		g.drawLine(200, 0, 200, 600);
		g.drawLine(400, 0, 400, 600);
		g.drawLine(0, 200,600, 200);
		g.drawLine(0, 400, 600, 400);
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				if(board[x][y] == 1){
					g.drawLine(x*200,y*200,x*200+200,y*200+200);
					g.drawLine(x*200+200,y*200,x*200,y*200+200);
				}else if (board[x][y] == 2){
					g.drawOval(x*200, y*200, 200, 200);
				}
			}
		}
		if(!playing){
			g.setFont(f);
			g.drawString(s + " wins!", 150, 325);
		}
	}
	public static void onClick(int x, int y){
		if(playing){
			x/=200;
			y/=200;
			if(turn)
				if(board[x][y] == 0)
				board[x][y] = 1;
				else return;
			else
				if(board[x][y] == 0)
				board[x][y] = 2;
				else return;
			turn=!turn;
			FRAME.repaint();
			check();
		}
	}
	private static void check(){
			if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != 0){
				if(board[0][0] == 1)
				s = "X";
			else
				s = "O";		
			}else
			if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != 0){
				if(board[1][0] == 1)
					s = "X";
				else
					s = "O";		
			}else
			if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != 0){
				if(board[2][0] == 1)
					s = "X";
				else
					s = "O";		
			}
			else
				if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[1][0] != 0){
					if(board[1][0] == 1)
						s = "X";
					else
						s = "O";		
				}
			else
				if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != 0){
					if(board[0][1] == 1)
						s = "X";
					else
						s = "O";		
				}
			else
				if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != 0){
					if(board[0][2] == 1)
						s = "X";
					else
						s = "O";		
					}
				else
					if(board[0][0] == board[1][1] && board[2][2] == board[1][1] && board[1][1] != 0){
						if(board[1][1] == 1)
							s = "X";
						else
							s = "O";		
					}
					else
						if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != 0){
							if(board[0][2] == 1)
								s = "X";
							else
								s = "O";		
						}
		if(!s.isEmpty()){
			System.out.println(s + " wins!");
			playing = false;
			FRAME.repaint();
		}
	}
}
