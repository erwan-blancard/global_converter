import java.util.ArrayList;

public class FromDecimal extends FromData {

	public FromDecimal(String data) {
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
		return this.data;
	}

	@Override
	public String toBinary() {
		return null;
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
		 * convert numbers to characters
		 */
		for (int i = 0; i < nums.size(); i++) {
			int num = StringUtils.parseIntFromDecimal(nums.get(i));
			if (num >= (short) ' ' && num <= (short) '~') {		// is character valid (between ' ' and '~' in ascii table)
				result += (char) num;
			} else {
				result += '█';
			}
		}
		
		return result;
	}

}
