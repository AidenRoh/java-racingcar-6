package racingcar.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.function.Consumer;
import racingcar.validation.UIValidator;

public final class InputView extends ConsoleWriter {

	public String inputRegisterCar() {
		UIMessage.REGISTER_CAR.accept(this::println);
		return validateInput(UIValidator::validateRegistry);
	}

	public String inputAttemptAmount() {
		UIMessage.ATTEMPT_TIME.accept(this::println);
		return validateInput(UIValidator::validateAttemptTimes);
	}

	private String validateInput(Consumer<String> validate) {
		String input = readLine();
		validate.accept(input);
		return input;
	}
}
