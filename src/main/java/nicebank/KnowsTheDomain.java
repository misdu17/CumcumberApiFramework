package nicebank;

public class KnowsTheDomain {
	
	private Account myAccount;
	private CashSlot cashSlot;
	private Teller teller;
	
	public KnowsTheDomain(){
		this.myAccount = new Account();
		this.cashSlot = new CashSlot();
		this.teller = new Teller(cashSlot);
		
	}
	public Account getMyAccount() {
		if (myAccount == null) {
			myAccount = new Account();
		}
		return myAccount;
	}
	public CashSlot getCashSlot() {
		if (cashSlot == null) {
			cashSlot = new CashSlot();
		}
		return cashSlot;
	}
	public Teller getTeller() {
		if (teller == null) {
			teller =  new Teller(cashSlot);
		}
		return teller;
	}
}
