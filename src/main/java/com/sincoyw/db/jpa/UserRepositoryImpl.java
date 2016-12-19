package com.sincoyw.db.jpa;

import com.sincoyw.db.UserRepository;
import com.sincoyw.domain.UserInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Created by Sincoyw on 2016/8/18.
 * Desc:
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceUnit(unitName = "user")
    private EntityManagerFactory entityManagerFactory;

    @Override
    public UserInfo save(UserInfo userInfo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(userInfo);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        return userInfo;
    }
}
