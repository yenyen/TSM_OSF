package ch.heigvd.skeleton.util;

/**
 * This is a simple utility class that we use to generate test data.
 * 
 * @author Olivier Liechti
 */
public class TestDataGenerator {
	
	private final String[] firstNames = {"John", "Peter", "Catherine", "Paula", "Eric", "Sacha", "Carmen", "Nicole", "Nicolas"};
	private final String[] lastNames = {"Smith", "Doe", "Dupond", "Dupont", "Mercier", "Mueller", "Brown"};
	
	private String getRandomString(String[] values) {
		int i = (int)(Math.random() * values.length);
		return values[i];
	}
	
	public String getRandomFirstName() {
		return getRandomString(firstNames);
	}
	
	public String getRandomLastName() {
		return getRandomString(lastNames);
	}
	
	public long getRandomLong(long min, long max) {
		long val = (long)(Math.random() * (max-min));
		return min + val;
	}

}
