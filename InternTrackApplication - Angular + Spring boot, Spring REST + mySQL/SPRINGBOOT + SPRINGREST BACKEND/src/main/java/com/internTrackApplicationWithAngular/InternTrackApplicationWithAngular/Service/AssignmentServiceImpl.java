package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO.AssignmentDAOHibernateImpl;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentServiceImpl implements assignmentService{
    @Autowired
    AssignmentDAOHibernateImpl assignmentDAOHibernate;


    @Override
    @Transactional
    public void addAssignment(Assignment assignment) {
        assignmentDAOHibernate.addAssignment(assignment);
    }

    @Override
    @Transactional
    public void updateAssignmentStatus(int assignmentID) {
        assignmentDAOHibernate.updateAssignmentStatus(assignmentID);
    }

    @Override
    @Transactional
    public List<Assignment> listAssignmentsByInternId(String internId) {
        return assignmentDAOHibernate.listAssignmentsByInternId(internId);
    }

    @Override
    @Transactional
    public Assignment getAssignmentById(int assignmentId) {
        return assignmentDAOHibernate.getAssignmentById(assignmentId);
    }
}
