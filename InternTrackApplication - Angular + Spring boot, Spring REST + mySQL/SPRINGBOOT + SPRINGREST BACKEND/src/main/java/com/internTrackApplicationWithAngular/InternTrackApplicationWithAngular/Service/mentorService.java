package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Mentor;

import java.util.List;

public interface mentorService {
    public void addMentor(Mentor mentor);
    public List<Mentor> listMentors();
    public Mentor getMentorById(String mentorId);
}
