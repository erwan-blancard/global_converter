public class StringUtils {

	public static final char[] binaries = { '0', '1' };
	public static final char[] octals = { '0', '1', '2', '3', '4', '5', '6', '7' };
	public static final char[] decimals = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static final char[] hexadecimals = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	
	private static boolean containsOnly(String s, char[] sequence) {
		for (int i = 0; i < s.length(); i++) {
			if (!isCharIn(s.charAt(i), sequence)) { return false; }
		}
		return true;
	}
	
	private static boolean isCharIn(char c, char[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			if (c == sequence[i]) { return true; }
		}
		return false;
	}

	public static boolean isBinary(String s) { return containsOnly(s, binaries); }
	public static boolean isOctal(String s) { return containsOnly(s, octals); }
	public static boolean isDecimal(String s) { return containsOnly(s, decimals); }
	public static boolean isHexadecimal(String s) { return containsOnly(s.toUpperCase(), hexadecimals); }
	
	public static boolean isBinary(char c) { return isCharIn(c, binaries); }
	public static boolean isOctal(char c) { return isCharIn(c, octals); }
	public static boolean isDecimal(char c) { return isCharIn(c, decimals); }
	public static boolean isHexadecimal(char c) { return isCharIn(Character.toUpperCase(c), hexadecimals); }
	
	public static int parseIntFromDecimal(String s) {
		if (isDecimal(s)) {
			int num = 0;
			final short magicNumber = (short) '0';		// ascii value of 0
			for (int i = 0; i < s.length(); i++) {
				num += ((short) s.charAt(i) - magicNumber) * Math.pow(10, s.length()-1-i);
			}
			return num;
		}
		return -1;
	}
	
}
