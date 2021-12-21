/*
 * 提出者 21-1-037-0063 キンシンヨウ
 * 発展課題1
 * 提出日 2021/11/9
 */

import java.util.Scanner;

public class Matrix33 {
	private int[][] a;
	
	public Matrix33(int[] numbers) {
		a = new int[3][3];
		int n = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = numbers[n++];
			}
		}
	}
	
	public int determinant22(int s, int t) {
		int[][] b = new int[2][2];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
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
		
		return b[0][0]*b[1][1] - b[0][1]*b[1][0];
	}
	
	public int determinant33() {
		int determinant = a[0][0]*determinant22(0, 0) - a[0][1]*determinant22(0, 1) + a[0][2]*determinant22(0, 2);
		return determinant;
	}
	
	public static void main(String[] args) {
		Scanner kbscanner = new Scanner(System.in);
		
		int[] numbers = new int[9];
		System.out.print("9個の整数を入力:");
		
		for (int i = 0; i < 9; i++) {
			numbers[i] = kbscanner.nextInt();
		}
		
		Matrix33 mt33 = new Matrix33(numbers);
		
		System.out.printf("|A| = %d", mt33.determinant33());
		
		kbscanner.close();
	}
}
