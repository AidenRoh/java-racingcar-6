package racingcar.domain;

import java.util.List;
import racingcar.dto.Result;

public class Cars {

	private final List<Car> cars;

	public Cars(List<String> carNames) {
		this.cars = generateCar(carNames);
	}

	public void groupAttempt() {

		cars.forEach(Car::attemptToGoForward);

//		IntStream.range(0, attemptTimes)
//				.forEach(i -> {
//					cars.forEach(Car::attemptToGoForward);
//				});

//		IntStream.range(0, attemptTimes)
//				.<Consumer<? super Car>>mapToObj(index -> Car::attemptToGoForward)
//				.forEach(cars::forEach);
	}

	public List<Result> getGroupResult() {
		return cars.stream()
				.map(Car::getResult)
				.toList();
	}

	public List<Result> findWinner() {
		List<Result> results = getGroupResult();
		int winnerMovement = findWinnerMovement(results);
		return results.stream()
				.filter(result -> result.movement() == winnerMovement)
				.toList();
	}

	private int findWinnerMovement(List<Result> results) {
		return results.stream()
				.mapToInt(Result::movement)
				.max()
				.getAsInt();
	}

	private List<Car> generateCar(List<String> carNames) {
		return carNames.stream()
				.map(Car::new)
				.toList();
	}
}
