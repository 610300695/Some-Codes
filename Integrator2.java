/**
 * 積分近似法(区分求積法)を実現するためのクラス。課題7 のIntegratorと内容はほとんど同じ。
 * 変更点は、functionフィールドの型がLogarithmFunction2になっただけ。
 */
public class Integrator2 {
	private double startPoint; // 積分範囲の始点
	private double endPoint; // 積分範囲の終点
	private LogarithmFunction2 function; // 積分対象となる関数の定義を持つクラスのインスタンスへの参照

	/**
	 * コンストラクタでは、引数で得た始点、終点、LogarithmFunction2クラスのオブジェクトの参照を フィールドに代入する。
	 * 
	 * @param startPoint 積分区間の始点
	 * @param endPoint   積分区間の終点
	 * @param function   積分する関数
	 */
	public Integrator2(double startPoint, double endPoint, LogarithmFunction2 function) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.function = function;
	}

	/**
	 * startPoint と endPoint、そして引数で与えられる分割数から、1区間の長さを計算するメソッド
	 * 
	 * @param numOfGrid 分割数
	 * @return 1区間の長さ
	 */
	private double calcGridSpacing(int numOfGrid) {
		return (endPoint - startPoint) / numOfGrid;
	}

	/**
	 * 区分求積法による積分似値計算をするメソッド *
	 * 
	 * @param functionID
	 * @param numOfGrid
	 * @return 計算結果
	 */
	public double sectionalMensuration(int numOfGrid) {
		// 引数で与えられる分割数numOfGridから、一区間の長さを計算する。
		double gridSpacing = calcGridSpacing(numOfGrid);
		double x_i = startPoint; // x座標の値,初期値はstartPoint
		double sigma = 0.0; // 積分近似値の初期値

		// 分割数の回数(numOfGrid回)、各区間の面積を計算してresult に足していく。
		for (int i = 0; i < numOfGrid; i++) {
			sigma += function.evaluate(x_i);
			x_i += gridSpacing;
		}
		return sigma * gridSpacing;
	}
}