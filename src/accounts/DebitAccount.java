package accounts;

import java.io.Serializable;

public class DebitAccount extends BankAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private double cash = 0;
	private double percent;
	private String name;
	private String type;

	@Override
	public double withdrawMoney(double money) {
		
		if ((money > cash) || (money <= 0)) {
			System.out.println("Недостаточно средств!");
			return cash;
		} else {
		    cash -= money;
		    return money;
		}
		
	}

	@Override
	public double putMoney(double money) {
		
		if (money <= 0){
			System.out.println("Вы ввели неккоректное значение. Попробуйте снова");
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
		
		    double a = percent*cash;
		    return a;
		
	}

	public DebitAccount(String name, String type, double cash, double percentt) {
		
		if (cash <= 0) {
		    this.cash = 0;
		} else {
			this.cash = cash;
		}
		
		if ((percentt <= 0) || (percentt > 100)) {
			System.out.println("Ставка не допустима");
			percent = 0;
		} else {
		    percent = percentt/100;
		}
		
		this.name = name;
		this.type = type;
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