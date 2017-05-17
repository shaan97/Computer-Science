public class UnitedStates {
	public static void main(String[] args) {
		cone();
		drawbox();
		System.out.println("+------+    +------+");
		System.out.println("|United|    |United|");
		System.out.println("|States|    |States|");
		System.out.println("+------+    +------+");
		drawbox();
		cone();
	}
	public static void drawbox() {
		System.out.println("+------+    +------+");
		System.out.println("|      |    |      |");
		System.out.println("|      |    |      |");
		System.out.println("+------+    +------+");
	}
	public static void cone() {
		System.out.println("   /\\          /\\");
		System.out.println("  /  \\        /  \\");
		System.out.println(" /    \\      /    \\");
	}

}
