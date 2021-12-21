/*
 * 提出者 21-1-037-0063 キンシンヨウ
 * 課題 13-1
 * 提出日 2021/12/21
 */

import java.util.ArrayList;
import java.util.Scanner;

/* 複数の浮動小数点数をキーボード入力し、それらの値をArrayListで管理するためのクラス*/
public class DataStorage {
	private ArrayList<Double> data; //Double型のArrayList
	private Scanner keyboardScanner; //キーボードのオブジェクト
	
	public DataStorage() {
		this.data = new ArrayList<>();
		this.keyboardScanner = new Scanner(System.in);
	}
	
	/* numOfData個分だけのdouble型の値をキーボードから入力、dataに保存するメソッド */
	public void enterData(int numOfData) {
		data.clear();
		
		for(int i = 0; i < numOfData; ++i) {
			if (keyboardScanner.hasNextDouble()) {
				data.add(keyboardScanner.nextDouble());
			}else { //数値とみなせないような誤った入力があった場合、プログラムを停止。
				System.out.println("浮動小数点以外が入力されました。終了します。");
				System.exit(1);
			}
		}
	}
	
	/* dataの引数で指定されたインデックスの数値を返すメソッド */
	public double valueAt(int index) {
		return data.get(index);
	}
	
	public static void main(String[] args) {
		int numOfData = 3; //入力する浮動小数点数の個数
		
		DataStorage dStorage = new DataStorage(); //DataStorageのオブジェクトの生成
		
		System.out.printf("%d 個の浮動小数点数をスペース区切りで入力: ", numOfData);
		
		dStorage.enterData(numOfData); 
		for (int i = 0; i < numOfData; i++) {
		System.out.printf("data%d: %4.2f ", i + 1, dStorage.valueAt(i));
		}
		System.out.println();

		numOfData = 2; //入力する浮動小数点数の個数
		System.out.printf("%d 個の浮動小数点数をスペース区切りで入力: ", numOfData);
		dStorage.enterData(numOfData);
		for (int i = 0; i < numOfData; i++) {
		System.out.printf("data%d: %4.2f ", i + 1, dStorage.valueAt(i));
		}
	}
}
