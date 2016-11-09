package cz.etn.etnshop.dao;

import org.hibernate.Criteria;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    Logger log = Logger.getLogger(ProductDaoImpl.class.getName());
    Level level = Level.WARNING;

    @SuppressWarnings("unchecked")
    public List<Product> getProducts() {
        //After adding an object outside of this project, the new ones need to be indexed.
        //Uncomment these lines, start application, wait until it will be indexed (this function must be called)
        //then turn off application, comment these lines and start application again
        //log.setLevel(level);
        //try {
        //     Criteria criteria = getSession().createCriteria(Product.class);
        //     criteria.list().forEach(o -> Search.getFullTextSession(getSession()).index(o));
        //} catch (Exception ex) {
        //     log.log(level, "Database WAS NOT indexed", ex);
        //     return new ArrayList<>();
        //}
        //log.log(level, "Database was successfully indexed");

        Criteria criteria = getSession().createCriteria(Product.class);
        return (List<Product>) criteria.list();
    }

    public void addProduct(Product product) {
        getSession().save(product);
    }

    public void updateProduct(Product product) {
        getSession().update(product);
    }

    @SuppressWarnings("unchecked")
    public List<Product> findProducts(String textToSearch) {

        FullTextSession fullTextSession = Search.getFullTextSession(getSession());

        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(Product.class).get();
        org.apache.lucene.search.Query query = qb
                .keyword().onFields("name", "serialNumber")
                .matching(textToSearch)
                .createQuery();

        org.hibernate.Query hibQuery =
                fullTextSession.createFullTextQuery(query, Product.class);

        List<Product> results = hibQuery.list();
        return results;
    }

}
