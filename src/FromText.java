
public class FromText extends FromData {

	public FromText(String data) {
		super(data);
	}

	@Override
	public String toHexadecimal() {
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			String hexNum = StringUtils.parseHexadecimalFromDecimal(""+(short) data.charAt(i));		// cast char to short (2 bytes each) and parse it to hex
			if (hexNum == null) { return null; }
			result += hexNum + " ";
		}
		return result;
	}

	@Override
	public String toOctal() {
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			String octNum = StringUtils.parseOctalFromDecimal(""+(short) data.charAt(i));		// cast char to short (2 bytes each) and parse it to octal
			if (octNum == null) { return null; }
			result += octNum + " ";
		}
		return result;
	}

	@Override
	public String toDecimal() {
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			result += (short) data.charAt(i) + " ";		// cast char to short (2 bytes each)
		}
		return result;
	}

	@Override
	public String toBinary() {
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			String binNum = StringUtils.parseBinaryFromDecimal(""+(short) data.charAt(i));		// cast char to short (2 bytes each) and parse it to binary
			if (binNum == null) { return null; }
			result += binNum + " ";
		}
		return result;
	}

	@Override
	public String toText() {
		return this.data;
	}
	
	

}
