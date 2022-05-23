package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Mentor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MentorDAOHibernateImpl implements mentorDAO{
    //Field for entityManager and Injecting Dependency
    @Autowired
    private EntityManager entityManager;


    @Override
    public void addMentor(Mentor mentor) {
        entityManager.unwrap(Session.class).saveOrUpdate(mentor);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Mentor> listMentors() {
        return entityManager.unwrap(Session.class).createQuery("FROM Mentor ").list();
    }

    @Override
    public Mentor getMentorById(String mentorId) {
        return entityManager.unwrap(Session.class).get(Mentor.class, mentorId);
    }
}
