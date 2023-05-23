import java.util.ArrayList;

public class FromBinary extends FromData {

	public FromBinary(String data) {
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
		 * convert binary numbers to hex numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			String num = StringUtils.parseHexadecimalFromDecimal(""+StringUtils.parseDecimalFromBinary(nums.get(i)));
			if (num == null) { return null; }
			result += num + " ";
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
		 * convert binary numbers to octal numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			String num = StringUtils.parseOctalFromDecimal(""+StringUtils.parseDecimalFromBinary(nums.get(i)));
			if (num == null) { return null; }
			result += num + " ";
		}
		
		return result;
	}

	@Override
	public String toDecimal() {
		/*
		 * put numbers in an ArrayList
		 */
		ArrayList<String> nums = splitNumbers();
		
		String result = "";
		
		/*
		 * convert binary numbers to decimal numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			int num = StringUtils.parseDecimalFromBinary(nums.get(i));
			if (num == -1) { return null; }
			result += num + " ";
		}
		
		return result;
	}

	@Override
	public String toBinary() {
		return this.data;
	}

	@Override
	public String toText() {
		/*
		 * put numbers in an ArrayList
		 */
		ArrayList<String> nums = splitNumbers();
		
		String result = "";
		
		/*
		 * convert binary numbers to characters
		 */
		for (int i = 0; i < nums.size(); i++) {
			int num = StringUtils.parseDecimalFromBinary(nums.get(i));
			if (num < 0) { return null; }			// return null if num isn't a binary number (parseDecimalFromBinary() returned -1)
			
			if (StringUtils.isValidForChar(num)) {		// see StringUtils.isValidForChar()
				result += (char) num;
			} else {
				result += '█';
			}
		}
		
		return result;
	}

}
