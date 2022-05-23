package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Assignment;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AssignmentDAOHibernateImpl implements assignmentDAO{
    //Field for entityManager and Injecting Dependency
    @Autowired
    private EntityManager entityManager;


    @Override
    public void addAssignment(Assignment assignment) {
        entityManager.unwrap(Session.class).saveOrUpdate(assignment);
    }

    @Override
    public void updateAssignmentStatus(int assignmentID) {
            Assignment assignment = entityManager.unwrap(Session.class).get(Assignment.class, assignmentID);
            assignment.setAssignmentStatus("Complete");
            entityManager.unwrap(Session.class).saveOrUpdate(assignment);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Assignment> listAssignmentsByInternId(String internId) {
        return entityManager.unwrap(Session.class).createQuery("FROM Assignment WHERE givenTo=:internId").setParameter("internId", internId).list();
    }

    @Override
    public Assignment getAssignmentById(int assignmentId) {
        return entityManager.unwrap(Session.class).get(Assignment.class, assignmentId);
    }
}
