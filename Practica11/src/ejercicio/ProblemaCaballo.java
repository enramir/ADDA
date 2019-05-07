package ejercicio;

public class ProblemaCaballo {

	private static Integer lado;
	private static Integer iposx;
	private static Integer iposy;
	private static Integer[] movx = {-1, 1, -1, 1, 2, 2, -2, -2};
	private static Integer[] movy = {2, 2, -2, -2, -1, 1, -1, 1};
	
	public static Integer getLado() {
		return lado;
	}
	public static void setLado(Integer lado) {
		ProblemaCaballo.lado = lado;
	}
	public static Integer getIposx() {
		return iposx;
	}
	public static void setIposx(Integer iposx) {
		ProblemaCaballo.iposx = iposx;
	}
	public static Integer getIposy() {
		return iposy;
	}
	public static void setIposy(Integer iposy) {
		ProblemaCaballo.iposy = iposy;
	}
	public static Integer[] getMovx() {
		return movx;
	}
	public static Integer[] getMovy() {
		return movy;
	}
	
	
}
