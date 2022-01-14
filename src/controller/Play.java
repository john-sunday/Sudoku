package controller;

import model.Sudoku;
import view.Console;

// Funtional class to PLAY Sudoku.
public class Play {
	
	// Class fields.
	private int introRow;
	private int introCol;
	private ArrayElement [][] sudoku;
	private String election;
	private int zeroCount;
	private int squareNumber;
	private int testValue;
	private int electionCast;
	private boolean rowTest;
	private boolean colTest;
	private boolean squareTest;
	private boolean arrayTest;

	// Constructor.
	public Play() {
		 sudoku = new ArrayElement [9][9];		
		 introRow = 0;
		 introCol = 0;
		 election = " ";
		 zeroCount = 0;
		 squareNumber = 0;
		 testValue = 0;
		 electionCast = 0;
		 rowTest = true;
		 colTest = true;
		 squareTest = true;
		 arrayTest = true;
	}

	
	// Method that receives an array of type MatrixElement, which fills with a nested for loop the main sudoku array.
	public void fillArray(ArrayElement [][] chosenArray) {			
		for(int i = 0; i < chosenArray.length; i++) { // row.
			for(int j = 0; j < chosenArray[i].length; j++) { // columns of the same row.				
				sudoku[i][j] = chosenArray[i][j];
			}
		}
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	// CHOICE METHODS.
	//------------------------------------------------------------------------------------------------------------------------------
	
	// Method that asks if you want sudoku 1 or 2.
	public void chooseSudoku() {			
		// Loop: asks the user for the sudoku number in String and casts the choice to integer, as long as no one or two is entered.
		do {
			election = Console.giveMeSudoku();
			electionCast = Integer.parseInt(election);
		}while(electionCast != 1 && electionCast != 2);
		
		// With the chosen sudoku, we call the fill array method, passing it the corresponding sudoku array.
		switch (electionCast) {		
		case 1: fillArray(Sudoku.getSudoku01()); break;
		case 2: fillArray(Sudoku.getSudoku02()); break;
		}							
	}
		
	/* No lo llamo desde el main, porque lo utilizo dentro del siguiente método que comprueba
	 * la fila, la columna y el cuadrado */

	/* Metodo que mediante bucle, pide fila, columna y valor, mientras la fila o la columna superen los l�mites del sudoku
	 * o mientras la posición elegida sea fija.	*/
	public void chooseRowCol() {		
		do {
			introRow = Console.giveMeRow();
			introCol = Console.giveMeCol();						
			if(sudoku[introRow-1][introCol-1].isFixed()) {
				Console.showLineBreak("Error !! The position you try modify, is fixed.");				
			}
			if(introRow>9 || introCol>9) {
				Console.showLineBreak("ERROR !! The row or column number exceeds the Sudoku limits.");				
			}
		}while(introRow>9 || introCol>9 || sudoku[introRow-1][introCol-1].isFixed());		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	// METHODS THAT PRINT SUDOKU.
	//------------------------------------------------------------------------------------------------------------------------------
	
	/* Método que imprime sudoku, que es un array de dos dimensiones con objetos de la clase ArrayElement.
	 * Cuando encuentra un número fijo lo imprime, cuando es variable y no es cero, lo imprime
	 * con un asterisco para indicar que es variable, y cuando es un cero, imprime un espacio en 
	 * blanco con un asterisco */
	public void showSudoku() {		
		int counter = 0;
		int counter2 = 0;
		
		for(int i = 0; i < sudoku.length; i++) {
			Console.showLineBreak("\t--------------------------------------------------");
			if(counter%3 == 0) {
				Console.showLineBreak("\t--------------------------------------------------");
			}
			counter++;
			Console.showInlineString("\t|| ");

			for(int j = 0; j < sudoku[i].length; j++) {				
				if(sudoku[i][j].isFixed()) {
					Console.showInlineFixNum(sudoku[i][j].getValue());
				}else if(!sudoku[i][j].isFixed() && sudoku[i][j].getValue()!=0){
					Console.showInlineVarNum(sudoku[i][j].getValue());
					Console.showMark();
				}else {
					 Console.showInlineSpace();
					 Console.showMark();
				}
				counter2++;
								
				if(counter2%3 == 0) {
					Console.showInlineString(" || ");
				}else {
					Console.showInlineString(" | ");
				}
			}
			Console.showLineBreak(" ");
		}
		Console.showLineBreak("\t--------------------------------------------------");
		Console.showLineBreak("\t--------------------------------------------------");
	}
	
	/* Método que imprime el sudoku sin marcar los valores variables, y sin esconder los ceros correspondientes
	 * a las posiciones variables que no se han tocado */
	public void showFullSudoku() {
		int count = 0;
		int count2 = 0;
		
		for(int i = 0; i < sudoku.length; i++) {
			Console.showLineBreak("\t--------------------------------------------------");
			if(count%3 == 0) {
				Console.showLineBreak("\t--------------------------------------------------");
			}
			count++;
			Console.showInlineString("\t|| ");

			for(int j = 0; j < sudoku[i].length; j++) {				
				Console.showInlineFixNum(sudoku[i][j].getValue());
				count2++;				
				
				if(count2%3 == 0) {
					Console.showInlineString(" || ");
				}else {
					Console.showInlineString(" | ");
				}
			}
			Console.showLineBreak(" ");
		}
		Console.showLineBreak("\t--------------------------------------------------");
		Console.showLineBreak("\t--------------------------------------------------");				
	}
		
	//------------------------------------------------------------------------------------------------------------------------------
	// METHODS THAT RETURN DATA.
	//------------------------------------------------------------------------------------------------------------------------------
	
	/* Método que devueve un entero con el número de cuadrado donde se encuentra la posición elegida. */	
	public int giveMeChoosenSquare () {		
			
		if((introRow-1==0 || introRow-1==1 || introRow-1==2) && (introCol-1==0 || introCol-1==1 || introCol-1==2)) {
			squareNumber = 1;
		}else if((introRow-1==0 || introRow-1==1 || introRow-1==2) && (introCol-1==3 || introCol-1==4 || introCol-1==5)) {
			squareNumber = 2;
		}else if((introRow-1==0 || introRow-1==1 || introRow-1==2) && (introCol-1==6 || introCol-1==7 || introCol-1==8)) {
			squareNumber = 3;
		}else if((introRow-1==3 || introRow-1==4 || introRow-1==5) && (introCol-1==0 || introCol-1==1 || introCol-1==2)) {
			squareNumber = 4;
		}else if((introRow-1==3 || introRow-1==4 || introRow-1==5) && (introCol-1==3 || introCol-1==4 || introCol-1==5)) {
			squareNumber = 5;
		}else if((introRow-1==3 || introRow-1==4 || introRow-1==5) && (introCol-1==6 || introCol-1==7 || introCol-1==8)) {
			squareNumber = 6;
		}else if((introRow-1==6 || introRow-1==7 || introRow-1==8) && (introCol-1==0 || introCol-1==1 || introCol-1==2)) {
			squareNumber = 7;
		}else if((introRow-1==6 || introRow-1==7 || introRow-1==8) && (introCol-1==3 || introCol-1==4 || introCol-1==5)) {
			squareNumber = 8;
		}else if((introRow-1==6 || introRow-1==7 || introRow-1==8) && (introCol-1==6 || introCol-1==7 || introCol-1==8)) {
			squareNumber = 9;
		}else {
			Console.showLineBreak("There is an ERROR with the choosen square !!");
		}
		return squareNumber;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	// CHECK METHODS.
	//------------------------------------------------------------------------------------------------------------------------------
	
	/* Método principal del ejercicio (mayor complejidad): 
	 * 		en el bucle externo: 
	 * 			antes de salir del bucle, recorre con un for anidado la matriz, y cuenta los ceros 
	 * 			condición de salida: mientras los ceros contados sean más de cero
	 * 		
	 * 		en el bucle interno:
	 * 			llamada al método introduce fila y columna
	 * 			llamada al método dame valor que recojo en una variable valor de prueba
	 * 			en cada vuelta del bucle interno, pongo a true las tres variables boleanas de fila, columna y cuadrado
	 * 			
	 * 			for anidado:
	 * 				en el for interno que recorre las filas hago dos comparaciones:
	 * 					si la fila del sudoku que se está recorriendo coincide con la fila elegida, haz la siguiente comprobación:
	 * 						si el valor de la posición de la fila que se está recorriendo del sudoku, (sudoku[i][j]), coincide con el valor de prueba, 
	 * 						entonces la comprobación de fila es false, e imprime mensaje de error
	 * 					si el valor de la columna, en cada una de las filas, coincide con el valor de prueba:
	 * 						compara la posición en ese momento con el valor de prueba, y si coincide, la comprobación de columna es false, y muestra 
	 * 						mensaje de error (esta segunda comprobación es una redundancia de la anterior línea)
	 * 					
	 * 			cuando termina con el for externo:
	 * 				recojo en una variable el entero que devuelve la llamada al método número de array, el cual te dice el cuadrado donde se encuentra
	 * 				la posición elegida
	 * 				en la variable boleana test cuadrado, recojo la devolución de la llamada al método que comprueba si el valor de prueba coincide 
	 * 				con algún valor del cuadrado o array. Al método que comprueba el cuadrado, le paso por parámetro el número de array y el valor de prueba
	 * 			
	 * 			llamada al método que imprime el sudoku total
	 * 			
	 * 			comprobación del bucle interno:
	 * 				mientras las variables boleanas que recojen la comprobación de fila, columna y cuadrado, no sean las tres true, no salgas del bucle interno
	 * 			
	 * 			cuando el flujo sale del bucle interno, es porque las tres comprobaciones son true(correctas), con lo cual, establezco el valor de prueba
	 * 			en la posición elegida
	 * 			
	 * 			establezco el contador de ceros a cero, y con un for anidado recorro el sudoku para contar el número de ceros
	 * 			
	 * 			llamada al método que imprime el sudoku, con fijos y variables
	 * 			
	 * 			comprobación del bucle externo:
	 * 				mientras el número de ceros sea mayor a cero, continua con el proceso
	 *   */
	
	public void checkRowColSquare() {									
		do {						
			do {
				chooseRowCol();
				testValue = Console.GiveMeValue();				
				rowTest = true;
				colTest = true;
				squareTest = true;				
				for(int i=0; i<sudoku.length; i++) {
					for(int j=0; j<sudoku[i].length; j++) {						
						if(sudoku[i] == sudoku[introRow-1]) {
							if(sudoku[i][j].getValue() == testValue) {
								rowTest = false;
								Console.showLineBreak("ERROR !! The number entered MATCHES another number in the ROW.");
							}
						}else if(sudoku[i][introCol-1].getValue() == testValue) {
							if(sudoku[i][j].getValue() == testValue) {
								colTest = false;
								Console.showLineBreak("ERROR !! The number entered MATCHES another number in the COLUMN.");
							}
						}					
					}
				}
				squareNumber = giveMeChoosenSquare();
				squareTest = checkSquare(squareNumber, testValue);
				//showFullSudoku();
				// no hace falta establecer el valor anterior, porque el valor introducido primero se comprueba antes de establecerlo.
				/*if(!introValue) {
					sudoku[introRow][introCol].setValue(previousValue);
				}*/				
			}while(!rowTest || !colTest || !squareTest);
			
			sudoku[introRow-1][introCol-1].setValue(testValue);			
			zeroCount = 0;
			for(int i=0; i<sudoku.length; i++) {
				for(int j=0;j<sudoku[i].length;j++) {				
					if(sudoku[i][j].getValue() == 0) {
						zeroCount++;
					}
				}
			}
			showSudoku();			
		}while(zeroCount>0);
	}
	
	/* Método que recibe por parámetro el número de cuadrado elegido y el valor de prueba: 
	 * 		comprobando el número de cuadrado
	 * 			rellenando sólo el cuadrado elegido
	 * 			recorriendo el cuadrado elegido y comparando si coincide con el valor de prueba. En caso afirmativo, establece la variable boleana
	 * 			test array a false e imprime mensaje de error
	 * 		devuelve la variable que comprueba el cuadrado con true o false. */
	public boolean checkSquare(int squareNum, int testValue) {		
		arrayTest = true;
		
		switch(squareNum) {		
		case 1:
			int[]array1 = new int[9];
			array1[0] = sudoku[0][0].getValue(); array1[1] = sudoku[0][1].getValue(); array1[2] = sudoku[0][2].getValue(); 
			array1[3] = sudoku[1][0].getValue(); array1[4] = sudoku[1][1].getValue(); array1[5] = sudoku[1][2].getValue();
			array1[6] = sudoku[2][0].getValue(); array1[7] = sudoku[2][1].getValue(); array1[8] = sudoku[2][2].getValue();
			
			for(int i=0; i<array1.length; i++) {
				if(array1[i] == testValue) {
					arrayTest = false;
					Console.showLineBreak("SQUARE ERROR !! The number introduced MATCHES with other number of the SQUARE.");
				}
			}
			break;				
		case 2:
			int[]array2 = new int[9];
			array2[0] = sudoku[0][3].getValue(); array2[1] = sudoku[0][4].getValue(); array2[2] = sudoku[0][5].getValue(); 
			array2[3] = sudoku[1][3].getValue(); array2[4] = sudoku[1][4].getValue(); array2[5] = sudoku[1][5].getValue();
			array2[6] = sudoku[2][3].getValue(); array2[7] = sudoku[2][4].getValue(); array2[8] = sudoku[2][5].getValue();
			
			for(int i=0;i<array2.length;i++) {
				if(array2[i] == testValue) {
					arrayTest = false;
					Console.showLineBreak("SQUARE ERROR !! The number introduced MATCHES with other number of the SQUARE.");
				}
			}
			break;			
		case 3:
			int[]array3 = new int[9];
			array3[0] = sudoku[0][6].getValue(); array3[1] = sudoku[0][7].getValue(); array3[2] = sudoku[0][8].getValue(); 
			array3[3] = sudoku[1][6].getValue(); array3[4] = sudoku[1][7].getValue(); array3[5] = sudoku[1][8].getValue();
			array3[6] = sudoku[2][6].getValue(); array3[7] = sudoku[2][7].getValue(); array3[8] = sudoku[2][8].getValue();
			
			for(int i=0 ; i<array3.length; i++) {
				if(array3[i] == testValue) {
					arrayTest = false;
					Console.showLineBreak("SQUARE ERROR !! The number introduced MATCHES with other number of the SQUARE.");	
				}
			}
			break;				
		case 4:
			int[]array4 = new int[9];
			array4[0] = sudoku[3][0].getValue(); array4[1] = sudoku[3][1].getValue(); array4[2] = sudoku[3][2].getValue(); 
			array4[3] =	sudoku[4][0].getValue(); array4[4] = sudoku[4][1].getValue(); array4[5] = sudoku[4][2].getValue();
			array4[6] =	sudoku[5][0].getValue(); array4[7] = sudoku[5][1].getValue(); array4[8] = sudoku[5][2].getValue();
			
			for(int i=0; i<array4.length; i++) {
				if(array4[i] == testValue) {
					arrayTest = false;
					Console.showLineBreak("SQUARE ERROR !! The number introduced MATCHES with other number of the SQUARE.");
				}
			}				
			break;			
		case 5:
			int[]array5 = new int[9];
			array5[0] = sudoku[3][3].getValue(); array5[1] = sudoku[3][4].getValue(); array5[2] = sudoku[3][5].getValue(); 
			array5[3] = sudoku[4][3].getValue(); array5[4] = sudoku[4][4].getValue(); array5[5] = sudoku[4][5].getValue();
			array5[6] = sudoku[5][3].getValue(); array5[7] = sudoku[5][4].getValue(); array5[8] = sudoku[5][5].getValue();
			
			for(int i=0; i<array5.length; i++) {
				if(array5[i] == testValue) {
					arrayTest = false;
					Console.showLineBreak("SQUARE ERROR !! The number introduced MATCHES with other number of the SQUARE.");
				}
			}
			break;					
		case 6:
			int[]array6 = new int[9];
			array6[0] = sudoku[3][6].getValue(); array6[1] = sudoku[3][7].getValue(); array6[2] = sudoku[3][8].getValue(); 
			array6[3] =	sudoku[4][6].getValue(); array6[4] = sudoku[4][7].getValue(); array6[5] = sudoku[4][8].getValue();
			array6[6] = sudoku[5][6].getValue(); array6[7] = sudoku[5][7].getValue(); array6[8] = sudoku[5][8].getValue();
			
			for(int i=0; i<array6.length; i++) {
				if(array6[i] == testValue) {
					arrayTest = false;
					Console.showLineBreak("SQUARE ERROR !! The number introduced MATCHES with other number of the SQUARE.");
				}
			}
			break;							
		case 7:
			int[]array7 = new int[9];
			array7[0] = sudoku[6][0].getValue(); array7[1] = sudoku[6][1].getValue(); array7[2] = sudoku[6][2].getValue(); 
			array7[3] =	sudoku[7][0].getValue(); array7[4] = sudoku[7][1].getValue(); array7[5] = sudoku[7][2].getValue();
			array7[6] = sudoku[8][0].getValue(); array7[7] = sudoku[8][1].getValue(); array7[8] = sudoku[8][2].getValue();
			
			for(int i=0; i<array7.length; i++) {
				if(array7[i] == testValue) {
					arrayTest = false;
					Console.showLineBreak("SQUARE ERROR !! The number introduced MATCHES with other number of the SQUARE.");
				}
			}
			break;			
		case 8:
			int[]array8 = new int[9];
			array8[0] = sudoku[6][3].getValue(); array8[1] = sudoku[6][4].getValue(); array8[2] = sudoku[6][5].getValue(); 
			array8[3] = sudoku[7][3].getValue(); array8[4] = sudoku[7][4].getValue(); array8[5] = sudoku[7][5].getValue();
			array8[6] =	sudoku[8][3].getValue(); array8[7] = sudoku[8][4].getValue(); array8[8] = sudoku[8][5].getValue();
			
			for(int i=0; i<array8.length; i++) {
				if(array8[i] == testValue) {
					arrayTest = false;
					Console.showLineBreak("SQUARE ERROR !! The number introduced MATCHES with other number of the SQUARE.");	
				}
			}
			break;			
		case 9:
			int []array9 = new int[9];
			array9[0] = sudoku[6][6].getValue(); array9[1] = sudoku[6][7].getValue(); array9[2] = sudoku[6][8].getValue(); 
			array9[3] =	sudoku[7][6].getValue(); array9[4] = sudoku[7][7].getValue(); array9[5] = sudoku[7][8].getValue();
			array9[6] =	sudoku[8][6].getValue(); array9[7] = sudoku[8][7].getValue(); array9[8] = sudoku[8][8].getValue();
			
			for(int i=0; i<array9.length; i++) {
				if(array9[i] == testValue) {
					arrayTest = false;
					Console.showLineBreak("SQUARE ERROR !! The number introduced MATCHES with other number of the SQUARE.");
				}
			}
			break;			
		default:
			Console.showLineBreak("ERROR has occurred in the square check !!.");
			break;
	}			
		return arrayTest;
	}
}


