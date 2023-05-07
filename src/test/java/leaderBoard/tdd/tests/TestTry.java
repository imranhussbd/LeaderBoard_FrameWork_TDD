package leaderBoard.tdd.tests;

import org.testng.annotations.Test;

import leaderBoard.tdd.base.BaseClass;

public class TestTry extends BaseClass {
	
	@Test
	public void logTest() throws InterruptedException {
		logPage.logInSteps(configuration.get("user"), configuration.get("password"));
		scoresPage.verifyLastScoreEntry("Gems", "100", "qualityengineer");
		Thread.sleep(1000);
	}

}
