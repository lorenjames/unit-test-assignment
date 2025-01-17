import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}

	}
	
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForMultiplyPositive")
	void assertThatTwoPositiveNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if (!expectException) { //asserts that the product of two positive numbers matches the expected value
			assertThat(testDemo.multiplyPositive(a, b)).isEqualTo(expected);
		} else { //else assert that an exception is thrown when one or both inputs are negative
			assertThatThrownBy(() -> testDemo.multiplyPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	public static Stream<Arguments> argumentsForAddPositive() {

		return Stream.of(

				arguments(2, 4, 6, false), arguments(1, 5, 6, false), arguments(5, 0, 5, false),
				arguments(0, 0, 0, false), arguments(-1, 5, 0, true), arguments(5, -1, 0, true)

		);
	}

	public static Stream<Arguments> argumentsForMultiplyPositive() {
		return Stream.of( //returns a stream of arguments containing test cases

				arguments(1, 1, 1, false), //tests that both numbers are positive and the result is true
				arguments(2, 5, 10, false), //tests that both numbers are positive and the result is true
				arguments(1, 0, 0, false), //one number is zero, result is zero
				arguments(-1, 5, 5, true) // tests with one number being negative which results in an expected exception

		);

	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreMultipliedCorrectly() {
		assertThat(testDemo.multiplyPositive(5, 0)).isEqualTo(0);
		assertThat(testDemo.multiplyPositive(1, 5)).isEqualTo(5);
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
	


}
