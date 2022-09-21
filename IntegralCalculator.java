/* 对数函数积分计算器 */
public class IntegralCalculator {
	private int numOfGrid; //积分精度(分割数)
	private ConditionChecker checker; //用来判断能否积分的对象(ConditionChecker类)
	private LogarithmFunction2 logFunction; //表示对数函数的对象(LogarithmFunction2类)
	private Integrator2 integrator; //可以计算积分的对象(Integrator2类)
	private Display display; //表示对数函数式子和积分结果的对象(Display类)
	
	/* 构造函数 */
	public IntegralCalculator(int numOfGrid) {
		this.numOfGrid = numOfGrid;
		this.checker = new ConditionChecker();
		this.display = new Display();	
	}
	
	/* 生成对数函数的方法 */
	public void makeLogFunction() {
		do {
			System.out.print("x^a log(bx + c) 的 a, b, c 的浮动小数(b ！= 0)用空格区分输入: ");
			checker.putABC();
		}while (checker.isBzero());
		
		logFunction = new LogarithmFunction2(checker.getA(), checker.getB(), checker.getC());
	}
	
	/* 生成积分器的方法 */
	public void makeIntegrator() {
		checker.showConditionOfStartEndPoint();//表示起点或者终点的条件
		do {
			System.out.print("积分的起点和终点(浮动小数)用空格区分输入: ");
			checker.putStartAndEndPoint();
		}while (!checker.checkStartAndEndPoint() || !checker.checkIntegralSection());
		
		integrator = new Integrator2(checker.getStartPoint(), checker.getEndPoint(), logFunction);
	}
	
	/* 输出对数函数的式子 */
	public void displayLogFunction() {
		display.showExpression(logFunction.getExpression());
		System.out.println();
	}
	
	/* 输出对数函数的积分式 */
	public void displayIntegralForm() {
		display.showIntegralForm(checker.getStartPoint(), checker.getEndPoint(), logFunction.getExpression());
		System.out.println();
	}
	
	/* 计算积分并输出结果 */
	public void go() {
		display.showResult(integrator.sectionalMensuration(this.numOfGrid));
		System.out.println();
	}
	
	public static void main(String[] args) {
		final int numOfGrid = 100000000; // 积分器的精度
		IntegralCalculator calculator = new IntegralCalculator(numOfGrid);
		calculator.makeLogFunction(); // 生成对数函数
		calculator.displayLogFunction(); // 输出对数函数式子
		calculator.makeIntegrator(); // 生产积分器
		calculator.displayIntegralForm(); // 输出积分式
		calculator.go(); // 计算积分结果并输出
	}
}
