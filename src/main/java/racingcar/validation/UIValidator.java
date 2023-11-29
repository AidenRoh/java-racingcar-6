package racingcar.validation;

import static racingcar.exception.RacingCarErrors.BAD_COMMA;
import static racingcar.exception.RacingCarErrors.BAD_NUMBER;
import static racingcar.exception.RacingCarErrors.EMPTY_VALUE;
import static racingcar.exception.RacingCarErrors.INVALID_NAME_FORMAT;
import static racingcar.exception.RacingCarErrors.NONE_NUMERIC;

import java.util.List;

public class UIValidator {

	public static void validateRegistry(String input) {
		EMPTY_VALUE.findErrorBy(() -> validateEmpty(input));
		INVALID_NAME_FORMAT.findErrorBy(() -> validateNameFormat(input));
		BAD_COMMA.findErrorBy(() -> validateBadComma(input));
	}

	public static void validateAttemptTimes(String input) {
		EMPTY_VALUE.findErrorBy(() -> validateEmpty(input));
		NONE_NUMERIC.findErrorBy(() -> validateNumericValue(input));
		BAD_NUMBER.findErrorBy(() -> validateBadNumber(input));
	}

	public static boolean validateEmptyName(List<String> convertedValue) {
		return 0 < (int) convertedValue.stream()
				.filter(String::isEmpty)
				.count();
	}

	private static boolean validateNumericValue(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException ignore) {
			return true;
		}
		return false;
	}

	private static boolean validateBadNumber(String input) {
		return Integer.parseInt(input) <= 0;
	}

	private static boolean validateNameFormat(String input) {
		String pattern = "^[가-힣a-zA-Z0-9,]*$";
		return !input.matches(pattern);
	}

	private static boolean validateBadComma(String input) {
		return input.charAt(0) == ',' || input.charAt(input.length() - 1) == ',';
	}

	private static boolean validateEmpty(String input) {
		return input.isEmpty();
	}
}
