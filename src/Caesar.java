public class Caesar {

	public static String encrypt(String input, String key) {
		String out = "";
		int offset = StringUtils.parseIntFromDecimal(key);
		if (offset < 0) { return null; }
		offset %= (StringUtils.MAX_CHAR_VAL - StringUtils.MIN_CHAR_VAL);
		
		for (int i = 0; i < input.length(); i++) {
			short cVal = (short) input.charAt(i);
			if (cVal + offset > StringUtils.MAX_CHAR_VAL) {
				cVal += offset - (StringUtils.MAX_CHAR_VAL - StringUtils.MIN_CHAR_VAL);
			} else {
				cVal += offset;
			}
			out += (char) cVal;
		}
		
		return out;
	}

	public static String decrypt(String input, String key) {
		String out = "";
		int offset = StringUtils.parseIntFromDecimal(key);
		if (offset < 0) { return null; }
		offset %= (StringUtils.MAX_CHAR_VAL - StringUtils.MIN_CHAR_VAL);
		
		for (int i = 0; i < input.length(); i++) {
			short cVal = (short) input.charAt(i);
			if (cVal - offset < StringUtils.MIN_CHAR_VAL) {
				cVal = (short) (cVal - offset + (StringUtils.MAX_CHAR_VAL - StringUtils.MIN_CHAR_VAL));
			} else {
				cVal -= offset;
			}
			out += (char) cVal;
		}
		
		return out;
	}

}
