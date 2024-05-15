package stepdefinations;

import org.testng.Assert;

import com.pages.GesturePage;
import com.pages.LoginPage;
import com.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends Base {
	public LoginPage lgpge;
	

	@Given("user launched android mobile application")
	public void user_launched_mobile_application() throws Throwable {
		androidDriver(loadProperties().getProperty("appium.server.url"), androidCapabilities());
		
	}
	@When("user entered Username {string} and Password as {string}")
	public void user_entered_username_and_password_as(String username, String password) throws Throwable {
		this.lgpge = new LoginPage(driver);
		lgpge.clickOnLogin();
		lgpge.enterloginDetails(username, password);
	}

	@When("user clicked on sign")
	public void user_clicked_on_sign() {
		lgpge.clickOnsignin();

	}

	@Then("login must be successful message displayed")
	public void login_must_be_successful_message_displayed() {
		Assert.assertEquals(lgpge.displayMsg(), "Success");

	}

	@Then("android mobile application closed")
	public void android_mobile_application_closed() {
		tearDown();
	}

	@Then("clicked on ok")
	public void clicked_on_ok() {
		lgpge.clickOnOK();
	}
}
