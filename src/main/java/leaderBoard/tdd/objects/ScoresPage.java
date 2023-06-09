package leaderBoard.tdd.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import leaderBoard.tdd.actions.CommonActions;

public class ScoresPage {

	CommonActions actions;
	WebDriver driver;
	WebDriverWait wait; // wait

	public ScoresPage(WebDriver driver, WebDriverWait wait, CommonActions actions) {// wait
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
		this.actions = actions;

	}

	@FindBy(xpath = "//h1//span[text()='Score List']")
	WebElement pageTitleElement;

	@FindBy(css = "button.btn.btn-primary.ThemeGrid_MarginGutter")
	WebElement addScoreButtonElement;

	@FindBy(xpath = "//button[contains(@aria-label, 'is last page')]")
	WebElement lastPageElement;

	@FindBy(xpath = "//thead/tr/th[text()='Game']")
	WebElement gameSortButtonElement;

	@FindBy(xpath = "//thead/tr/th[text()='User']")
	WebElement userSortButtonElement;

	@FindBy(id = "Input_TextVar")
	WebElement searchFieldElement;

	private String verifyPageTitle() {
		String header = actions.getText(pageTitleElement);
		return header;
	}

	private void clickAddScore() {
		actions.click(addScoreButtonElement);

	}

	private void clickLastPage() {
		actions.click(lastPageElement);
	}

	private void clickGameSortButton() {
		actions.click(gameSortButtonElement);

	}

	private void clickUserSortButton() {
		actions.click(userSortButtonElement);

	}

	private void inputSearch(String search) {
		actions.inputValues(searchFieldElement, search);
	}

	public void addScoreStep(String expectedHeader) {
		if (verifyPageTitle().equals(expectedHeader)) {
			clickAddScore();
		} else {
			System.out.print("Page Tiltle is not: " + expectedHeader);

		}

	}

	public void sortingGames() {// wait
		clickGameSortButton();
		ArrayList<String> gameDataList = new ArrayList<>();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@data-header='Game' and //a]")));

		try {
			List<WebElement> elementList = driver.findElements(By.xpath(".//*[@data-header='Game' and //a]"));
			for (WebElement we : elementList) {
				gameDataList.add(we.getText());
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			Assert.fail();

		}

		ArrayList<String> sortedList = new ArrayList<>();
		for (String games : gameDataList) {
			sortedList.add(games);
		}
		Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println(gameDataList);
		Assert.assertTrue(sortedList.equals(gameDataList));

		clickGameSortButton();

		ArrayList<String> reverseGameList = new ArrayList<>();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@data-header='Game' and //a]")));
		try {
			List<WebElement> revelementList = driver.findElements(By.xpath(".//*[@data-header='Game' and //a]"));
			for (WebElement we2 : revelementList) {
				reverseGameList.add(we2.getText());
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			Assert.fail();

		}

		ArrayList<String> revSortedList = new ArrayList<>();
		for (String revGames : reverseGameList) {
			revSortedList.add(revGames);
		}
		Collections.sort(revSortedList, String.CASE_INSENSITIVE_ORDER);
		Collections.reverse(revSortedList);
		System.out.println(reverseGameList);
		Assert.assertTrue(revSortedList.equals(reverseGameList));

	}

	public void sortingUsers() {
		clickUserSortButton();
		ArrayList<String> userDataList = new ArrayList<>();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@data-header='User' and //span]")));
		try {
			List<WebElement> elementList = driver.findElements(By.xpath(".//*[@data-header='User' and //span]"));
			for (WebElement we : elementList) {
				userDataList.add(we.getText());
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			Assert.fail();
		}

		ArrayList<String> sortedList = new ArrayList<>();
		for (String users : userDataList) {
			sortedList.add(users);
		}
		Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println(userDataList);
		Assert.assertTrue(sortedList.equals(userDataList));

		clickUserSortButton();
		ArrayList<String> reverseUserList = new ArrayList<>();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@data-header='User' and //span]")));
		try {
			List<WebElement> elementList2 = driver.findElements(By.xpath(".//*[@data-header='User' and //span]"));
			for (WebElement we2 : elementList2) {
				reverseUserList.add(we2.getText());
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			Assert.fail();
		}

		ArrayList<String> revSortedList = new ArrayList<>();
		for (String revUsers : reverseUserList) {
			revSortedList.add(revUsers);
		}
		Collections.sort(revSortedList, String.CASE_INSENSITIVE_ORDER);
		Collections.reverse(revSortedList);
		System.out.println(reverseUserList);
		Assert.assertTrue(revSortedList.equals(reverseUserList));

	}

	public void verifyLastScoreEntry(String game, String score, String user) {
		clickLastPage();
		ArrayList<String> gameDataList = new ArrayList<>();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@data-header='Game' and //a]")));
		try {
			List<WebElement> elementList = driver.findElements(By.xpath(".//*[@data-header='Game' and //a]"));
			for (WebElement gd : elementList) {
				gameDataList.add(gd.getText());
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			Assert.fail();
		}

		ArrayList<String> scoreDataList = new ArrayList<>();
		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@data-header='Score' and //span]")));
		try {
			List<WebElement> elementList2 = driver.findElements(By.xpath(".//*[@data-header='Score' and //span]"));
			for (WebElement sd : elementList2) {
				scoreDataList.add(sd.getText());
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			Assert.fail();
		}

		ArrayList<String> userDataList = new ArrayList<>();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@data-header='User' and //span]")));
		try {
			List<WebElement> elementList3 = driver.findElements(By.xpath(".//*[@data-header='User' and //span]"));
			for (WebElement ud : elementList3) {
				userDataList.add(ud.getText());
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			Assert.fail();
		}

		String lastEntry1 = gameDataList.get(gameDataList.size() - 1);
		String lastEntry2 = scoreDataList.get(scoreDataList.size() - 1);
		String lastEntry3 = userDataList.get(userDataList.size() - 1);
		if (lastEntry1.equals(game) && lastEntry2.equals(score) && lastEntry3.equals(user)) {
			System.out.println(lastEntry1 + ", " + lastEntry2 + ", " + lastEntry3);
		} else {
			Assert.fail("Expected Score Entry not Equal with Actual Score found");
		}

	}

	public void validateSearchByGame(String header, String game) {
		if (verifyPageTitle().equals(header)) {
			inputSearch(game);
		}

		ArrayList<String> gameDataList = new ArrayList<>();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@data-header='Game' and //a]")));
		try {
			List<WebElement> elementList = driver.findElements(By.xpath(".//*[@data-header='Game' and //a]"));
			for (WebElement we : elementList) {
				gameDataList.add(we.getText());

			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			Assert.fail();
		}

		String search = gameDataList.get(0);
		System.out.println(search);

		if (search.equals(game)) {
			System.out.println("Search success");
		} else {
			Assert.fail("Failed Search");
		}

	}

	public void validateSearchByUser(String header, String user) {
		if (verifyPageTitle().equals(header)) {
			inputSearch(user);
		}

		ArrayList<String> gameDataList = new ArrayList<>();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@data-header='User' and //span]")));
		try {
			List<WebElement> elementList = driver.findElements(By.xpath(".//*[@data-header='User' and //span]"));
			for (WebElement we : elementList) {
				gameDataList.add(we.getText());

			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			Assert.fail();
		}

		String search = gameDataList.get(0);
		System.out.println(search);

		if (search.equals(user)) {
			System.out.println("Search success");
		} else {
			Assert.fail("Failed Search");
		}

	}

}
