package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Mentor;

import java.util.List;

public interface mentorDAO {
    public void addMentor(Mentor mentor);
    public List<Mentor> listMentors();
    public Mentor getMentorById(String mentorId);
}
