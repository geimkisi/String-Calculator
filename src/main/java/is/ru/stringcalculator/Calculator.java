package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == null || text.equals("")){
			return 0;
		}
		else if ('/' == text.charAt(0) && '/' == text.charAt(1)) {
			return sum(splitNumbersWithDelimiter(text));
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split("\n|,");
	}

	private static String[] splitNumbersWithDelimiter(String numbers){
		char delimeter = numbers.charAt(2);
		String onlyNumbers = numbers.substring(4);
		return onlyNumbers.split(delimeter + "|\n|,");
	}

	private static int sum(String[] numbers){
		int total = 0;
		for(String number : numbers){
			total += toInt(number);
		}
		return total;
	}
}