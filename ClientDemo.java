package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.Date;

public class ClientDemo {

public static void main(String[] args) {

SessionFactory sf = new Configuration()
.configure()
.addAnnotatedClass(Delivery.class)
.buildSessionFactory();

Session session = sf.openSession();

Transaction t1 = session.beginTransaction();

Delivery d = new Delivery("Amazon", new Date(), "Delivered");
session.save(d);

System.out.println("Record Inserted");

t1.commit();

Transaction t2 = session.beginTransaction();

Query q = session.createQuery("delete from Delivery where id=?1");
q.setParameter(1,1);
q.executeUpdate();

System.out.println("Record Deleted");

t2.commit();

session.close();
sf.close();

}

}
