public class StringUtils {
	
	static final char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	public static boolean isNumeric(String s) {
		
		for (int i = 0; i < s.length(); i++) {
			boolean match = false;
			for(int j = 0; j < numbers.length; j++) {
				if (s.charAt(i) == numbers[j]) {
					match = true;
					break;
				}
			}
			if (!match) { return false; }
		}
		
		return true;
		
	}
	
}
