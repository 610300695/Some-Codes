/**
 * Integral Calculator(https://www.integral-calculator.com) と同じように
 * 積分対象の関数や積分式、計算結果を表示するためのクラス。 表示機能のみのクラスなので、
 * このクラス独自のフィールドやコンストラクタは持たない。
 * 
 * @author キンシンヨウ
 */
public class Display {

	/**
	 * 積分対象の関数をIntegral Calculatorと同じように表示するメソッド
	 * @param expression 積分対象の関数式
	 */
	public void showExpression(String expression) {
		System.out.println("YOUR INPUT"); // 見出しの表示
		System.out.printf("f(x) = %s\n", expression); // 積分対象の関数式の表示
	}

	/**
	 * ∫記号から始まり dx で終わる積分式をIntegral Calculatorと同じように表示するメソッド
	 * @param startPoint 積分の始点
	 * @param endPoint   積分の終点
	 * @param expression 積分対象の関数式
	 */
	public void showIntegralForm(double startPoint, double endPoint, String expression) {
		System.out.println("This will be calculated:"); // 見出しの表示
		System.out.printf("%4.2f\n", endPoint); // 積分区間終点
		System.out.printf("∫%s dx\n", expression); // ∫記号から始まり dx で終わる積分式
		System.out.printf("%4.2f\n", startPoint);// 積分区間始点
	}

	/**
	 * 積分の計算結果をIntegral Calculatorと同じように表示するメソッド
	 * @param result 計算結果
	 */
	public void showResult(double result) {
		System.out.println("Approximation:"); // 見出しの表示
		System.out.printf("%16.12f", result); // 計算結果の表示
	}
}