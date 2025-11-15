package Asked;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomPasswordGenerator {

	
	public static String _UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String _LOWER = "abcdefghijklmnopqrstuvwxyz";
	public static String _DIGITS = "0123456789";
	public static String _SYMBOLS = "_@#$%^&*()<>:";
	
	public enum allParams {
		UPPER,
		LOWER,
		DIGITS,
		SYMBOLS
	};
	
	static Random rand = new Random();

	public static void main(String args[])
	{
		Set<allParams> p = new HashSet<>();
		p.add(allParams.LOWER);
		p.add(allParams.UPPER);
		p.add(allParams.DIGITS);
		p.add(allParams.SYMBOLS);

		System.out.println(passwordGenerator(5, p));
	}
	
	public static String passwordGenerator(int length, Set<allParams> params)
	{
		StringBuilder password = new StringBuilder();
		if(length < params.size() || length <= 0 || params.isEmpty())
		{
			return password.toString();
		}
		
		
		for(allParams p : params)
		{
			switch(p)
			{
			case UPPER:
			{
				password = password.append(getCharForCondition(allParams.UPPER, _UPPER));
				break;
			}
			case LOWER:
			{
				password = password.append(getCharForCondition(allParams.LOWER, _LOWER));
				break;
			}
			case DIGITS:
			{
				password = password.append(getCharForCondition(allParams.DIGITS, _DIGITS));
				break;
			}
			case SYMBOLS:
			{
				password = password.append(getCharForCondition(allParams.SYMBOLS, _SYMBOLS));
				break;
			}
			}
		}
		
		if(password.length() < length)
		{
			Object[] conditions = params.toArray();
			int diff = length - password.length();
			while(diff > 0)
			{
				int pos = rand.nextInt(params.size());
				allParams condition = (allParams)conditions[pos];
				String value = conditionToStringMap(condition);
				password.append(getCharForCondition(condition, value));
				diff--;
			}
		}
		
		/*
		//Additional shuffle logic not working
		char[] pwd = password.toString().toCharArray();
		List<Character> pwdList = Arrays.asList(pwd);
		Collections.shuffle(pwdList);
		*/
		
		return password.toString();
	}
	
	private static char getCharForCondition(allParams condition, String given)
	{
		char c = given.charAt(rand.nextInt(given.length()));
		return c;
	}
	
	private static String conditionToStringMap(allParams param)
	{
		if(param == allParams.UPPER)
		{
			return _UPPER;
		}
		else if(param == allParams.LOWER)
		{
			return _LOWER;
		} 
		else if(param == allParams.DIGITS)
		{
			return _DIGITS;
		}
		else
		{
			return _SYMBOLS;
		}
	}
}

///okta-ronud 1-nov 2025
/**
 * create a random password generator that takes in length of password and list of params like upper, lower, digits. The password should have at least one of each params passed.
 * Requirements

Input:

length: total password length

params: list of allowed character types (e.g., ["upper", "lower", "digits"])

Output:

Random password string of given length

Must contain at least one character from each selected type
*/


///Chat gpt solution
/*
import java.util.*;

public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+<>?";

    public static String generatePassword(int length, List<String> params) {
        if (length < params.size()) {
            throw new IllegalArgumentException("Length must be at least the number of character types chosen.");
        }

        StringBuilder allChars = new StringBuilder();
        List<Character> password = new ArrayList<>();
        Random random = new Random();

        // Step 1: Ensure at least one from each type
        for (String param : params) {
            switch (param.toLowerCase()) {
                case "upper":
                    password.add(UPPER.charAt(random.nextInt(UPPER.length())));
                    allChars.append(UPPER);
                    break;
                case "lower":
                    password.add(LOWER.charAt(random.nextInt(LOWER.length())));
                    allChars.append(LOWER);
                    break;
                case "digits":
                    password.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
                    allChars.append(DIGITS);
                    break;
                case "symbols":
                    password.add(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));
                    allChars.append(SYMBOLS);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid parameter: " + param);
            }
        }

        // Step 2: Fill remaining length with random characters from all selected sets
        while (password.size() < length) {
            password.add(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Step 3: Shuffle to randomize character positions
        Collections.shuffle(password);

        // Step 4: Build final password string
        StringBuilder result = new StringBuilder();
        for (char c : password) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage
        List<String> params = Arrays.asList("upper", "lower", "digits");
        String password = generatePassword(12, params);
        System.out.println("Generated password: " + password);
    }
}
*/
