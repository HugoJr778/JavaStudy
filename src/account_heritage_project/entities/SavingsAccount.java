package account_heritage_project.entities;

public class SavingsAccount extends Account {
		
	private Double interestRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.setInterestRate(interestRate);
	}
	
	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void updaetBalance() {
		balance += balance * interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
}