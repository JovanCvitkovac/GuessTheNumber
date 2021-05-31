package paket;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestClass {

	GuessNumberGame guessNumberGame;

	@Before
	public void setup() {
		guessNumberGame = new GuessNumberGame();
		guessNumberGame.targetNumber = 22;
	}
	
	@Test
	public void should_not_allow_same_digits_in_target_number() {
		// given
		guessNumberGame.targetNumberChar1 = 1;
		guessNumberGame.targetNumberChar2 = 1;
		// when
		guessNumberGame.startUp();
		// then
		Assert.assertEquals(guessNumberGame.targetNumberChar2, 2);
	}

	@Test
	public void should_create_target_number_with_two_digits() {
		Assert.assertTrue(guessNumberGame.targetNumber > 9 && guessNumberGame.targetNumber < 100);
	}

	@Test
	public void should_throw_exception_if_user_input_not_a_number() {
		Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("y2");
		});

		String expectedMessage = "For input string";
		String actualMessage = exception.getMessage();

		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	public void if_input_is_same_as_target_number_display_appropriate_msg(){
		guessNumberGame.targetNumber = 15;
		guessNumberGame.input = 15;
		guessNumberGame.output();
		Assert.assertEquals(guessNumberGame.msg, "Correct guess, well done!");
	}
	@Test
	public void if_input_is_bigger_than_random_generated_number_scope_display_appropriate_msg(){
		guessNumberGame.input = 104; //max is 99
		guessNumberGame.output();
		Assert.assertEquals(guessNumberGame.msg, "Input value has to be numbers 10-99");
	}
	@Test
	public void if_input_is_smaller_than_random_generated_number_scope_display_appropriate_msg(){
		guessNumberGame.input = 4; //min is 10
		guessNumberGame.output();
		Assert.assertEquals(guessNumberGame.msg, "Input value has to be numbers 10-99");
	}
}

