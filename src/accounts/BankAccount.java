package accounts;

public abstract class BankAccount {
	
	public abstract double withdrawMoney(double money);
	
	public abstract double putMoney(double money);
	
	public abstract double checkBalance();
	
	public abstract double accrueInterest();
	
	public abstract String returnName ();
	
	public abstract String returnType();
	
}