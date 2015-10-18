package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == null || text.equals("")){
			return 0;
		}
		if(text.contains("-")){
			String numbers = "Negatives not allowed: ";
			for(int i = 0; i < 1000; i++){
				if(text.contains("-" + i )){
					numbers = numbers + "-" + i + ",";
				}
			}
			numbers = numbers.substring(0, numbers.length() - 1);
			throw new NegativesNotAllowed(numbers);
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
			if(toInt(number) <= 1000){
				total += toInt(number);
			}
		}
		return total;
	}
}



