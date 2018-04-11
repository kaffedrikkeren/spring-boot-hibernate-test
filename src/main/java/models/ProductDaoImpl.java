package models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product.getId();
    }

    @Override
    public Product get(long id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public List<Product> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        Query<Product> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(long id, Product product) {
        Session session = sessionFactory.getCurrentSession();
        Product book2 = session.byId(Product.class).load(id);
        book2.setName(product.getName());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.byId(Product.class).load(id);
        session.delete(product);
    }

}
