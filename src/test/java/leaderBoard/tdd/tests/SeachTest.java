package leaderBoard.tdd.tests;

import org.testng.annotations.Test;


import leaderBoard.tdd.base.BaseClass;

public class SeachTest extends BaseClass {
	
	@Test(enabled = true)
	public void searchByGameTest() {
		logPage.logInSteps(configuration.get("user"), configuration.get("password"));
		scoresPage.validateSearchByGame("Score List", "Horseshoes");
	}
	
	@Test(enabled = false)
	public void searchByUserTest() {
		logPage.logInSteps(configuration.get("user"), configuration.get("password"));
		scoresPage.validateSearchByUser("Score List", "qualityengineer");
	}
	
}
