package org.ngvhuy.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ngvhuy.config.HibernateUtils;
import org.ngvhuy.entity.Dataset;

public class DatasetService {
    public void getByName() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session1 = sessionFactory.openSession();
        Session session2 = sessionFactory.openSession();
        try {
            Dataset dataset1 = session1.get(Dataset.class, 10L);
            System.out.println(".............");
            Dataset dataset2 = session2.get(Dataset.class, 10L);
            System.out.println(".............");
            sessionFactory.getCache().evict(Dataset.class, dataset1);
            Dataset dataset11 = session1.get(Dataset.class, 10L);
            System.out.println(".............");
            Dataset dataset22 = session2.get(Dataset.class, 10L);
            System.out.println(".............");

        } catch (Exception ex) {
            System.out.println("Errorrrr");
            session1.getTransaction().rollback();
            session2.getTransaction().rollback();
        } finally {
            session1.close();
            session2.close();
        }
    }
}
