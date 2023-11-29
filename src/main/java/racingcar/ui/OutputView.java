package racingcar.ui;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.Result;

public final class OutputView extends ConsoleWriter {

	private static String MOVEMENT_FORMAT = "-";

	public void print(UIMessage uiMessage) {
		uiMessage.accept(this::println);
	}

	public void printExecutionResult(List<Result> results) {
		results.forEach(this::renderResult);
		this.lineSpace();
	}

	public void printFinalWinner(List<Result> winnerList) {
		String winner = winnerList.stream()
				.map(Result::name)
				.collect(Collectors.joining(", "));
		this.print(
				UIMessage.FINAL_WINNER.apply(text -> text.formatted(winner))
		);
	}

	private void renderResult(Result result) {
		this.printf(
				"%s : %s\n",
				result.name(),
				MOVEMENT_FORMAT.repeat(result.movement())
		);
	}
}
