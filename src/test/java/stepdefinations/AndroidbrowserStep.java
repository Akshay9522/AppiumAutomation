package stepdefinations;

import org.junit.Assert;

import com.pages.AndroidBrowserPage;
import com.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AndroidbrowserStep extends Base{
	AndroidBrowserPage adbpage;
	@Given("user launched facebook application in the android chrome browser")
	public void user_launched_facebook_application_in_the_android_chrome_browser() throws Throwable {
		androidDriver(loadProperties().getProperty("appium.server.url"), androidBrowserCapabilities());
		driver.get("https://www.facebook.com");
		adbpage = new AndroidBrowserPage(driver);
	}

	@When("user entered username {string} and password {string}")
	public void user_entered_username_and_password(String username, String password) {
		adbpage.enterUsername(username);
		adbpage.enterUsername(password);

	}

	@When("user clicked on login button")
	public void user_clicked_on_login_button() {
		adbpage.clickOnLogin();
	}

	@Then("verify error message displayed sucessfully")
	public void verify_error_message_displayed_sucessfully() {
		Assert.assertEquals(adbpage.displayErrorMsg(),"The email address or mobile number you entered isn't connected to an account. ");
	}



}
