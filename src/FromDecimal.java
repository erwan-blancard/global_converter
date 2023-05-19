
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
		return null;
	}

}
