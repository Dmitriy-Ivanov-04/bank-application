package accounts;

import java.io.Serializable;

public class CreditAccount extends BankAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private double cash = 0;
	private double percent;
	private String name;
	private String type;

	public CreditAccount(String name, String type, double percent) {
		super();
		
		if ((percent <= 0) || (percent > 100)) {
			System.out.println("Ставка не допустима");
			this.percent = 0;
		} else {
		    this.percent = percent/100;
		}
		
		this.name = name;
		this.type = type;
	
	}

	@Override
	public double withdrawMoney(double money) {
		
		cash -= money;
		return money;
		
	}

	@Override
	public double putMoney(double money) {
		
		if (money <= 0){
			System.out.println("Невозможно внести количество денег меньшее чем ноль");
			return 1;
		} else {
		    cash += money;
		    return money;
		}
		
	}

	@Override
	public double checkBalance() {
		
		return cash;

	}

	@Override
	public double accrueInterest() {
		
		if(cash < 0) {
		    double a = percent*cash;
		    return a;
		}
		else {
			return 0;
		}
		
	}

	@Override
	public String returnName() {
		
		return name;
	
	}

	@Override
	public String returnType() {
		
		return type;
	
	}
	
}
