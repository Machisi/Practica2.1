package main;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class ArrayTests {
	final static int INIT_SIZE = 100000,
			MAX_SIZE = 1000000,
			STEP = 100000,
			REPS = 1000;
	
	
	public static void testArrays() {
		PrintStream csvPrintStream = null;
		try {
			 csvPrintStream = new PrintStream(new FileOutputStream("output.csv"));
		} catch (Exception e) {
			System.err.println("Error: No se pudo abrir archivo CSV" + e);
		}
		System.out.printf("%10s;%10s;%10s;%10s\n", "Talla", "Mejor", "Peor", "Promedio");
		csvPrintStream.printf("%10s,%10s,%10s,%10s\n", "Talla", "Mejor", "Peor", "Promedio");
		int[] array;
		int arraySize, vBest, vWorst;
		long timeStart, timeEnd, tBest, tWorst, tAvr;
		
		for (int size=INIT_SIZE;size<=MAX_SIZE;size+=STEP) {
			array =ArraySearch. generateOrderedArray(size);
			arraySize = array.length;
			vBest = array[0];
			vWorst = array[arraySize - 1];
			
			timeStart = System.nanoTime();
			for (int rep=0; rep<REPS; rep++) {
				ArraySearch.linealSearchIterative(array, vBest);
			}
			timeEnd = System.nanoTime();
			tBest = (timeEnd-timeStart)/REPS;
			
			timeStart = System.nanoTime();
			for (int rep=0; rep<REPS; rep++) {
				ArraySearch.linealSearchIterative(array, vWorst);
			}
			timeEnd = System.nanoTime();
			tWorst = (timeEnd-timeStart)/REPS;
			
			timeStart = System.nanoTime();
			for (int rep=0; rep<REPS; rep++) {
				ArraySearch.linealSearchIterative(array, array[arraySize/2]);
			}
			timeEnd = System.nanoTime();
			tAvr  = (timeEnd-timeStart)/REPS;

			System.out.printf("%10d;%10d;%10d;%10d\n", size, tBest, tWorst, tAvr);
			csvPrintStream.printf("%10d,%10d,%10d,%10d\n", size, tBest, tWorst, tAvr);
		}
		csvPrintStream.close();
	}
}
