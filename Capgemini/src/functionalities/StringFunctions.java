package functionalities;

public class StringFunctions {

	public static void main(String[] args) {
		String str = null;
		str = "pranab";
		System.out.println(str.length());
		System.out.println(str.substring(1, 3));
		System.out.println(str.indexOf('a'));
		System.out.println(str.charAt(2));
		System.out.println(str.compareTo("Das"));
		System.out.println(str.concat(" Das"));
		System.out.println(str.contains("ra"));
		System.out.println(str.contains("ar"));
		System.out.println(str.endsWith("ab"));
		System.out.println(str.indexOf('a', 3));
		System.out.println(str.toCharArray());
		System.out.println(str.equals("pranab"));
		System.out.println(str.equalsIgnoreCase("PRANAB"));
		System.out.println(str.hashCode());
		System.out.println(str.lastIndexOf('a'));
		System.out.println(str.replace('a', '_'));
		System.out.println(str.startsWith("pr"));
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		System.out.println(str.trim());

	}

}
