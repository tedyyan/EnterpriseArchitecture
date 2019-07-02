package edu.mum.cs544.bank.service;

import edu.mum.cs544.bank.dao.AccountDAO;
import edu.mum.cs544.bank.dao.EntityManagerHelper;
import edu.mum.cs544.bank.dao.IAccountDAO;
import edu.mum.cs544.bank.dao.JPAAccountDAO;
import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.Customer;
import edu.mum.cs544.bank.logging.ILogger;
import edu.mum.cs544.bank.logging.Logger;

import java.util.Collection;

import org.hibernate.sql.Template;


public class AccountService implements IAccountService {
    private IAccountDAO accountDAO;
    private ICurrencyConverter currencyConverter;
    private ILogger logger;

    public AccountService() {
        //accountDAO = new AccountDAO();
    	accountDAO = new JPAAccountDAO();
        currencyConverter = new CurrencyConverter();
        logger = new Logger();
    }

    public Account createAccount(long accountNumber, String customerName) {
    	
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        EntityManagerHelper.getCurrent().getTransaction().begin();
        accountDAO.saveAccount(account);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
        logger.log("createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        EntityManagerHelper.getCurrent().getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
        logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public Account getAccount(long accountNumber) {
        EntityManagerHelper.getCurrent().getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
        return account;
    }

    public Collection<Account> getAllAccounts() {
        EntityManagerHelper.getCurrent().getTransaction().begin();
        Collection<Account> temp = accountDAO.getAccounts();
        EntityManagerHelper.getCurrent().getTransaction().commit();
        //EntityManagerHelper.getCurrent().close();
        return temp;
    }

    public void withdraw(long accountNumber, double amount) {
        EntityManagerHelper.getCurrent().getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
        logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public void depositEuros(long accountNumber, double amount) {
        EntityManagerHelper.getCurrent().getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        accountDAO.updateAccount(account);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
        logger.log("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public void withdrawEuros(long accountNumber, double amount) {
        EntityManagerHelper.getCurrent().getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        accountDAO.updateAccount(account);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
        logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        EntityManagerHelper.getCurrent().getTransaction().begin();
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
        logger.log("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= " + toAccountNumber + " , amount= " + amount + " , description= " + description);
    }
}
