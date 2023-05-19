import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GlobalConverter {
	
	public static String[] arguments = null;
	final String[] commands = { "hexadecimal", "octal", "decimal", "binary", "text" };
	final String[] prefixes = { "0x", "0o", "0d", "0b", "0t" };
	private Scanner sc;
	
	final String[] helpLines = {
			"\nList of commands:\n",
			"\t-h\thexadecimal\tConverts the entered data to a hexadecimal based number.",
			"\t-o\toctal\t\tConverts the entered data to an octal based number.",
			"\t-d\tdecimal\t\tConverts the entered data to a decimal based number.",
			"\t-b\tbinary\t\tConverts the entered data to binary.",
			"\t-t\ttext\t\tConverts the entered data to a string.",
			"\t-help\t--help\t\tShows this list.",
			"\nData Formatting:\n",
			"\tHexadecimal based numbers must start with \"0x\".",
			"\tOctal based numbers must start with \"0o\".",
			"\tBinary numbers must start with \"0b\".",
			"\n\tDecimal numbers and Text can be entered as plain text or inside quotation marks: \"Hello world\", \"0123456789\".",
			"\tFor these 2 types, you can also specify the data type by having \"0d\" or \"0t\" as the prefix for Decimal numbers and Text respectively.\n"
	};
	
	public GlobalConverter(String[] args) {
		arguments = args;
		checkArgs();
	}
	
	public void checkArgs() {
		if (arguments != null && arguments.length >= 1) {
			/*
			for (int i = 0; i < arguments.length; i++) {
				System.out.println(i + " " + arguments[i]);
			}
			*/
			
			if (arguments.length > 2) {
				reaskInput("Too much arguments.");
			} else {
				
				// search for command match
				String cmd = arguments[0];
				
				if (arguments.length == 1) {
					if (cmd.equals("-help") || cmd.equals("--help")) {
						showHelp();
						System.exit(0);
					} else {
						reaskInput("Too few arguments.");
					}
				}
				
				int dataFrom = -1;
				int dataTo = -1;
				
				for (int i = 0; i < commands.length; i++) {
					/*
					 * if the command entered matches with the command list,
					 * set dataTo to the index of the command.
					 */
					if (cmd.equals(commands[i]) || cmd.equals("-"+commands[i].charAt(0))) {
						dataTo = i;
						break;
					}
				}
				
				/*
				 * Try to determine datatype with prefix
				 */
				for (int i = 0; i < prefixes.length; i++) {
					if (arguments[1].startsWith(prefixes[i])) {
						dataFrom = i;
						arguments[1] = arguments[1].substring(prefixes[i].length());	// remove the prefix
						break;
					}
				}
				
				/*
				 * If no prefix matches, datatype is either Decimal or Text
				 */
				if (dataFrom == -1) {
					dataFrom = 4;	// set to "text"
					if (StringUtils.isDecimal(arguments[1])) {
						dataFrom = 2;	// set to "decimal"
					}
				}
				
				//System.out.println("dataFrom: " + dataFrom + " dataTo: " + dataTo);
				
				if (dataTo == -1) {
					reaskInput("Invalid command \"" + cmd + "\".");		// if no command matches with cmd
				} else {
					convert(dataFrom, dataTo, arguments[1]);
				}
				
			}
			
		} else {
			reaskInput("Invalid Arguments.");
		}
	}
	
	public void showHelp() {
		for (String line : helpLines) { System.out.println(line); }
	}
	
	public void convert(int dataFrom, int dataTo, String data) {
		/*
		 * Creates a string representing the name of the Class that will be used to convert data
		 * 
		 * Possible results (based off commands):
		 * - FromHexadecimal
		 * - FromOctal
		 * - FromDecimal
		 * - FromBinary
		 * - FromText
		 */
		String className = "From"+commands[dataFrom].replaceFirst(commands[dataFrom].substring(0, 1), commands[dataFrom].substring(0, 1).toUpperCase());
		/*
		 * Creates a string representing the name of the method that will be invoked to convert data
		 * 
		 * Possible results (based off commands):
		 * - toHexadecimal
		 * - toOctal
		 * - toDecimal
		 * - toBinary
		 * - toText
		 */
		String methodName = "to"+commands[dataTo].replaceFirst(commands[dataTo].substring(0, 1), commands[dataTo].substring(0, 1).toUpperCase());
		
		/*
		 * Uses the Reflection API to invoke methods and classes to use from Strings (className + methodName)
		 */
		
		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?> ctor = clazz.getConstructor(String.class);
			FromData object = (FromData) ctor.newInstance(new Object[] {data});
			
			Method method = object.getClass().getMethod(methodName);
			String result = (String) method.invoke(object);
			
			if (result == null) {
				reaskInput("Error when converting from "+commands[dataFrom] + " to " + commands[dataTo]+" with \""+data+"\".");
			} else {
				System.out.println(result);		// prints the result of the conversion
				System.exit(0);
			}
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			reaskInput("Could not convert data from " + commands[dataFrom] + " to " + commands[dataTo]+".");
		}
	}
	
	public void reaskInput(String message) {
		System.out.println(message + " Please retry:");
		
		/*
		 * Read input using System.console(). If System.console() is null, use Scanner instead
		 */
		if (System.console() != null) {
			arguments = formatArgs(System.console().readLine());
		} else {
			if (sc == null) { sc = new Scanner(System.in); }
			String input = sc.nextLine();
			arguments = formatArgs(input);
		}
 
		checkArgs();
	}
	
	public String[] formatArgs(String input) {
		ArrayList<String> args = new ArrayList<String>();
		
		int startCharIndex = 0;
		boolean insideString = false;
		for (int i = 0; i < input.length(); i++) {
			if (i >= startCharIndex) {
				if (input.charAt(i) == ' ' && !insideString) {
					args.add(input.substring(startCharIndex, i).trim());
					startCharIndex = i+1;
				} else if (input.charAt(i) == '\"') {	// "String" user input
					if (insideString) {
						/*
						 * If the following char after '\"' is not a space (when insideString is true),
						 * returns a null list (invalid)
						 * Ex :
						 * "Hello world" k <--- VALID
						 * "Hello world"k <--- INVALID
						 */
						if (i != input.length()-1 && input.charAt(i+1) != ' ') { return null; }
						
						insideString = false;
						args.add(input.substring(startCharIndex+1, i));
						startCharIndex = i+1;
					} else {
						insideString = true;
						startCharIndex = i;
					}
				} else if (i == input.length()-1) {
					if (insideString) {		// if string input is not completed (last char cannot be '\"')
						return null;
					} else {
						args.add(input.substring(startCharIndex).trim());
					}
				}
			}
		}
		
		if (args.size() == 0) { return null; }	// if no arguments are in the list, returns a null list
		
		String[] formattedArgs = new String[args.size()];
		for (int i = 0; i < args.size(); i++) { formattedArgs[i] = args.get(i); }	// converts the ArrayList to an array of Strings
		
		return formattedArgs;
	}

	public static void main(String[] args) {
		new GlobalConverter(args);
	}

}
