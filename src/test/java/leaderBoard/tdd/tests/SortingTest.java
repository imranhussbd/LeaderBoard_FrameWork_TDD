package leaderBoard.tdd.tests;

import org.testng.annotations.Test;

import leaderBoard.tdd.base.BaseClass;

public class SortingTest extends BaseClass {

	@Test(enabled = true)
	public void sortingByGames() {
		logPage.logInSteps(configuration.get("user"), configuration.get("password"));
		scoresPage.sortingGames();
	
		
	}
	
	@Test(enabled = false)
	public void sortingByUsers() {
		logPage.logInSteps(configuration.get("user"), configuration.get("password"));
		scoresPage.sortingUsers();
		
	}
		
	

}
