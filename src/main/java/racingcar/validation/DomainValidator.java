package racingcar.validation;

public class DomainValidator {

	public static boolean validateOversize(String value) {
		return value.length() >= 5;
	}
}
