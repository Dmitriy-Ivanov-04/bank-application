package inputOutput;

import accounts.BankAccount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InputOutputObject {
	
	public static void ObjectInput(ArrayList<BankAccount> newArr, ArrayList<BankAccount> arr) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("1.txt"))) {
			
			for(int i = 0; i < "1.txt".length(); i++) {
				BankAccount bankAccountInput = (BankAccount) ois.readObject();
				newArr.add(bankAccountInput);
            }
			
			arr.addAll(newArr);
			System.out.println("Данные были считаны из файла");
			
        } catch (Exception ex)	{
        	System.out.println("Данные были считаны из файла");
        }
		
    }
	
	public static void ObjectOutputt(ArrayList<BankAccount> arr) throws FileNotFoundException, IOException{
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("1.txt"))) {
			
			for (int i = 0; i < arr.size(); i++) {
				BankAccount bankAccountOutput = (BankAccount) arr.get(i);
                oos.writeObject(bankAccountOutput);
			}
			
            System.out.println("В файл были записаны данные о банковских счетах");
        
		} catch(Exception ex){
            System.out.println(ex.getMessage());
        }
		
	}

}
