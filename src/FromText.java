
public class FromText extends FromData {

	public FromText(String data) {
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
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			result += (short) data.charAt(i) + " ";		// cast char to short (2 bytes each)
		}
		return result;
	}

	@Override
	public String toBinary() {
		return null;
	}

	@Override
	public String toText() {
		return this.data;
	}
	
	

}
