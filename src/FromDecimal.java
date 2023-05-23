import java.util.ArrayList;

public class FromDecimal extends FromData {

	public FromDecimal(String data) {
		super(data);
	}

	@Override
	public String toHexadecimal() {
		/*
		 * put numbers in an ArrayList
		 */
		ArrayList<String> nums = splitNumbers();
		
		String result = "";
		
		/*
		 * convert decimal numbers to hex numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			String hexNum = StringUtils.parseHexadecimalFromDecimal(nums.get(i));
			if (hexNum == null) { return null; }
			result += hexNum + " ";
		}
		
		return result;
	}

	@Override
	public String toOctal() {
		/*
		 * put numbers in an ArrayList
		 */
		ArrayList<String> nums = splitNumbers();
		
		String result = "";
		
		/*
		 * convert decimal numbers to octal numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			String octNum = StringUtils.parseOctalFromDecimal(nums.get(i));
			if (octNum == null) { return null; }
			result += octNum + " ";
		}
		
		return result;
	}

	@Override
	public String toDecimal() {
		return this.data;
	}

	@Override
	public String toBinary() {
		/*
		 * put numbers in an ArrayList
		 */
		ArrayList<String> nums = splitNumbers();
		
		String result = "";
		
		/*
		 * convert decimal numbers to binary numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			String binNum = StringUtils.parseBinaryFromDecimal(nums.get(i));
			if (binNum == null) { return null; }
			result += binNum + " ";
		}
		
		return result;
	}

	@Override
	public String toText() {
		/*
		 * put numbers in an ArrayList
		 */
		ArrayList<String> nums = splitNumbers();
		
		String result = "";
		
		/*
		 * convert numbers to characters
		 */
		for (int i = 0; i < nums.size(); i++) {
			int num = StringUtils.parseIntFromDecimal(nums.get(i));
			if (StringUtils.isValidForChar(num)) {		// see StringUtils.isValidForChar()
				result += (char) num;
			} else {
				result += '█';
			}
		}
		
		return result;
	}

}
