package nicebank;

public class Account {
	private Money balance;
	public void deposit(Money amount) {
		balance = amount;
	}
	public Money getBalance() {
		return balance;
	}

}
