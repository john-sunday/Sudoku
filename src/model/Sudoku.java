package model;

import controller.ArrayElement;

public class Sudoku {
	
	private static ArrayElement[][] sudoku01;
	private static ArrayElement [][] sudoku02;
	
	// constructor.
	public Sudoku() { }
	
	public static ArrayElement[][] getSudoku01() {
		return createSudoku01();
	}
	public static ArrayElement[][] getSudoku02() {
		return createSudoku02();
	}
	
	private static ArrayElement[][] createSudoku01() {
		Sudoku.sudoku01 = new ArrayElement[9][9];
		// sudoku 01
		// row 1
		sudoku01[0][0] = new ArrayElement(3, true); sudoku01[0][1] = new ArrayElement(0, false, 7); sudoku01[0][2] = new ArrayElement(0, false, 1); 
		sudoku01[0][3] = new ArrayElement(2, true); sudoku01[0][4] = new ArrayElement(0, false, 8); sudoku01[0][5] = new ArrayElement(9, true);
		sudoku01[0][6] = new ArrayElement(0, false, 5); sudoku01[0][7] = new ArrayElement(4, true); sudoku01[0][8] = new ArrayElement(0, false, 6); 		
		// row 2
		sudoku01[1][0] = new ArrayElement(0, false, 4); sudoku01[1][1] = new ArrayElement(8, true); sudoku01[1][2] = new ArrayElement(6, true);
		sudoku01[1][3] = new ArrayElement(1, true); sudoku01[1][4] = new ArrayElement(0, false, 3); sudoku01[1][5] = new ArrayElement(0, false, 5); 
		sudoku01[1][6] = new ArrayElement(0, false, 9); sudoku01[1][7] = new ArrayElement(7, true); sudoku01[1][8] = new ArrayElement(0, false, 2);		
		// row3
		sudoku01[2][0] = new ArrayElement(0, false, 2); sudoku01[2][1] = new ArrayElement(9, true); sudoku01[2][2] = new ArrayElement(5, true); 
		sudoku01[2][3] = new ArrayElement(0, false, 4); sudoku01[2][4] = new ArrayElement(7, true); sudoku01[2][5] = new ArrayElement(0, false, 6);
		sudoku01[2][6] = new ArrayElement(0, false, 8); sudoku01[2][7] = new ArrayElement(3, true); sudoku01[2][8] = new ArrayElement(1, true); 		
		// row 4
		sudoku01[3][0] = new ArrayElement(7, true); sudoku01[3][1] = new ArrayElement(3, true); sudoku01[3][2] = new ArrayElement(0, false, 2); 
		sudoku01[3][3] = new ArrayElement(0, false, 6); sudoku01[3][4] = new ArrayElement(9, true); sudoku01[3][5] = new ArrayElement(0, false, 8);
		sudoku01[3][6] = new ArrayElement(1, true); sudoku01[3][7] = new ArrayElement(5, true); sudoku01[3][8] = new ArrayElement(0, false, 4); 		
		// row 5
		sudoku01[4][0] = new ArrayElement(0, false, 8); sudoku01[4][1] = new ArrayElement(0, false, 6); sudoku01[4][2] = new ArrayElement(0, false, 9);
		sudoku01[4][3] = new ArrayElement(0, false, 5); sudoku01[4][4] = new ArrayElement(1, true); sudoku01[4][5] = new ArrayElement(4, true); 
		sudoku01[4][6] = new ArrayElement(3, true); sudoku01[4][7] = new ArrayElement(2, true); sudoku01[4][8] = new ArrayElement(0, false, 7);		
		// row 6
		sudoku01[5][0] = new ArrayElement(0, false, 5); sudoku01[5][1] = new ArrayElement(1, true); sudoku01[5][2] = new ArrayElement(0, false, 4); 
		sudoku01[5][3] = new ArrayElement(7, true); sudoku01[5][4] = new ArrayElement(2, true); sudoku01[5][5] = new ArrayElement(3, true);
		sudoku01[5][6] = new ArrayElement(0, false, 6); sudoku01[5][7] = new ArrayElement(0, false, 9); sudoku01[5][8] = new ArrayElement(8, true); 		
		// row 7
		sudoku01[6][0] = new ArrayElement(9, true); sudoku01[6][1] = new ArrayElement(0, false, 4); sudoku01[6][2] = new ArrayElement(3, true); 
		sudoku01[6][3] = new ArrayElement(8, true); sudoku01[6][4] = new ArrayElement(0, false, 6); sudoku01[6][5] = new ArrayElement(7, true);
		sudoku01[6][6] = new ArrayElement(0, false, 2); sudoku01[6][7] = new ArrayElement(1, true); sudoku01[6][8] = new ArrayElement(0, false, 5); 		
		// row 8
		sudoku01[7][0] = new ArrayElement(0, false, 6); sudoku01[7][1] = new ArrayElement(0, false, 2); sudoku01[7][2] = new ArrayElement(7, true); 
		sudoku01[7][3] = new ArrayElement(9, true); sudoku01[7][4] = new ArrayElement(5, true); sudoku01[7][5] = new ArrayElement(1, true);
		sudoku01[7][6] = new ArrayElement(0, false, 4); sudoku01[7][7] = new ArrayElement(0, false, 8); sudoku01[7][8] = new ArrayElement(3, true); 		
		// row 9
		sudoku01[8][0] = new ArrayElement(1, true); sudoku01[8][1] = new ArrayElement(0, false, 5); sudoku01[8][2] = new ArrayElement(8, true); 
		sudoku01[8][3] = new ArrayElement(0, false, 3); sudoku01[8][4] = new ArrayElement(4, true); sudoku01[8][5] = new ArrayElement(0, false, 2);
		sudoku01[8][6] = new ArrayElement(7, true); sudoku01[8][7] = new ArrayElement(0, false, 6); sudoku01[8][8] = new ArrayElement(9, true);
		
		return sudoku01;
	}
	private static ArrayElement[][] createSudoku02() {
		Sudoku.sudoku02 = new ArrayElement[9][9];
		// sudoku 02		
		// row 1
		sudoku02[0][0] = new ArrayElement(0, false, 5); sudoku02[0][1] = new ArrayElement(3, true); sudoku02[0][2] = new ArrayElement(4, true); 
		sudoku02[0][3] = new ArrayElement(6, true); sudoku02[0][4] = new ArrayElement(0, false, 7); sudoku02[0][5] = new ArrayElement(8, true);
		sudoku02[0][6] = new ArrayElement(9, true); sudoku02[0][7] = new ArrayElement(1, true); sudoku02[0][8] = new ArrayElement(0, false, 2); 		
		// row 2
		sudoku02[1][0] = new ArrayElement(6, true); sudoku02[1][1] = new ArrayElement(0, false, 7); sudoku02[1][2] = new ArrayElement(2, true);
		sudoku02[1][3] = new ArrayElement(0, false, 1); sudoku02[1][4] = new ArrayElement(9, true); sudoku02[1][5] = new ArrayElement(5, true); 
		sudoku02[1][6] = new ArrayElement(0, false, 3); sudoku02[1][7] = new ArrayElement(0, false, 4); sudoku02[1][8] = new ArrayElement(8, true);		
		// row 3
		sudoku02[2][0] = new ArrayElement(0, false, 1); sudoku02[2][1] = new ArrayElement(9, true); sudoku02[2][2] = new ArrayElement(8, true); 
		sudoku02[2][3] = new ArrayElement(0, false, 3); sudoku02[2][4] = new ArrayElement(4, true); sudoku02[2][5] = new ArrayElement(2, true);
		sudoku02[2][6] = new ArrayElement(5, true); sudoku02[2][7] = new ArrayElement(6, true); sudoku02[2][8] = new ArrayElement(0, false, 7); 		
		// row 4
		sudoku02[3][0] = new ArrayElement(0, false, 8); sudoku02[3][1] = new ArrayElement(5, true); sudoku02[3][2] = new ArrayElement(0, false, 9); 
		sudoku02[3][3] = new ArrayElement(7, true); sudoku02[3][4] = new ArrayElement(0, false, 6); sudoku02[3][5] = new ArrayElement(1, true);
		sudoku02[3][6] = new ArrayElement(4, true); sudoku02[3][7] = new ArrayElement(2, true); sudoku02[3][8] = new ArrayElement(3, true); 		
		// row 5
		sudoku02[4][0] = new ArrayElement(0, false, 4); sudoku02[4][1] = new ArrayElement(2, true); sudoku02[4][2] = new ArrayElement(6, true);
		sudoku02[4][3] = new ArrayElement(0, false, 8); sudoku02[4][4] = new ArrayElement(5, true); sudoku02[4][5] = new ArrayElement(3, true); 
		sudoku02[4][6] = new ArrayElement(0, false, 7); sudoku02[4][7] = new ArrayElement(9, true); sudoku02[4][8] = new ArrayElement(1, true);		
		// row 6
		sudoku02[5][0] = new ArrayElement(7, true); sudoku02[5][1] = new ArrayElement(0, false, 1); sudoku02[5][2] = new ArrayElement(3, true); 
		sudoku02[5][3] = new ArrayElement(9, true); sudoku02[5][4] = new ArrayElement(2, true); sudoku02[5][5] = new ArrayElement(0, false, 4);
		sudoku02[5][6] = new ArrayElement(8, true); sudoku02[5][7] = new ArrayElement(0, false, 5); sudoku02[5][8] = new ArrayElement(6, true); 		
		// row 7
		sudoku02[6][0] = new ArrayElement(9, true); sudoku02[6][1] = new ArrayElement(6, true); sudoku02[6][2] = new ArrayElement(0, false, 1); 
		sudoku02[6][3] = new ArrayElement(0, false, 5); sudoku02[6][4] = new ArrayElement(3, true); sudoku02[6][5] = new ArrayElement(7, true);
		sudoku02[6][6] = new ArrayElement(0, false, 2); sudoku02[6][7] = new ArrayElement(8, true); sudoku02[6][8] = new ArrayElement(4, true); 		
		// row 8
		sudoku02[7][0] = new ArrayElement(0, false, 2); sudoku02[7][1] = new ArrayElement(0, false, 8); sudoku02[7][2] = new ArrayElement(0, false, 7); 
		sudoku02[7][3] = new ArrayElement(4, true); sudoku02[7][4] = new ArrayElement(1, true); sudoku02[7][5] = new ArrayElement(9, true);
		sudoku02[7][6] = new ArrayElement(6, true); sudoku02[7][7] = new ArrayElement(3, true); sudoku02[7][8] = new ArrayElement(5, true); 		
		// row 9
		sudoku02[8][0] = new ArrayElement(3, true); sudoku02[8][1] = new ArrayElement(0, false, 4); sudoku02[8][2] = new ArrayElement(5, true); 
		sudoku02[8][3] = new ArrayElement(2, true); sudoku02[8][4] = new ArrayElement(0, false, 8); sudoku02[8][5] = new ArrayElement(6, true);
		sudoku02[8][6] = new ArrayElement(1, true); sudoku02[8][7] = new ArrayElement(0, false, 7); sudoku02[8][8] = new ArrayElement(9, true);
		
		return sudoku02;
	}
}
