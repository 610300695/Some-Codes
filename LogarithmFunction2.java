/*
 * 提出者 21-1-037-0063 キンシンヨウ
 * 課題 13-2
 * 提出日 2021/12/21
 */

/* f(x) = x^a log(bx + c) を文字列の形で示すクラス */
public class LogarithmFunction2 {
	private double a, b, c; //x^a log(bx + c) の a,b,c
	private String expression; //対数関数式を表す文字列
	
	public LogarithmFunction2(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		makeExpression();
	}
	
	/* フィールドとxの値を用いて関数を計算し、結果を返すメソッド */
	public double evaluate(double x) {
		return Math.pow(x, a) * Math.log((b*x + c));
	}
	
	/* a,b,cフィールドの値を用いて、対数関数を表す文字列を生成してexpression フィールドに設定するメソッド */
	public void makeExpression() {
		/* 対数関数式を表す文字列の最初の部分. */
		if (a == 0.0) {
			expression = "log("; //x^a は aが0の場合1 なので表示しない
		}else if (a == 1.0) {
			expression = "x log("; //x^a は aが1の場合 x と表示
		}else {
			expression = "x^" + String.format("%4.2f ", a) + "log(";
		}
		
		/* log の引数の bx の部分をexpressionに追加する処理。b が0 なら何も追加しない*/
		if (b != 0.0) {
			if (b == -1) {
				expression += "-x";
			}else if (b == 1) {
				expression += "x";
			}else {
				expression += String.format("%4.2fx", b);
			}
		}
		
		/* log の引数の + c の部分をexpressionに追加する処理*/
		if (c < 0.0) {
			if (b == 0.0) {
				expression += String.format("%4.2f", c);
			}else { // b != 0.0
				expression += " - " + String.format("%4.2f", Math.abs(c));
			}
		}else if (c > 0.0) {
			if (b == 0.0) {
				expression += String.format("%4.2f", c);
			}else { // b != 0.0
				expression += " + " + String.format("%4.2f", Math.abs(c));
			}
		}else { // c == 0.0
			if (b == 0.0) {
				expression += "0.00";
			}
		}
		expression += ")";
	}
	
	/* expressionフィールドのゲッター */
	public String getExpression() {
		return expression;
	}
	
	public static void main(String[] args) {
		int numOfConstants = 3;
		DataStorage dStorage = new DataStorage();
		/* キーボードから x^a log(bx + c) の a,b,c の値を入力する */
		System.out.print("x^a log(bx + c) の ");
		System.out.print("a, b, c の値をスペースで区切って入力: ");
		dStorage.enterData(numOfConstants);
		/* 入力された値を元に、対数関数を表すオブジェクトを生成する */
		LogarithmFunction2 function = new LogarithmFunction2(dStorage.valueAt(0),
				dStorage.valueAt(1),dStorage.valueAt(2));

		System.out.printf("f(x) = %s\n", function.getExpression());
		/* キーボードから関数に与える引数の値を入力する */
		System.out.print("xの値を入力: ");
		dStorage.enterData(1);
		double x = dStorage.valueAt(0);
		/* 関数の計算結果を表示 */
		System.out.printf("f(%1.2f) = %8.2f", x, function.evaluate(x));
	}
}
