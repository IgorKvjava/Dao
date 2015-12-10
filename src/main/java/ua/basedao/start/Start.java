package ua.basedao.start;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import ua.basedao.entiti.CustomersEntiti;
import ua.basedao.util.HibernateSessionFactory;

import java.util.Iterator;
import java.util.List;

/**
 * Created by liny on 06.12.15.
 */
public class Start {
    //
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        System.out.println ("/nStart");
        CustomersEntiti customersEntiti;
        Criteria cr1 = session.createCriteria(CustomersEntiti.class);
        cr1.add(Restrictions.eq("country", "France"));
        List resultsFranse = cr1.list();
        System.out.println("France");
        System.out.println(resultsFranse);
        Criteria cr2 = session.createCriteria(CustomersEntiti.class);
        cr2.add(Restrictions.eq("country", "Spain"));
        List resultsSpain = cr2.list();
        System.out.println("Spain");
        System.out.println(resultsSpain);



        tx.commit();
        session.close();
    }
}
