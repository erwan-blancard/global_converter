
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
		return null;
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
