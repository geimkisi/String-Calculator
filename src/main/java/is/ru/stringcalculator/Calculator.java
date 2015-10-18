package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == null || text.equals("")){
			return 0;
		}
		if(text.contains("-")){
			throwExceptionIfNegative(text);
		}
		else if ('/' == text.charAt(0) && '/' == text.charAt(1)) {
			return sum(splitNumbersWithDelimiter(text));
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split("\n|,");
	}

	// Monster.inc
	private static String[] splitNumbersWithDelimiter(String numbers){
		String delimeter = "";
		String onlyNumbers = "";
		if (numbers.contains("]")) {
			int numberOfDelimeters = 0;
			for(int i = 0; i < numbers.length(); i++){
				if(numbers.charAt(i) == ']'){
					numberOfDelimeters++;
				}
			}
			int i = 3;
			for(int j = 0; j < numberOfDelimeters; j++){
				for(; numbers.charAt(i) != ']'; i++){
					if(numbers.charAt(i) == '*'){
						delimeter = delimeter + "\\" + numbers.charAt(i);
					}
					else{
						delimeter = delimeter + numbers.charAt(i);
					}
				}
				delimeter = delimeter + "|";
				i = i + 2;
			}
		}
		else{
			delimeter = numbers.charAt(2) + "|";
		}

		onlyNumbers = numbers.substring(numbers.indexOf('\n')+1);
		return onlyNumbers.split( delimeter + "\n|,");
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

	private static void throwExceptionIfNegative(String text){
	String numbers = "Negatives not allowed: ";
	for(int i = 0; i < 1000; i++){
		if(text.contains("-" + i )){
			numbers = numbers + "-" + i + ",";
		}
	}
	numbers = numbers.substring(0, numbers.length() - 1);
	throw new NegativesNotAllowed(numbers);
	}
}



