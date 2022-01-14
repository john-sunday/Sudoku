package main;

import controller.Play;

public class Init {

	public static void main(String[] args) {				
		Play myPlay = new Play();		
		myPlay.chooseSudoku();
		myPlay.showSudoku();
		myPlay.checkRowColSquare();		
	}
}
