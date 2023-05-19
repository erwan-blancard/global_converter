
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
		return null;
	}

	@Override
	public String toBinary() {
		return this.data;
	}

	@Override
	public String toText() {
		return null;
	}

}
