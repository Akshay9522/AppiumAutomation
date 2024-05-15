package stepdefinations;

import com.pages.GesturePage;
import com.utils.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GestureStep extends Base {
	GesturePage gpge;

	@When("user taped on swipe button")
	public void user_taped_on_swipe_button() {
		gpge = new GesturePage(driver);
		gpge.clickswipe();
	}
	
	@When("user swiped toward {string} once")
	public void user_swiped_toward_once(String string) {
		gpge.swipeByfullopensrc(string);
	}

	@Then("verify user swiped sucessfully")
	public void verify_user_swiped_sucessfully() {
		gpge.swipeVarify();
	}

	@When("user scrolled upto the {string}")
	public void user_scrolled_upto_the(String text) {
		gpge.scrollByVisualText(text);
	}

	@Then("verify user scrolled sucessfully")
	public void verify_user_scrolled_sucessfully() {
		gpge.scrollVarify();
	}

}
