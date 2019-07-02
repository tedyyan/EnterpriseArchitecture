package edu.mum.cs544;


import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;



public class JPAStudentDAOWithClose extends StudentDAO{
	public Student load(long studentid) {
		// Graph
				EntityGraph<Student> graph = EntityManagerHelper.getCurrent().createEntityGraph(Student.class);
				graph.addAttributeNodes("courselist");
				// graph.addSubgraph("books").addAttributeNodes("author");

				TypedQuery<Student> query = EntityManagerHelper.getCurrent().createQuery("from Student", Student.class);
				query.setHint("javax.persistence.fetchgraph", graph);
				return query.getSingleResult();
		
	}
}
