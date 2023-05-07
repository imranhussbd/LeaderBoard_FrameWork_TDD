package leaderBoard.tdd.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import leaderBoard.tdd.actions.CommonActions;

public class CreateScorePage {

	CommonActions actions;

	public CreateScorePage(WebDriver driver, CommonActions actions) {
		PageFactory.initElements(driver, this);
		this.actions = actions;
	}

	@FindBy(xpath = "//h1[text()='New Score']")
	WebElement headerElement;

	@FindBy(id = "Input_Game")
	WebElement inputGameElement;

	@FindBy(id = "Input_Score")
	WebElement inputScoreElement;

	@FindBy(css = "select.dropdown-display.dropdown")
	WebElement userSelectElement;

	@FindBy(css = "button.btn.btn-primary.ThemeGrid_MarginGutter")
	WebElement saveButtonElement;

	@FindBy(id = "feedbackMessageContainer")
	WebElement popUpMsgElement;

	@FindBy(xpath = "(//span[text()='This field is required.'])[1]")
	WebElement gameFieldMsgElement;

	@FindBy(xpath = "(//span[text()='This field is required.'])[2]")
	WebElement scoreFieldMsgElement;

	@FindBy(xpath = "//span[text()='Enter a valid integer.']")
	WebElement scoreFieldMsg2Element;

	private String verifyPageTitle() {
		String header = actions.getText(headerElement);
		return header;
	}

	private void inputGame(String game) {
		actions.inputValues(inputGameElement, game);
	}

	private void inputScore(String score) {
		actions.inputValues(inputScoreElement, score);
	}

	private void selectUser(String user) {
		actions.selectDropdown(userSelectElement, user);
	}

	private void clickSave() {
		actions.click(saveButtonElement);
	}

	private void verifyPopUpMsg(String expectedPopMsg) {
		assertEquals(actions.getText(popUpMsgElement), expectedPopMsg);
	}

	private void verifyGameFieldErrorMsg(String expectedMsg) {
		assertEquals(actions.getText(gameFieldMsgElement), expectedMsg);
	}

	private void verifyScoreFieldErrorMsg(String expectedMsg1) {
		assertEquals(actions.getText(scoreFieldMsgElement), expectedMsg1);
	}

	private void verifyScoreFieldInvalidIntegerMsg2(String expectedMsg2) {
		assertEquals(actions.getText(scoreFieldMsg2Element), expectedMsg2);
	}

	private void clearGame() {
		actions.clear(inputGameElement);
	}

	private void clearScore() {
		actions.clear(inputScoreElement);
	}

	public void enterNewScoreValidEntry(String expectedTitle, String game, String score, String user) {
		if (verifyPageTitle().equals(expectedTitle)) {
			inputGame(game);
			inputScore(score);
			selectUser(user);
			clickSave();
		}
	}

	public void enterNewScoreWithEmptyFields(String expectedTitle, String user, String expectedPopMsg,
			String expectedMsg, String expectedMsg1) {
		if (verifyPageTitle().equals(expectedTitle)) {
			selectUser(user);
			clickSave();
			verifyPopUpMsg(expectedPopMsg);
			verifyGameFieldErrorMsg(expectedMsg);
			verifyScoreFieldErrorMsg(expectedMsg1);

		}
	}

	public void enterNewScoreWithOneEmptyField(String expectedTitle, String user, String game, String score, String expectedPopMsg, String expectedMsg, String expectedMsg1) {
		if (verifyPageTitle().equals(expectedTitle)) {
			selectUser(user);
			inputGame(game);
			clickSave();
			verifyPopUpMsg(expectedPopMsg);
			verifyScoreFieldErrorMsg(expectedMsg1);
			clickSave();
			clearGame();
			inputScore(score);
			clickSave();
			verifyPopUpMsg(expectedPopMsg);
			verifyGameFieldErrorMsg(expectedMsg);
			clearScore();

		}

	}
	
	public void enterNewScoreWithWrongData(String expectedTitle, String text, String game, String wordScore, String expectedPopMsg, String expectedMsg2) {
		if (verifyPageTitle().equals(expectedTitle)) {
			selectUser(text);
			inputGame(game);
			inputScore(wordScore);
			clickSave();
			verifyPopUpMsg(expectedPopMsg);
			verifyScoreFieldInvalidIntegerMsg2(expectedMsg2);

		}
	}

}
