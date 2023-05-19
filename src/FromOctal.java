
public class FromOctal extends FromData {

	public FromOctal(String data) {
		super(data);
	}

	@Override
	public String toHexadecimal() {
		return null;
	}

	@Override
	public String toOctal() {
		return this.data;
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
