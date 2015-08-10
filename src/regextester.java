import java.util.regex.Pattern;

public class regextester {

	public static void main(String[]args) {
		String slang = "slang";
		String pattern = "s...g";
		boolean matches = Pattern.matches(pattern, slang);
		System.out.println("matches = " + matches);
	}
}
