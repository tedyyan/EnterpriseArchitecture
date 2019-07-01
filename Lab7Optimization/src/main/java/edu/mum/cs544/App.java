package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Owner> query = em.createQuery("from Owner o ", Owner.class);
        List<Owner> ownerlist = query.getResultList();
        
        //TypedQuery<Owner> q = em.createNamedQuery("Owner.Everybody", Owner.class);
        //List<Owner> ownerlist = q.getResultList();
        
        //TypedQuery<Owner> query = em.createQuery("select o from Owner o join o.pets", Owner.class);
        //List<Owner> ownerlist = query.getResultList();
        
        		
        //Graph
//        EntityGraph<Owner> graph = em.createEntityGraph(Owner.class);
//        graph.addAttributeNodes("pets");
//        //graph.addSubgraph("books").addAttributeNodes("author");
//
//        TypedQuery<Owner> query = em.createQuery(
//        		"from Owner",
//        		Owner.class);
//		query.setHint("javax.persistence.fetchgraph", graph);
//		List<Owner> ownerlist = query.getResultList();
		
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

//        a) Add the @LazyCollection with option EXTRA to the association and run App again.
        //To fetch this data from the database took 58231 milliseconds.
        //-------------------------------------------
        //Hibernate: select owner0_.id as id1_0_, owner0_.name as name2_0_ from Owner owner0_
//        Hibernate: select count(id) from Pet where clientid =?
//        Hibernate: select count(id) from Pet where clientid =?
//        Hibernate: select count(id) from Pet where clientid =?
        // ... ...
        
//        b) Remove the @LazyCollection, and modify the mapping for Owner.java to
//        use batch fetching, batch size 10. Also check the time when using sizes 5
//        and 50.
        
        //batch szie 5
        //To fetch this data from the database took 25180 milliseconds.
          //batch size 50
          //To fetch this data from the database took 13210 milliseconds.
         //-------------------------------------------------------------------------
//        Hibernate: select owner0_.id as id1_0_, owner0_.name as name2_0_ from Owner owner0_
//        Hibernate: select pets0_.clientid as clientid3_1_1_, pets0_.id as id1_1_1_, pets0_.id as id1_1_0_, pets0_.name as name2_1_0_ from Pet pets0_ where pets0_.clientid in (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
//        Hibernate: select pets0_.clientid as clientid3_1_1_, pets0_.id as id1_1_1_, pets0_.id as id1_1_0_, pets0_.name as name2_1_0_ from Pet pets0_ where pets0_.clientid in (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

        
//        c) Modify the mapping to use the sub-select strategy instead of batch fetching.
        //To fetch this data from the database took 40888 milliseconds.
        //--------------------------------------------------------------------------
        //Hibernate: select owner0_.id as id1_0_, owner0_.name as name2_0_ from Owner owner0_
        //Hibernate: select pets0_.clientid as clientid3_1_1_, pets0_.id as id1_1_1_, pets0_.id as id1_1_0_, pets0_.name as name2_1_0_ from Pet pets0_ where pets0_.clientid in (select owner0_.id from Owner owner0_)

        
        
//        d) Remove the sub-select strategy and use a join fetch query in
//        App.java to retrieve everything. Also check the difference between using a named query, or just a query directly in code.
        
        // query with join
        //To fetch this data from the database took 13749 milliseconds.
        //-------------------------------------------------------------------------
        //Hibernate: select owner0_.id as id1_0_, owner0_.name as name2_0_ from Owner owner0_ inner join Pet pets1_ on owner0_.id=pets1_.clientid
        //Hibernate: select pets0_.clientid as clientid3_1_0_, pets0_.id as id1_1_0_, pets0_.id as id1_1_1_, pets0_.name as name2_1_1_ from Pet pets0_ where pets0_.clientid=?
        //Hibernate: select pets0_.clientid as clientid3_1_0_, pets0_.id as id1_1_0_, pets0_.id as id1_1_1_, pets0_.name as name2_1_1_ from Pet pets0_ where pets0_.clientid=?
        // ... ...
        //
        // query without join
        //To fetch this data from the database took 58660 milliseconds.
        //--------------------------------------------------------------------------
//        Hibernate: select owner0_.id as id1_0_, owner0_.name as name2_0_ from Owner owner0_
//        Hibernate: select pets0_.clientid as clientid3_1_0_, pets0_.id as id1_1_0_, pets0_.id as id1_1_1_, pets0_.name as name2_1_1_ from Pet pets0_ where pets0_.clientid=?
//        Hibernate: select pets0_.clientid as clientid3_1_0_, pets0_.id as id1_1_0_, pets0_.id as id1_1_1_, pets0_.name as name2_1_1_ from Pet pets0_ where pets0_.clientid=?

        // Named query with join
        //To fetch this data from the database took 12937 milliseconds.
        // Named query without join
        //To fetch this data from the database took 53833 milliseconds.
        
        
//        e) Lastly modify the application to use an Entity Graph instead of a join fetch.
        //To fetch this data from the database took 10672 milliseconds.
      //select owner0_.id as id1_0_0_, pets1_.id as id1_1_1_, owner0_.name as name2_0_0_, pets1_.name as name2_1_1_, pets1_.clientid as clientid3_1_0__, pets1_.id as id1_1_0__ from Owner owner0_ left outer join Pet pets1_ on owner0_.id=pets1_.clientid

        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
        System.exit(0);
    }

}
