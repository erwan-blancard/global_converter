import java.util.ArrayList;

public class FromOctal extends FromData {

	public FromOctal(String data) {
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
		 * convert octal numbers to hex numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			String num = StringUtils.parseHexadecimalFromDecimal(""+StringUtils.parseDecimalFromOctal(nums.get(i)));
			if (num == null) { return null; }
			result += num + " ";
		}
		
		return result;
	}

	@Override
	public String toOctal() {
		return this.data;
	}

	@Override
	public String toDecimal() {
		/*
		 * put numbers in an ArrayList
		 */
		ArrayList<String> nums = splitNumbers();
		
		String result = "";
		
		/*
		 * convert octal numbers to decimal numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			int num = StringUtils.parseDecimalFromOctal(nums.get(i));
			if (num == -1) { return null; }
			result += num + " ";
		}
		
		return result;
	}

	@Override
	public String toBinary() {
		/*
		 * put numbers in an ArrayList
		 */
		ArrayList<String> nums = splitNumbers();
		
		String result = "";
		
		/*
		 * convert octal numbers to binary numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			String num = StringUtils.parseBinaryFromDecimal(""+StringUtils.parseDecimalFromOctal(nums.get(i)));
			if (num == null) { return null; }
			result += num + " ";
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
		 * convert octal numbers to characters
		 */
		for (int i = 0; i < nums.size(); i++) {
			int num = StringUtils.parseDecimalFromOctal(nums.get(i));
			if (num < 0) { return null; }			// return null if num isn't an octal number (parseDecimalFromOctal() returned -1)
			
			if (StringUtils.isValidForChar(num)) {		// see StringUtils.isValidForChar()
				result += (char) num;
			} else {
				result += '█';
			}
		}
		
		return result;
	}

}
