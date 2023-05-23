import java.util.ArrayList;

public abstract class FromData {
	
	protected String data;

	public FromData(String data) { this.data = data; }
	
	public abstract String toHexadecimal();
	public abstract String toOctal();
	public abstract String toDecimal();
	public abstract String toBinary();
	public abstract String toText();
	
	protected ArrayList<String> splitNumbers() {
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
		
		return nums;
	}

}
