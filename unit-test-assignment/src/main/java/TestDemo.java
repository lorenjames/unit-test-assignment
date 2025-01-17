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

		int sum = 0; //initialize the variable "sum" to hold the product

		if (a < 0 || b < 0) { //check if either of the inputs is negative
			throw new IllegalArgumentException("Both parameters must be positive!"); //throw an exception if either of the inputs are negative
		} else {
			sum = a * b; //calculate and return the product of the two given integers
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
