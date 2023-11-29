package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

	private static final int MINIMUM_RANGE = 0;
	private static final int MAXIMUM_RANGE = 9;

	@Override
	public int generate() {
		return Randoms.pickNumberInRange(MINIMUM_RANGE, MAXIMUM_RANGE);
	}
}
