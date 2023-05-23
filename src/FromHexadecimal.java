import java.util.ArrayList;

public class FromHexadecimal extends FromData {

	public FromHexadecimal(String data) {
		super(data);
	}

	@Override
	public String toHexadecimal() {
		return this.data;
	}

	@Override
	public String toOctal() {
		/*
		 * put numbers in an ArrayList
		 */
		ArrayList<String> nums = splitNumbers();
		
		String result = "";
		
		/*
		 * convert hex numbers to octal numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			String num = StringUtils.parseOctalFromDecimal(""+StringUtils.parseDecimalFromHexadecimal(nums.get(i)));
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
		 * convert hex numbers to decimal numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			int num = StringUtils.parseDecimalFromHexadecimal(nums.get(i));
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
		 * convert hex numbers to binary numbers
		 */
		for (int i = 0; i < nums.size(); i++) {
			String num = StringUtils.parseBinaryFromDecimal(""+StringUtils.parseDecimalFromHexadecimal(nums.get(i)));
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
		 * convert hex numbers to characters
		 */
		for (int i = 0; i < nums.size(); i++) {
			int num = StringUtils.parseDecimalFromHexadecimal(nums.get(i));
			if (num < 0) { return null; }			// return null if num isn't a hex number (parseDecimalFromHexadecimal() returned -1)
			
			if (StringUtils.isValidForChar(num)) {		// see StringUtils.isValidForChar()
				result += (char) num;
			} else {
				result += '█';
			}
		}
		
		return result;
	}
	
}
