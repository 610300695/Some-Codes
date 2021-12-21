import java.util.Scanner;

public class Matrix44 {
	private int[][] a;
	
	public Matrix44(int[] numbers) {
		a = new int[4][4];
		int n = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				a[i][j] = numbers[n++];
			}
		}
	}
	
	public int determinant33(int s, int t) {
		int[][] b = new int[3][3];
		int determinant = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i < s) {
					if (j < t) {
						b[i][j] = a[i][j];
					}else if (j > t) {
						b[i][j-1] = a[i][j];
					}
				}else if (i > s) {
					if (j < t) {
						b[i-1][j] = a[i][j];
					}else if (j > t) {
						b[i-1][j-1] = a[i][j];
					}
				}
			}
		}
		
		determinant = b[0][0]*b[1][1]*b[2][2] + b[0][1]*b[1][2]*b[2][0] + b[0][2]*b[1][0]*b[2][1]
				- b[0][2]*b[1][1]*b[2][0] - b[0][1]*b[1][0]*b[2][2] - b[0][0]*b[1][2]*b[2][1];
		
		return determinant;
	}
	
	public int determinant44() {
		int determinant = 0;
		
		determinant = a[0][0]*determinant33(0, 0) - a[0][1]*determinant33(0, 1)
				+ a[0][2]*determinant33(0, 2) - a[0][3]*determinant33(0, 3);
		
		return determinant;
	}
	public static void main(String[] args) {
		Scanner kbscanner = new Scanner(System.in);
		
		int[] numbers = new int[16];
		System.out.print("16個の整数を入力:");
		
		for (int i = 0; i < 16; i++) {
			numbers[i] = kbscanner.nextInt();
		}
		
		Matrix44 mt44 = new Matrix44(numbers);
		
		System.out.printf("|A| = %d", mt44.determinant44());
		
		kbscanner.close();

	}

}
