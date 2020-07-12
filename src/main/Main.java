package main;

import accounts.BankAccount;
import menu.Menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<BankAccount> arr = new ArrayList<BankAccount>();
	static ArrayList<BankAccount> newArr= new ArrayList<BankAccount>();

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	
		Menu.menu(arr, newArr);
		
	}

}