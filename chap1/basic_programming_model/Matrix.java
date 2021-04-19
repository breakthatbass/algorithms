/*
*/
public class Matrix 
{
	static double[][] matrix;

	public static void print_matrix(double[][] mat)
	{
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void print_vector(double[] v)

	{
		for (int i = 0; i < v.length; i++)
			System.out.print(v[i] + " ");
		System.out.println();
	}


	public static double dot(double[] x, double[] y)
	{
		double dot = 0;
		int i;

		if (x.length != y.length) {
			System.out.println("Matrix: dot: vector sizes must be equal");
			return dot;
		}

		for (i = 0; i < x.length; i++)
			dot += x[i] * y[i];
		return dot;
	}

	public static double[][] mult(double[][] a, double[][] b)
	{
		int i, j;
		int rows = a.length;
		int cols = a[0].length;
		double x[][] = new double[rows][cols];

		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("Matrix: mult: matrix sizes must be equal");
			return x;
		}

		for (i = 0; i < rows; i++) {
			for (j = 0; j < cols; j++) {
				x[i][j] = a[i][j]*b[i][j];
			}
		}
		return x;
	}


	public static double[][] transpose(double[][] a)
	{
		int i, j;
		int m = a[0].length;
		int n = a.length;

		double[][] x = new double[n][m];

		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				x[i][j] = a[j][i];
			}
		}
		return x;
	}


	// matrix-vector product
	public static double[] mult(double[][]a, double[] b)
	{
		int i, j;
		double[] x = new double[b.length];

		if (a.length != b.length) {
			System.out.println("Matrix: mult (matrix-vector): matrix rows must equal vector columns");
			return x;
		}

		for (i = 0; i < a.length; i++) {
			for (j = 0; j < b.length; j++) {
				x[i] += a[i][j] * b[j];
			}
		}
		return x;
	}


	// vector-matrix product
	public static double[] mult(double[] y, double[][] a)
	{
		int i, j;
		double[] b = new double[a[0].length];

		for (i = 0; i < a[0].length; i++) {
			for (j = 0; j < y.length; j++) {
				b[i] += a[j][i] * y[j];
			}
		}
		return b;
	}


	public static void main(String[] args)
	{
		// vector dot product
		double[] a = {1.0, 3.0, 5.0};
		double[] b = {2.0, 4.0, 6.0};

		System.out.println("vector dot product: \n" + dot(a, b));


		// matrix-matrix product
		double[][] c = {
			{1.0, 3.0},
			{2.0, 4.0}
		};

		double[][] d = {
			{1.5, 3.5},
			{2.5, 4.5}
		};

		double[][] m = mult(c, d);
		System.out.println("\nmatrix-matrix product: ");
		print_matrix(m);
		

		// transpose
		System.out.println("\ntranspose: \noriginal:");
		print_matrix(d);
		double[][] x = transpose(d);
		System.out.println("transposed:");
		print_matrix(x);

		// matrix-vector product
		
		double[][] o = {
			{1.0, 1.5, 2.0},
			{1.5, 2.5, 3.0},
			{3.5, 2.0, 4.5}
		};
		double[] n = {2.5, 1.0, 3.5};

		double[] mv = mult(o, n);
		print_vector(mv);


		System.out.println("\nvector-matrix product:");
		double[] vm = mult(n, o);
		print_vector(vm);
	}
}
