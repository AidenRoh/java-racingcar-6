package racingcar.controller;

import static racingcar.utils.ValidValueReceiver.receiveValidValue;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.dto.Result;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.ui.UIMessage;
import racingcar.utils.Converter;

public class RacingCarController {

	private final InputView inputView;
	private final OutputView outputView;

	public RacingCarController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void play() {

		Cars cars = receiveValidValue(this::getCarList, Cars::new);
		int attemptAmount = receiveValidValue(inputView::inputAttemptAmount, Integer::parseInt);

		outputView.print(UIMessage.EXECUTION_RESULT);
		attemptGames(cars, attemptAmount);
		List<Result> winners = cars.findWinner();

		outputView.printFinalWinner(winners);
	}

	private List<String> getCarList() {
		return receiveValidValue(inputView::inputRegisterCar, Converter::StringtoStringList);
	}

	private void attemptGames(Cars cars, int attemptTimes) {
		for (int i = 0; i < attemptTimes; i++) {
			cars.groupAttempt();
			outputView.printExecutionResult(cars.getGroupResult());
		}
	}
}
