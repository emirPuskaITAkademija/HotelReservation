package app.business;

import app.business.model.User;
import app.controller.constants.Constants;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * 
 * ČISTI Hibernate:
 * SessionBeanFactory -> openSession() -> Session
 * <p>
 * JPA + ORM alat(EclipseLInk ili Hibernate)
 * EntityManagerFactory -> createEntityManager()-> EntityManager
 *
 *
 * @author Grupa2
 */
public class FacadeImplementation implements Facade {

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("User.findByUsernameAndPassword");
        query.setParameter("username", username);
        query.setParameter("password", password);
        try{
            User user = (User) query.getSingleResult();
            return user;
        }catch(NoResultException exception){
            System.err.format("Not exist user with username: %s", username);
            return null;
        }catch(NonUniqueResultException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PU_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
