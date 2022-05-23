package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Intern;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InternDAOHibernateImpl implements internDAO{
    //Field for entityManager and Injecting Dependency
    @Autowired
    private EntityManager entityManager;


    @Override
    public void addIntern(Intern intern) {
        entityManager.unwrap(Session.class).saveOrUpdate(intern);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Intern> listInterns() {
        return entityManager.unwrap(Session.class).createQuery("FROM Intern ").list();
    }

    @Override
    public Intern getInternById(String internId) {
        return entityManager.unwrap(Session.class).get(Intern.class, internId);
    }
}
