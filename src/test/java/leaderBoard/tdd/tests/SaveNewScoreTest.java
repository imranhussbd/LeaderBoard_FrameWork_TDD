package leaderBoard.tdd.tests;

import org.testng.annotations.Test;

import leaderBoard.tdd.base.BaseClass;

public class SaveNewScoreTest extends BaseClass {

	@Test(enabled = true)
	public void savingAscoreValidEntry() {
		logPage.logInSteps(configuration.get("user"), configuration.get("password"));
		scoresPage.addScoreStep("Score List");
		createPage.enterNewScoreValidEntry("New Score", "Hearts", "125", "qualityengineer");
		scoresPage.verifyLastScoreEntry("Hearts", "125", "qualityengineer");

	}

	@Test(enabled = false)
	public void savingAscoreEmptyFields() {
		logPage.logInSteps(configuration.get("user"), configuration.get("password"));
		scoresPage.addScoreStep("Score List");
		createPage.enterNewScoreWithEmptyFields("New Score", "qualityengineer",
				"Navigate to another screen or implement the required logic.", "This field is required.",
				"This field is required.");
		
		}
	
	@Test(enabled = false)
	public void savingAscoreOneEmptyField() {
		logPage.logInSteps(configuration.get("user"), configuration.get("password"));
		scoresPage.addScoreStep("Score List");
		createPage.enterNewScoreWithOneEmptyField("New Score", "qualityengineer", "Doom", "1250", "Navigate to another screen or implement the required logic.", "This field is required.", "This field is required.");
		
	}
	
	
	@Test(enabled = false)
	public void savingAscoreWithWrongData() {
		logPage.logInSteps(configuration.get("user"), configuration.get("password"));
		scoresPage.addScoreStep("Score List");
		createPage.enterNewScoreWithWrongData("New Score", "qualityengineer", "Doom", "Ten", "Navigate to another screen or implement the required logic.", "Enter a valid integer.");
		
	}
	

}
