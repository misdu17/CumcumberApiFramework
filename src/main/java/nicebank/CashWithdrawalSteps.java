package nicebank;

import org.junit.Assert;

import cucumber.api.Transform;
import cucumber.api.Transformer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CashWithdrawalSteps {

	KnowsTheDomain helper;

	public CashWithdrawalSteps() {
		helper = new KnowsTheDomain();
	}

	@Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
	public void i_have_deposited_$_in_my_account(
			@Transform(MoneyConverter.class) Money amount) throws Throwable {

		helper.getMyAccount().deposit(amount);

		Assert.assertEquals("Incorrect account balance -", amount,
				helper.getMyAccount().getBalance());
	}

	@When("^I withdraw \\$(\\d+)$")
	public void i_withdraw_$(int dollars) throws Throwable {
		helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
	}

	@Then("^\\$(\\d+) should be dispensed$")
	public void $_should_be_dispensed(int dollars) throws Throwable {
		Assert.assertEquals("Incorrect amount dispensed -",
				dollars, helper.getCashSlot().getContents());
	}

}
