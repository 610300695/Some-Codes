/**
 * キーボード入力される対数を含む関数（以下対数関数と略記)の各定数や積分区間を元に、
 * その関数の積分が計算可能かどうかを判定するためのクラス。
 * @author your name
 *
 */
public class ConditionChecker {
	/** 対数関数の各定数 */
	double a, b, c;

	/** 積分区間の始点と終点 */
	double startPoint, endPoint;

	/** 対数関数の各定数や積分区間の始点と終点 の値をキーボードから
	 * 読み込むためのDataStorageクラスのオブジェクトの参照
	 */
	DataStorage dStorage;

	/**
	 * コンストラクタでは、DataStorage クラスのオブジェクトを生成して
	 * dStorageフィールドで参照する．
	 */
	public ConditionChecker() {
		this.dStorage = new DataStorage();
	}

	/** DataStorageクラスの機能を利用して、a,b,c フィールドに値を設定するためのメソッド */
	public void putABC() {
		dStorage.enterData(3);
		a = dStorage.valueAt(0);
		b = dStorage.valueAt(1);
		c = dStorage.valueAt(2);
	}

	/** フィールド a のゲッター */
	public double getA() {
		return a;
	}

	/** フィールド b のゲッター */
	public double getB() {
		return b;
	}

	/** フィールド c のゲッター */
	public double getC() {
		return c;
	}

	/** フィールド startPoint のゲッター */
	public double getStartPoint() {
		return startPoint;
	}

	/** フィールド endPoint のゲッター */
	public double getEndPoint() {
		return endPoint;
	}

	/** b フィールドが 0 かどうかを判定するためのメソッド */
	public boolean isBzero() {
		double b = dStorage.valueAt(1);
		if (b == 0) {
			System.out.println("b の値が0です。");
			return true;
		} else
			return false;
	}

	/** a,b,c フィールドの値を元に、log(bx + c) が計算可能な積分区間を表示するためのメソッド */
	public void showConditionOfStartEndPoint() {
		/* 積分計算可能な区間を案内 */
		if (b < 0) {
			System.out.printf("終点は %.4f未満でなければなりません。\n", -c / b);
		} else {
			System.out.printf("始点は %.4fより大きくなければなりません。\n", -c / b);
		}
	}

	/** DataStorageクラスの機能を利用して、startPoint, endPoint フィールドに値を
	 * 設定するためのメソッド 
	 */
	public void putStartAndEndPoint() {
		dStorage.enterData(2);
		startPoint = dStorage.valueAt(0);
		endPoint = dStorage.valueAt(1);
	}

	/** startPoint と endPoint の値が適切かどうかを判定するメソッド */
	public boolean checkStartAndEndPoint() {
		if (endPoint <= startPoint) {
			System.out.println("始点と終点が同じか始点のほうが大きくなっています。");
			return false;
		} else
			return true;
	}

	/** a, b, c, startPoint, endPoint の各値を参照し、以下のような計算不能な組み合わせに
	 * なっていないかどうかを判定するためのメソッド。
	 * 1. log (bx +c) は、bx+c が0以下の場合未定義なので計算できない
	 * 2. x^a は、xが負かつaが整数でない実数（小数点以下の値を持つ数値) の場合未定義なので計算できない
	 * 3. x^a は、xが0かつaが負の場合0除算で数学では未定義となり計算できない
	 */
	public boolean checkIntegralSection() {
		boolean result = true;
		if ((0 < b && startPoint <= -c / b) || (b < 0 && endPoint >= -c / b)) {// 1. の条件の判定
			System.out.println("積分区間に bx+c が0以下になる部分があります。");
			result = false;

		} else if (Math.abs(a - (int) a) > 0.0 && startPoint < 0) {//2. の条件の判定
			System.out.println("a は浮動小数点数ですが、積分区間にxが負になる部分があります。");
			result = false;
		} else if (a < 0 && startPoint * endPoint <= 0) {//3. の条件の判定
			System.out.println("a は負ですが、積分区間にx==0が含まれます。");
			result = false;
		}
		return result;
	}
}