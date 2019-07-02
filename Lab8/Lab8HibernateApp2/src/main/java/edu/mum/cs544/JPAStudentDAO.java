package edu.mum.cs544;

import javax.persistence.TypedQuery;


public class JPAStudentDAO extends StudentDAO{
	public Student load(long studentid) {
		TypedQuery<Student> query = EntityManagerHelper.getCurrent()
				.createQuery("from Student a  where a.studentid = :studentid", Student.class);
		query.setParameter("studentid", studentid);
		// System.out.println("accountnumber:"+accountnumber);
		return query.getSingleResult();
		
	}
}
