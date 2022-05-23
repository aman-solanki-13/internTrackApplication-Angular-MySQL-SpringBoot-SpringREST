package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Assignment;

import java.util.List;

public interface assignmentService {
    public void addAssignment(Assignment assignment);
    public void updateAssignmentStatus(int assignmentID);
    public List<Assignment> listAssignmentsByInternId(String internId);
    public Assignment getAssignmentById(int assignmentId);
}
