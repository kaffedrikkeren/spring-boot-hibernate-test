package ormtest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ormtest.models.Product;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public List getProducts() {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Product.class);
        Root contactRoot = criteria.from(Product.class);
        criteria.select(contactRoot);
        return session.createQuery(criteria).getResultList();
    }

}

