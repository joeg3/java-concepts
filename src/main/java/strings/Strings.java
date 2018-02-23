package strings;

public class Strings {
	
	/**
	 * This uses the compareTo() method which compares based on the Unicode values
	 * of characters, which is not always in order for human readers. For language 
	 * specific sorting rules, use Collator.
	 */
	public int useCompareTo(String str1, String str2) {
		return str1.compareTo(str2);
	}
	

}
