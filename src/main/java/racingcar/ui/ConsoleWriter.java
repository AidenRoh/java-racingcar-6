package racingcar.ui;

public sealed class ConsoleWriter permits InputView, OutputView {

	protected void print(final Object data) {
		System.out.print(data);
	}

	protected void println(final Object data) {
		System.out.println(data);
	}

	protected void lineSpace() {
		this.print(System.lineSeparator());
	}

	protected void printf(final String format, final Object... data) {
		System.out.printf(format, data);
	}
}
