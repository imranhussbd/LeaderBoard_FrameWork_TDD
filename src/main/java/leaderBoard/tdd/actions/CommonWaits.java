package leaderBoard.tdd.actions;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import leaderBoard.tdd.reporting.Loggers;



public class CommonWaits {
	
WebDriverWait wait;
	
	public CommonWaits(WebDriverWait wait) {
		this.wait = wait;
	}
	
	public void waitUntilClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Loggers.getLog("Waiting for the element to be clickable ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
	}

}
