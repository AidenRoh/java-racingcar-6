package racingcar.domain;

import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

public class Movement {

	private static final NumberGenerator randomNumber;
	private static final int CONDITION_NUMBER = 4;

	static {
		randomNumber = new RandomNumberGenerator();
	}

	public static boolean getForwardResult() {
		int number = randomNumber.generate();
		return movementCondition(number);
	}

	private static boolean movementCondition(int generatedNumber) {
		return generatedNumber >= CONDITION_NUMBER;
	}
}
