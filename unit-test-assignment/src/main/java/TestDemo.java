import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {

		int sum = 0;

		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		} else {
			sum = a + b;
			return sum;
		}

	}

	public int multiplyPositive(int a, int b) {

		int sum = 0;

		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		} else {
			sum = a * b;
			return sum;
		}
	}

	public int randomNumberSquared() {
		int result = getRandomInt();
		return result * result;
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

}
