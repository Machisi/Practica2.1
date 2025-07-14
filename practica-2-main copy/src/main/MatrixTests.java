package main;

public class MatrixTests {
	public static void testMatrix() {
		testLinearMat(10, 10);
		testSuccessfulMat(10, 10);
		testBinaryMat(10,10);
		testBinaryMatRecursive(10,10);
	}
	
	public static void testLinearMat(int m, int n) {
		int iterSum = 0;
		System.out.printf("%s\t\t%s\t%s\t%s\n", "Descripcion", "Talla",
				"Iteraciones", "Resultado");
		System.out.println("---------------------------------------------------------");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int[][] gen = MatrixSearch.generateOrderedMatrix(m,n);
				int[] result = MatrixSearch.linearMatSearch(gen, gen[i][j]);
				System.out.printf("%s\t\t%d\t%d\t\t%s\n", "linearMatSearch",
						m*n, result[2], "["+result[0]+","+result[1]+"]");
				iterSum+=result[2];
			}
		}
		System.out.println("---------------------------------------------------------");
		System.out.printf("%s:\t%d\n\n", "linearMatSearch Promedio", iterSum/(m*n));
	}
	
	public static void testSuccessfulMat(int m, int n) {
		int iterSum = 0;
		System.out.printf("%s\t\t%s\t%s\t%s\n", "Descripcion", "Talla",
				"Iteraciones", "Resultado");
		System.out.println("---------------------------------------------------------");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int[][] gen = MatrixSearch.generateOrderedMatrix(m,n);
				int[] result = MatrixSearch.successfulMatSearch(gen, gen[i][j]);
				iterSum += result[2];
				System.out.printf("%s\t%d\t%d\t\t%s\n", "successfulMatSearch",
						m*n, result[2], "["+result[0]+","+result[1]+"]");
			}
		}
		System.out.println("---------------------------------------------------------");
		System.out.printf("%s:\t%d\n\n", "successfulMatSearch Promedio", iterSum/(m*n));
	}

	public static void testBinaryMat(int m, int n) {
		int iterSum = 0;
		System.out.printf("%s\t\t%s\t%s\t%s\n", "Descripcion", "Talla",
				"Iteraciones", "Resultado");
		System.out.println("---------------------------------------------------------");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int[][] gen = MatrixSearch.generateOrderedMatrix(m,n);
				int[] result = MatrixSearch.binaryMatSearch(gen, gen[i][j]);
				iterSum += result[2];
				System.out.printf("%s\t\t%d\t%d\t\t%s\n", "binaryMatSearch",
						m*n, result[2], "["+result[0]+","+result[1]+"]");
			}
		}
		System.out.println("---------------------------------------------------------");
		System.out.printf("%s:\t%d\n\n", "binaryMatSearch Promedio", iterSum/(m*n));
	}

	public static void testBinaryMatRecursive(int m, int n) {
		int iterSum = 0;
		System.out.printf("%s\t\t%s\t%s\t%s\n", "Descripcion", "Talla",
				"Iteraciones", "Resultado");
		System.out.println("---------------------------------------------------------");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int[][] gen = MatrixSearch.generateOrderedMatrix(m,n);
				int[] result = MatrixSearch.binaryMatRecursiveSearch(gen, gen[i][j], 0, (m*n)-1);
				iterSum += result[2];
				System.out.printf("%s\t%d\t%d\t\t%s\n", "binaryMatRecursive",
						m*n, result[2], "["+result[0]+","+result[1]+"]");
			}
		}
		System.out.println("---------------------------------------------------------");
		System.out.printf("%s:\t%d\n\n", "binaryMatRecursive Promedio", iterSum/(m*n));
	}
}
