public class Matrix {
	public static void main(String[] args) {
		int[][] a = new int[3][4];
		int[][] b = new int[3][4], c = new int[3][4];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				a[i][j] = i + j;
				b[i][j] = 10 - (i * j);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.print("(");
			for (int j = 0; j < 4; j++) {
				System.out.printf("%3d", a[i][j]);
			}
			System.out.print(")");
			
			if (i == 1) System.out.print(" + ");
			else System.out.print("   ");
			
			System.out.print("(");
			for (int j = 0; j < 4; j++) {
				System.out.printf("%3d", b[i][j]);
			}
			System.out.print(")");
			
			if (i == 1) System.out.print(" = ");
			else System.out.print("   ");
			
			System.out.print("(");
			for (int j = 0; j < 4; j++) {
				System.out.printf("%3d", c[i][j]);
			}
			System.out.println(")");
		}
	}
}
