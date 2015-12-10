package ua.basedao.start;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import ua.basedao.entiti.CustomersEntiti;
import ua.basedao.entiti.OrdersEntiti;
import ua.basedao.entiti.PaymentsEntiti;
import ua.basedao.util.HibernateSessionFactory;
import java.sql.Date;
import java.time.Year;
import java.util.Calendar;
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
        System.out.println ("Start session");
        // 1. Выбрать всех контрагентов из Франции или Испании
        //Choice the country France and Spain----------------------------------------------------------
        Criteria cr1 = session.createCriteria(CustomersEntiti.class);
        Criterion countryFrance=Restrictions.eq("country", "France");
        Criterion countrySpain=Restrictions.eq("country", "Spain");
        LogicalExpression orExp = Restrictions.or(countryFrance, countrySpain);
        cr1.add(orExp);
        List results = cr1.list();
        System.out.println("Customers for country: France and Spain");
        System.out.println(results);
        //----------------------------------------------------------------------------------------------------
        //2. Выбрать всех контрагентов, имя контакта которых начинается на J и кредитный лимит больше 100 000
        //To choice contact FirstName starting with "J" and having credit limit more than 100 000-------------
        Criteria cr2 = session.createCriteria(CustomersEntiti.class);
        Criterion nameBeginJ=Restrictions.like("contactFirstName","J%");
        double creditLimitN=100000;
        Criterion creditLimit=Restrictions.gt("creditLimit",creditLimitN);
        LogicalExpression andExp = Restrictions.and(nameBeginJ,creditLimit);
        cr2.add(andExp);
        List resultsChoice = cr2.list();
        System.out.println("contact FirstName starting with -J- and having credit limit more than 100 000");
        System.out.println(resultsChoice);
        //----------------------------------------------------------------------------------------------
        //3. Выбрать, в разбивке по месяцам, количество и сумму платежей за май-июль 2004-го
        Criteria criAmount = session.createCriteria(PaymentsEntiti.class);
        Date date1 = new Date(104,04,01);
        Date date2 = new Date(104,06,31);
        System.out.println(date1+" "+date2);
        criAmount.add(Restrictions.between("paymentDate",date1,date2));
        criAmount.addOrder(Order.asc("paymentDate"));
        List resultsDateSort=criAmount.list();
        System.out.println("-----------Date Sort-------");
        System.out.println(resultsDateSort);
        //----------------------------------------------------------------------------------------------------------
        //4. Выбрать платежи контрагентов из Франции
        Criteria crFrance = session.createCriteria(CustomersEntiti.class);
        crFrance.add(Restrictions.eq("country", "France"));
        List resultFranseId=crFrance.list();
        for (Iterator iterator = resultFranseId.iterator(); iterator.hasNext();){
            Criteria crPaymentsFrance =session.createCriteria(PaymentsEntiti.class);
            CustomersEntiti customersEntiti=(CustomersEntiti) iterator.next();
            crPaymentsFrance.add(Restrictions.eq("customerNumber",customersEntiti.getCustomerNumber()));
           System.out.println("id = "+customersEntiti.getCustomerNumber() +" country - "+customersEntiti.getCountry()+" ");
            System.out.println(crPaymentsFrance.list());
        }
        //5. Выбрать названия контрагентов, номера, даты и статусы заказов, не находящихся в статусе «Доставлено» (Shipped)
        List resultNoShipped=session.createCriteria(OrdersEntiti.class).add(Restrictions.not(Restrictions.eq("status","Shipped"))).list();
        for (Iterator iterator = resultNoShipped.iterator(); iterator.hasNext();){
            OrdersEntiti ordersEntiti=(OrdersEntiti) iterator.next();
            System.out.println("order Number= "+ordersEntiti.getOrderNumber()+" orderDate= "+ordersEntiti.getOrderDate()+" status - "+ordersEntiti.getStatus()+
            " Costumer namber "+ordersEntiti.getCustomerNumber());
        }
        //System.out.println(resultNoShipped);



        tx.commit();
        session.close();
        System.out.println ("Close session");
    }
}
