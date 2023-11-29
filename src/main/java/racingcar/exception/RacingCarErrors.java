package racingcar.exception;

import java.util.function.BooleanSupplier;

public enum RacingCarErrors {
	NONE_NUMERIC("숫자만 입력할 수 있습니다."),
	INVALID_NAME_FORMAT("이름은 한/영, 숫자만 가능합니다."),
	BAD_COMMA("처음과 마지막에 콤마를 사용할 수 없습니다."),
	EMPTY_VALUE("빈값이 들어올 수 없습니다."),
	OVERSIZE_NAME("이름은 5글자를 초과 할 수 없습니다."),
	EMPTY_NAME("이름이 없는 자동차가 있습니다."),
	BAD_NUMBER("0 이상의 숫자만 가능합니다");

	private final String message;

	RacingCarErrors(String message) {
		this.message = message;
	}

	public void findErrorBy(BooleanSupplier validator) {
		if (validator.getAsBoolean()) {
			throw new RacingCarException(this.message);
		}
	}
}
