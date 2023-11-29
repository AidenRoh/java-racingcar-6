package racingcar.utils;

import java.util.function.Function;
import java.util.function.Supplier;

public class ValidValueReceiver {

	public static <T, R> R receiveValidValue(Supplier<T> supplier, Function<T, R> convertor) {
		while (true) {
			try {
				T input = supplier.get();
				return convertor.apply(input);
			} catch (Exception error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
