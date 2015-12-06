package ua.basedao.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.basedao.entiti.CustomersEntiti;

import java.util.Iterator;
import java.util.List;

/**
 * Created by liny on 06.12.15.
 */
public class Start {
    //
    private static SessionFactory factory;
    public static void main(String[] args){
        //
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        //
        //CustomersEntiti customersEntiti=new CustomersEntiti();
        Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List customers = session.createQuery("SELECT customerName FROM customers").list();
         for (Iterator iterator =
              employees.iterator(); iterator.hasNext();){
             CustomersEntiti employee = (Employee) iterator.next();
            System.out.print("First Name: " + employee.getFirstName());
            System.out.print("  Last Name: " + employee.getLastName());
            System.out.println("  Salary: " + employee.getSalary());
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      }finally {
         session.close();
      }


    }
}
