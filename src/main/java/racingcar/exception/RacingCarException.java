package racingcar.exception;

public class RacingCarException extends IllegalArgumentException {
	RacingCarException(String errorMessage) {
		super(errorMessage);
	}
}
