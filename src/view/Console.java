package view;

import java.util.Scanner;

public class Console {
	
	public static String giveMeSudoku() {
		Scanner sc = new Scanner(System.in);
		String numSudoku = " ";	
		showLineBreak("Choose the difficulty Sudoku level(1 or 2): ");
		numSudoku = sc.nextLine();
		return numSudoku;
	}
	public static void showLineBreak(String cadena) {
		System.out.format("%s\n", cadena);
	}
	public static void println(String cadena) {
		System.out.println(cadena);
	}
	public static void showInlineString(String cadena) {
		System.out.format("%s", cadena);
	}		
	public static void showInlineFixNum(Object sudoku) {
		System.out.format("%d%s", sudoku, " ");
	}	
	public static void showInlineVarNum(Object sudoku) {
		System.out.format("%d", sudoku);
	}	
	public static void showInlineSpace() {
		System.out.format("%s", " ");
	}	
	public static void showMark() {
		System.out.format("%s", "*");
	}	
	public static int giveMeRow() {		
		Scanner sc = new Scanner(System.in);
		int fila = 0;		
		System.out.format("%s\n", "Introduce the ROW: ");
		fila = sc.nextInt();		
		return fila;
	}	
	public static int giveMeCol() {	
		Scanner sc = new Scanner(System.in);
		int col = 0;		
		System.out.format("%s\n", "Introduce the COLUMN: ");
		col = sc.nextInt();		
		return col;
	}	
	public static int GiveMeValue() {		
		Scanner sc = new Scanner(System.in);
		int valor = 0;		
		System.out.format("%s\n", "Introduce the VALUE: ");
		valor = sc.nextInt();		
		return valor;
	}	
}
