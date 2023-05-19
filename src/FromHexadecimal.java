
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
		return null;
	}

	@Override
	public String toDecimal() {
		return null;
	}

	@Override
	public String toBinary() {
		return null;
	}

	@Override
	public String toText() {
		return null;
	}
	
}
