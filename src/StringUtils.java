public class StringUtils {
	
	public static final short MIN_CHAR_VAL = (short) ' ';
	public static final short MAX_CHAR_VAL = (short) '~';

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
	
	/*
	 * is character valid (between ' ' and '~' in ascii table)
	 */
	public static boolean isValidForChar(int num) { return (num >= MIN_CHAR_VAL && num <= MAX_CHAR_VAL); }
	
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
	
	private static int parseDecimalFromBase(String s, char[] baseNumbers) {
		if (!containsOnly(s, baseNumbers)) { return -1; }		// if input is not in baseNumbers, return -1
		
		int num = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int xNum = 0;		// stores the decimal representation of the X based number
			for (int j = 0; j < baseNumbers.length; j++) {
				if (s.charAt(i) == baseNumbers[j]) { xNum = j; }
			}
			num += xNum * Math.pow(baseNumbers.length, s.length()-1-i);		// xNum * baseNumbers.length ^ letter pos in string (reversed)
		}
		
		return num;
	}
	
	public static int parseDecimalFromBinary(String s) { return parseDecimalFromBase(s, binaries); }
	public static int parseDecimalFromOctal(String s) { return parseDecimalFromBase(s, octals); }
	public static int parseDecimalFromHexadecimal(String s) { return parseDecimalFromBase(s.toUpperCase(), hexadecimals); }
	
	private static String parseBaseFromDecimal(String s, char[] baseNumbers) {
		int num = parseIntFromDecimal(s);	// parse number from input string
		if (num < 0) { return null; }		// if number is negative (parseIntFromDecimal() returned -1), return null
		String xStr = "";		// string that will hold the representation of the X number
		
		/*
		 * convert number to decimal number using these methods:
		 * 
		 * http://pedagogie.ac-limoges.fr/sti_si/accueil/FichesConnaissances/Sequence2SSi/co/ConvDecimalBinaire.html
		 * http://pedagogie.ac-limoges.fr/sti_si/accueil/FichesConnaissances/Sequence2SSi/co/ConvDecimalHexadecimal.html
		 */
		
		int q = num;
		
		while (q / baseNumbers.length != 0) {
			xStr = baseNumbers[q % baseNumbers.length] + xStr;
			q = q / baseNumbers.length;
		}
		
		xStr = baseNumbers[q % baseNumbers.length] + xStr;
		
		return xStr;
	}
	
	public static String parseBinaryFromDecimal(String s) { return parseBaseFromDecimal(s, binaries); }
	public static String parseOctalFromDecimal(String s) { return parseBaseFromDecimal(s, octals); }
	public static String parseHexadecimalFromDecimal(String s) { return parseBaseFromDecimal(s.toUpperCase(), hexadecimals); }
	
	public static void main(String[] args) {
		System.out.println("Test");
		for (int i = 0; i < 1024; i++) {
			System.out.println("i: "+parseDecimalFromBinary(parseBinaryFromDecimal(""+i)) + " | " + parseDecimalFromOctal(parseOctalFromDecimal(""+i)) + " | " + parseDecimalFromHexadecimal(parseHexadecimalFromDecimal(""+i)));
		}
	}
	
}
