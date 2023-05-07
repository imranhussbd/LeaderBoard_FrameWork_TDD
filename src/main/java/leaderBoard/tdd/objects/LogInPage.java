package leaderBoard.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import leaderBoard.tdd.actions.CommonActions;

public class LogInPage {
	
	CommonActions actions;


	public LogInPage(WebDriver driver, CommonActions actions) {
		PageFactory.initElements(driver, this);
		this.actions = actions;
	}

	
	
	@FindBy(css = "input.form-control.OSFillParent")
	WebElement userElement;
	
	@FindBy(css = "input.form-control.login-password.OSFillParent")
	WebElement passWordElement;
	
	@FindBy(css = "button.btn.btn-primary.OSFillParent")
	WebElement logInElement;
	
	private void typeUser(String user) {
		actions.inputValues(userElement, user);
	}
	
	private void typePassWord(String pass) {
		actions.inputValues(passWordElement, pass);
	}
	
	private void clickLogIn() {
		actions.click(logInElement);
	}

	public void logInSteps(String user, String pass) {
		typePassWord(pass);
		typeUser(user);
		clickLogIn();
	}

	

}
