package edu.mum.cs544.bank.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;

import edu.mum.cs544.bank.domain.Account;

public class JPAAccountDAO implements IAccountDAO {

	@Override
	public void saveAccount(Account account) {
		EntityManagerHelper.getCurrent().persist(account);

	}

	@Override
	public void updateAccount(Account account) {
		account = EntityManagerHelper.getCurrent().merge(account);

	}

	@Override
	public Account loadAccount(long accountnumber) {
		TypedQuery<Account> query = EntityManagerHelper.getCurrent()
				.createQuery("from Account a  where a.accountnumber = :accountnumber", Account.class);
		query.setParameter("accountnumber", accountnumber);
		// System.out.println("accountnumber:"+accountnumber);
		return query.getSingleResult();
	}

	@Override
	public Collection<Account> getAccounts() {
		TypedQuery<Account> query = EntityManagerHelper.getCurrent().createQuery("from Account a",Account.class);
		return query.getResultList();
	}
		
		public Collection<Account> getAccounts2() {
		// Graph
		EntityGraph<Account> graph = EntityManagerHelper.getCurrent().createEntityGraph(Account.class);
		graph.addAttributeNodes("entryList");
		// graph.addSubgraph("books").addAttributeNodes("author");

		TypedQuery<Account> query = EntityManagerHelper.getCurrent().createQuery("from Account", Account.class);
		query.setHint("javax.persistence.fetchgraph", graph);
		List<Account> ownerlist = query.getResultList();
		return ownerlist;
	}

}
