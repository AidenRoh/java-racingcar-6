package racingcar.utils;

import static racingcar.validation.UIValidator.validateEmptyName;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.RacingCarErrors;

public class Converter {

	public static List<String> StringtoStringList(String value) {
		List<String> convertedData = Arrays.stream(value.split(","))
				.toList();
		RacingCarErrors.EMPTY_NAME.findErrorBy(() -> validateEmptyName(convertedData));
		return convertedData;
	}
}
