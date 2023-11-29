package racingcar.ui;

import java.util.function.Consumer;
import java.util.function.Function;

public enum UIMessage {
	REGISTER_CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"),
	ATTEMPT_TIME("시도할 회수는 몇회인가요?"),
	EXECUTION_RESULT("실행 결과"),
	FINAL_WINNER("최종 우승자 : %s");

	private final String message;

	UIMessage(String message) {
		this.message = message;
	}

	public void accept(Consumer<String> consumer) {
		consumer.accept(this.message);
	}

	public String apply(Function<String, String> function) {
		return function.apply(this.message);
	}
}
