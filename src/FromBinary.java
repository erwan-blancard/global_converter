import java.util.ArrayList;

public class FromBinary extends FromData {

	public FromBinary(String data) {
		super(data);
	}

	@Override
	public String toHexadecimal() {
		return null;
	}

	@Override
	public String toOctal() {
		return null;
	}

	@Override
	public String toDecimal() {
		/*
		 * put numbers in an ArrayList
		 */
		ArrayList<String> nums = new ArrayList<String>();
		
		int startCharIndex = 0;
		for (int i = 0; i < data.length(); i++) {
			if (i >= startCharIndex) {
				if (data.charAt(i) == ' ') {
					nums.add(data.substring(startCharIndex, i).trim());
					startCharIndex = i+1;
				} else if (i == data.length()-1) {
					nums.add(data.substring(startCharIndex).trim());
				}
			}
		}
		
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
		ArrayList<String> nums = new ArrayList<String>();
		
		int startCharIndex = 0;
		for (int i = 0; i < data.length(); i++) {
			if (i >= startCharIndex) {
				if (data.charAt(i) == ' ') {
					nums.add(data.substring(startCharIndex, i).trim());
					startCharIndex = i+1;
				} else if (i == data.length()-1) {
					nums.add(data.substring(startCharIndex).trim());
				}
			}
		}
		
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
