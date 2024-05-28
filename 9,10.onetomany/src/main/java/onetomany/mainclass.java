package onetomany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class mainclass {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("onetomany");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Person person = new Person();
		person.setName("sahana");
		person.setNumber(9880878654l);

		Person person2 = new Person();
		person2.setName("priya");
		person2.setNumber(9019887654l);

		BankAccount account = new BankAccount();
		account.setAccountno(123456789);
		account.setBankname("canara");
		account.setDob("20/06/2002");

		BankAccount account1 = new BankAccount();
		account1.setAccountno(987654321);
		account1.setBankname("SBI");
		account1.setDob("20/06/2002");

		ArrayList bankAccounts = new ArrayList();
		bankAccounts.add(account);
		bankAccounts.add(account1);

		person.setAccount(bankAccounts);
		account.setPerson(person2);
		account1.setPerson(person2);

		transaction.begin();
		manager.persist(account);
		manager.persist(account1);
		manager.persist(person);
		manager.persist(person2);
		transaction.commit();
	}
}
