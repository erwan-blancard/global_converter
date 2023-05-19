
public abstract class FromData {
	
	protected String data;

	public FromData(String data) { this.data = data; }
	
	public abstract String toHexadecimal();
	public abstract String toOctal();
	public abstract String toDecimal();
	public abstract String toBinary();
	public abstract String toText();

}
