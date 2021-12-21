/*
 * 提出者 21-1-037-0063 キンシンヨウ
 * 課題 13-3
 * 提出日 2021/12/21
 */

/* 5つのクラスの機能をまとめ、積分計算機としての機能を実現するクラス */
public class IntegralCalculator {
	private int numOfGrid; //この積分計算機の精度(積分区間を何分割するかを表す)
	private ConditionChecker checker; //対数関数の各定数や積分区間に関する条件を判定する機能を持つオブジェクトの参照
	private LogarithmFunction2 logFunction; //対数関数を表すオブジェクトの参照
	private Integrator2 integrator; //積分を計算する機能を持つオブジェクトの参照
	private Display display; //対数関数式や積分式、計算結果を表示する機能を持つオブジェクトの参照
	
	/*numOfGridフィールドに設定する値のみを引数とし、
	 * checkerとdisplayフィールドはオブジェクトを生成して参照する。
	 * logFunctionとintegratorフィールドは、
	 * それぞれmakeLogFunctionメソッドとmakeIntegratorメソッドでオブジェクトを生成して参照する。*/
	public IntegralCalculator(int numOfGrid) {
		this.numOfGrid = numOfGrid;
		this.checker = new ConditionChecker();
		this.display = new Display();	
	}
	
	/* 積分対象の対数関数を生成するためのメソッド */
	public void makeLogFunction() {
		do {
			System.out.print("x^a log(bx + c) の a, b, c の浮動小数点数(bは0以外)をスペースで区切って入力: ");
			checker.putABC();
		}while (checker.isBzero());
		
		logFunction = new LogarithmFunction2(checker.getA(), checker.getB(), checker.getC());
	}
	
	/* 積分器を生成するためのメソッド */
	public void makeIntegrator() {
		checker.showConditionOfStartEndPoint();//始点あるいは終点の情報を表示
		do {
			System.out.print("積分の始点と終点の値(浮動小数点数)をスペースで区切って入力: ");
			checker.putStartAndEndPoint();
		}while (!checker.checkStartAndEndPoint() || !checker.checkIntegralSection());
		
		integrator = new Integrator2(checker.getStartPoint(), checker.getEndPoint(), logFunction);
	}
	
	/* displayにメッセージを送り、対数関数の式を表示するメソッド */
	public void displayLogFunction() {
		display.showExpression(logFunction.getExpression());
		System.out.println();
	}
	
	/* displayにメッセージを送り、対数関数の積分式を表示するメソッド */
	public void displayIntegralForm() {
		display.showIntegralForm(checker.getStartPoint(), checker.getEndPoint(), logFunction.getExpression());
		System.out.println();
	}
	
	/* Integratorの積分機能を呼び出して積分を計算し、返ってきた結果をdisiplayにメッセージとして送って表示するメソッド */
	public void go() {
		display.showResult(integrator.sectionalMensuration(this.numOfGrid));
		System.out.println();
	}
	
	public static void main(String[] args) {
		final int numOfGrid = 100000000; // 積分区間の分割数(積分器の精度)
		IntegralCalculator calculator = new IntegralCalculator(numOfGrid);
		calculator.makeLogFunction(); // 対数関数の生成
		calculator.displayLogFunction(); // 生成された対数関数式の表示
		calculator.makeIntegrator(); // 積分器の生成
		calculator.displayIntegralForm(); // 積分式の表示
		calculator.go(); // 積分を計算し、結果を表示する。
	}
}
