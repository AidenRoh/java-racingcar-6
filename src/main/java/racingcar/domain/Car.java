package racingcar.domain;

import static racingcar.exception.RacingCarErrors.OVERSIZE_NAME;
import static racingcar.validation.DomainValidator.validateOversize;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.Result;

public class Car {

	private final String name;
	private final List<Boolean> movementAmount;

	public Car(String name) {
		OVERSIZE_NAME.findErrorBy(() -> validateOversize(name));
		this.name = name;
		this.movementAmount = new ArrayList<>();
	}

	public boolean attemptToGoForward() {
		boolean result = Movement.getForwardResult();
		return movementAmount.add(result);
	}

	public Result getResult() {
		String name = this.name;
		int movement = (int) movementAmount.stream()
				.filter(Boolean::booleanValue)
				.count();
		return new Result(name, movement);
	}
}
