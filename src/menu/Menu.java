package menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import accounts.BankAccount;
import accounts.CreditAccount;
import accounts.DebitAccount;
import inputOutput.InputOutputObject;

public class Menu {
	
	@SuppressWarnings("resource")
	public static void menu(ArrayList<BankAccount> arr, ArrayList<BankAccount> newArr) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("МЕНЮ БАНКА\n1.Добавление счёта\n2.Удаление счёта\n3.Проверка баланса\n4.Перевод денег между счетами\n"
				+ "5.Пополнение счёта\n6.Снятие средств\n7.Начисление процентов\n8.Баланс всех счетов\n9.Сумма денег на всех счетах\n"
				+ "10.Записать в файл данные о счетах\n11.Считать с файла данные о счетах");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
        	System.out.print("\nВАШ ВЫБОР: ");
	        int choiceMenu = scanner.nextInt();
	        
	        switch(choiceMenu) {
	        
		        case 1:
		        	System.out.print("Какой счёт вы хотите добавить?\n1.Дебетовый\n2.Кредитный\nВведите номер: ");
		        	Scanner scanner1 = new Scanner(System.in);
		        	int choice = scanner1.nextInt();
		        	
		        	switch(choice) {
		        	
			        	case 1: 
			        		try {
				        		String debit = "Дебетовый";	
				        			
				        		System.out.print("Введите название банка: ");
				            	Scanner scanner11 = new Scanner(System.in);
				           		String choice11 = scanner11.nextLine();
				        			
				        		System.out.print("Введите количество денег: ");
				        		Scanner scannerMoney = new Scanner(System.in);
				        		double amountOfMoney = scannerMoney.nextDouble();
				        		
				        		System.out.print("Введите процентную ставку: ");
				        		Scanner scannerPr = new Scanner(System.in);
				            	double percent = scannerPr.nextDouble();
				            	
				        		arr.add(new DebitAccount(choice11, debit, amountOfMoney, percent));
			        		
			        		} catch (InputMismatchException ex) {
			        			System.out.println("Вы ввели недопустимые значения! Попробуйте снова");
			        		}
			        		break;
			        	
			             case 2:
			            	try {
				            	String credit = "Кредитный";		
				            		
				            	System.out.print("Введите название банка: ");
				               	Scanner scanner12 = new Scanner(System.in);
				             	String nameBank = scanner12.nextLine();	
				            		
				            	System.out.print("Введите процентную ставку: ");
				         		Scanner scannerPr2 = new Scanner(System.in);
				                double percent2 = scannerPr2.nextDouble();
				             	
				         		arr.add(new CreditAccount(nameBank, credit,  percent2));
			        		} catch (InputMismatchException ex) {
			        			System.out.println("Вы ввели недопустимые значения! Попробуйте снова");
			        		}
			         	 break;
			         		
			             default:
			            	 System.out.println("Вы ввели некорректное значение. Попробуйте снова.");
			             break;
			        } 
		        	
	        	break;
		        	
		        	
		        case 2:
		        	if (!arr.isEmpty()) {
			        	try {
				        	System.out.print("Какой счёт вы хотите удалить?\nВведите номер счёта: ");
				        	Scanner scanner2 = new Scanner(System.in);
				        	int delete = scanner2.nextInt();
				        	
				        	try {
				        	    arr.remove(delete);
				        	} catch (IndexOutOfBoundsException e) {
				        		System.out.println("Счёта под этим номером не существует");
				        	}
				        } catch (InputMismatchException ex) {
				       		System.out.println("Вы ввели недопустимые значения! Попробуйте снова");
				       	}
		        		
		        	} else {
		        		System.out.println("У вас нет ни одного банковского счёта");
		        	}
	        	break;
		        	
		        	
		        case 3:
		        	if (!arr.isEmpty()) {
			        	try {
				        	System.out.print("Баланс какого счёта вы хотите проверить?\nВведите номер счёта: ");
				        	Scanner scanner3 = new Scanner(System.in);
				        	int checkBalance = scanner3.nextInt();
				        	
				        	try {
								System.out.println("Банк: " + arr.get(checkBalance).returnName() + "\nТип счёта: " + arr.get(checkBalance).returnType() + "\nБаланс счёта: " + arr.get(checkBalance).checkBalance());
				        	} catch (IndexOutOfBoundsException ex) {
				        		System.out.println("Счёта под этим номером не существует");
				        	}
				        	
			        	} catch (InputMismatchException ex) {
			        		System.out.println("Вы ввели недопустимые значения! Попробуйте снова");
			        	}
		        	} else {
		        		System.out.println("У вас нет ни одного банковского счёта");
		        	}	
		        break;
		        	
		        	
		        case 4:
		        	if(!arr.isEmpty()) {
			        	try {
				        	System.out.print("С какого счёта вы хотите перевести деньги?\nВведите номер счёта: ");
				           	Scanner scanner4 = new Scanner(System.in);
				           	int whereFrom = scanner4.nextInt();
				           	
				           	System.out.print("На какой счёт вы хотите перевести деньги?\nВведите номер счёта: ");
				           	Scanner scannerWhere4 = new Scanner(System.in);
				           	int where = scannerWhere4.nextInt();
				           	
				           	System.out.print("Какую сумму вы хотите перевести?\nВведите сумму: ");
				           	Scanner scannerSum = new Scanner(System.in);
				           	double sum = scannerSum.nextDouble();
				           	
				           	try {
				           		arr.get(where).putMoney(arr.get(whereFrom).withdrawMoney(sum));
				           		System.out.println("Средства были успешно переведены");
				           	} catch (IndexOutOfBoundsException ex){
				           		System.out.println("Счёта под этим номером не существует");
				        	}
				           	
			        	} catch (InputMismatchException ex) {
			        		System.out.println("Вы ввели недопустимые значения! Попробуйте снова");
			        	}
			        	
		        	} else {
		        		System.out.println("У вас нет ни одного банковского счёта");
		        	}	
		        break;
		        	
		        	
		        case 5:
		        	if(!arr.isEmpty()) {
			        	try {
				        	System.out.println("На какой счёт вы хотите добавить средства?\nВведите номер счёта: ");
				        	Scanner scanner5 = new Scanner(System.in);
				           	int where = scanner5.nextInt();
				           	
				           	System.out.print("Какую сумму вы хотите внести?\nВведите сумму: ");
				        	Scanner scannerQuantity5 = new Scanner(System.in);
				           	double amountOfMoney = scannerQuantity5.nextDouble();
				           	
				           	try {
				           		arr.get(where).putMoney(amountOfMoney);
				           		System.out.println("Средства были успешно добавлены");
				           	} catch (IndexOutOfBoundsException ex) {
				           		System.out.println(ex.getMessage());
				           	}
				           	
			        	} catch (InputMismatchException ex) {
			        		System.out.println("Вы ввели недопустимые значения! Попробуйте снова");
			        	}
			        	
		        	} else {
		        		System.out.println("У вас нет ни одного банковского счёта");
		        	}	
		        break;
		        	
		        	
		        case 6:
		        	if(!arr.isEmpty()) {
		        		try {
			            	System.out.println("С какого счёта вы хотите снять средства?\nВведите номер счёта: ");
			            	Scanner scanner6 = new Scanner(System.in);
			               	int whereFrom = scanner6.nextInt();
			               	
			               	System.out.print("Какую сумму вы хотите снять?\nВведите сумму: ");
			            	Scanner scannerQuantity6 = new Scanner(System.in);
			               	double amountOfMoney = scannerQuantity6.nextDouble();
			               	
			               	try {
			               		arr.get(whereFrom).withdrawMoney(amountOfMoney);
			               		System.out.println("Средства были успешно переведены");
			               	} catch (IndexOutOfBoundsException ex) {
			               		System.out.println(ex.getMessage());
			               	}
			               	
		        		} catch (InputMismatchException ex) {
		            		System.out.println("Вы ввели недопустимые значения! Попробуйте снова");
		            	}
		        		
		            	} else {
		            		System.out.println("У вас нет ни одного банковского счёта");
		            	}	
		        break;
		        	
		        	
		        case 7:
		        	if(!arr.isEmpty()) {
			        	try {
			        	System.out.println("На какой счёт вы хотите начислить проценты?\nВведите номер счёта: ");
			        	Scanner scanner7 = new Scanner(System.in);
			           	int wherePercent = scanner7.nextInt();
			           	
				           	try {
				           		System.out.println("Банк: " + arr.get(wherePercent).returnName() + "\nНачисленные проценты: " + arr.get(wherePercent).accrueInterest());
				           	} catch (IndexOutOfBoundsException ex) {
				           		System.out.println(ex.getMessage());
				           	}
				           	
			        	} catch (InputMismatchException ex){
			        		System.out.println("Вы ввели недопустимые значения! Попробуйте снова");
			        	}
			        	
		        	} else {
		        		System.out.println("У вас нет ни одного банковского счёта");
		        	}
		        break;
		           	
		           	
		        case 8:
		        	if(!arr.isEmpty()) {
			        	for (int i = 0; i < arr.size(); i++) {
			        		System.out.println("Баланс счёта №" + i + " Банка " + arr.get(i).returnName() + " равен " + arr.get(i).checkBalance());
			        	}
			        	
		        	} else {
		        		System.out.println("У вас нет ни одного банковского счёта");
		        	}
		        break;
		        	
		        	
		        case 9:
		        	if(!arr.isEmpty()) {
		        		double s = 0;
			    		for (int i = 0; i < arr.size(); i++) {
			    		    s += arr.get(i).checkBalance();
			    		}
			    		System.out.println("Сумма всех балансов равна " + s);
			    		
		        	} else {
		        		System.out.println("У вас нет ни одного банковского счёта");
		        	}		        	
		    	break;
		    		
		    		
		        case 10:
		        	if(!arr.isEmpty()) {
		        		InputOutputObject.ObjectOutputt(arr);
		        	}
		        break;
		        	
		        	
		        case 11:
		        		InputOutputObject.ObjectInput(arr, newArr);
		        break;
		        	
		        	
		        default:
		        	System.out.println("Вы ввели некорректное значение! Попробуйте снова");
		        break;
		        
		     }
		}
	}

}
