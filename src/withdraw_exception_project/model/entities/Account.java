package withdraw_exception_project.model.entities;

import withdraw_exception_project.model.exception.DomainAccountException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
		this.balance = balance;
		this.number = number;
		this.holder = holder;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainAccountException {
		if (amount > withdrawLimit) 
			throw new DomainAccountException("The Amount Exceeds Withdraw Limit");
		if (amount > balance) 
			throw new DomainAccountException("Not Enough Balance");
		balance -= amount;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
}