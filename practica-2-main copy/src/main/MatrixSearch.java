package main;

import java.util.Random;

public class MatrixSearch {
	public static int[] linearMatSearch(int[][] mat, int valor) {
		int counter = 0;
		int[] result = { -1, 1, counter};
		int x = mat.length; //filas
		int y = mat[0].length; //columnas
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				counter++;
				if (mat[i][j] == valor) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		
		result[2] = counter;
		
		return result;
	}
	
	public static int[] successfulMatSearch(int[][] mat, int valor) {
		int counter = 0;
		int x = mat.length; //filas
		int y = mat[0].length; //columnas
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				counter++;
				if (mat[i][j] == valor) {
					return new int[]{ i, j, counter};
				}
			}
		}
		
		return new int[] {-1, -1, counter};
	}

	public static int[] binaryMatSearch(int[][] matrix, int target) {
		int x = matrix.length; //filas
		int y = matrix[0].length; //columnas
		int counter = 0;
		int index = 0;
		int lastIndex = (x * y) - 1;
		while (counter <= lastIndex) {
			index++;
			int mid = counter + (lastIndex - counter) / 2;
			int[] coordinates = getCoordinates(mid, y);
			int midValue = matrix[coordinates[0]][coordinates[1]];
			if (midValue == target) {
				return new int[] { coordinates[0], coordinates[1], index };
			}
			if (midValue < target) {
				counter = mid + 1;
			} else {
				lastIndex = mid - 1;
			}
		}
		return new int[] {-1, -1, index};
	}

	public static int[] binaryMatRecursiveSearch(int[][] mat, int target, int inicio, int fin) {
		return binaryMatRecursiveSearchHelper(mat, target, inicio, fin, 1);
	}

	private static int[] binaryMatRecursiveSearchHelper(int[][] mat, int target, int inicio, int fin, int count) {
		if (inicio <= fin) {
			int mid = inicio + (fin - inicio) / 2;
			int[] coordinates = getCoordinates(mid, mat[0].length);

			if (mat[coordinates[0]][coordinates[1]] == target) {
				return new int[] { coordinates[0], coordinates[1], count };
			}
			if (mat[coordinates[0]][coordinates[1]] < target) {
				return binaryMatRecursiveSearchHelper(mat, target, mid + 1, fin, count + 1);
			} else {
				return binaryMatRecursiveSearchHelper(mat, target, inicio, mid - 1, count + 1);
			}
		}
		return new int[] { -1, -1, count - 1 };
	}

	public static int[] getCoordinates(int index, int width) {
		int[] coordinates = new int[2];
		coordinates[0] = index / width; // fila
		coordinates[1] = index % width; // columna
		return coordinates;
	}
	
	public static int[][] generateOrderedMatrix(int m, int n) {
		 Random rand = new Random();
		 int[][] matrix = new int[m][n];
		 int value = 0;
		 for (int i = 0; i < m; i++) {
			 for (int j = 0; j < n; j++) {
			 	value +=rand.nextInt(9)+1; //Inc. aleatorio entre 1 y 10
		 		matrix[i][j] = value;
		 	}
		 }
		 return matrix;
	}
}
