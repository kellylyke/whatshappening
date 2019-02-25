package com.kellylyke.persistence;

import com.kellylyke.entity.Preference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;

public class PreferenceDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all preferences
     *
     * @return the all preferences
     */
    public List<Preference> getAllPreferences() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Preference> query = builder.createQuery(Preference.class);
        Root<Preference> root = query.from(Preference.class);
        List<Preference> preference = session.createQuery(query).getResultList();
        session.close();
        return preference;
    }


    /**
     * Gets a preference by id
     * @param id reference id to search by
     * @return a preference
     */
    public Preference getById(int id) {
        Session session = sessionFactory.openSession();
        Preference preference = session.get(Preference.class, id);
        session.close();
        return preference;
    }

    /**
     * update preference
     * @param preference to be inserted or updated
     */
    public void saveOrUpdate(Preference preference) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(preference);
        transaction.commit();
        session.close();
    }

    /**
     * update preference
     * @param preference preference to be inserted or updated
     * @return id of the inserted preference
     */
    public int insert(Preference preference) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(preference);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a preference
     * @param preference Preference to be deleted
     */
    public void delete(Preference preference) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(preference);
        transaction.commit();
        session.close();
    }


    /**
     * Get preference by property (exact match)
     * sample usage: getByPropertyEqual("description", "books")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of preferences meeting the criteria search
     */
    public List<Preference> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for preference with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Preference> query = builder.createQuery( Preference.class );
        Root<Preference> root = query.from( Preference.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Preference> preferences = session.createQuery( query ).getResultList();

        session.close();
        return preferences;
    }

    /**
     * Get preference by property (like)
     * sample usage: getByPropertyLike("description", "books")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of preferences meeting the criteria search
     */
    public List<Preference> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for preference with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Preference> query = builder.createQuery( Preference.class );
        Root<Preference> root = query.from( Preference.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Preference> preferences = session.createQuery( query ).getResultList();
        session.close();
        return preferences;
    }


}

