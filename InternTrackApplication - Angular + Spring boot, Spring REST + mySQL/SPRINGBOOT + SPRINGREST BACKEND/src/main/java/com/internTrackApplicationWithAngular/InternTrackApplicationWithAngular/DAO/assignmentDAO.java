package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Assignment;

import java.util.List;

public interface assignmentDAO {
    public void addAssignment(Assignment assignment);
    public void updateAssignmentStatus(int assignmentID);
    public List<Assignment> listAssignmentsByInternId(String internId);
    public Assignment getAssignmentById(int assignmentId);
}
