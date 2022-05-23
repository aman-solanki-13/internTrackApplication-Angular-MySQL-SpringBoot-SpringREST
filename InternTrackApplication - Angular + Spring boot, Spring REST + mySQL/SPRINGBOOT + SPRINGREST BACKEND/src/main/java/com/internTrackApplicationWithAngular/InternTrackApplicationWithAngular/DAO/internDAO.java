package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Intern;

import java.util.List;

public interface internDAO {
    public void addIntern(Intern intern);
    public List<Intern> listInterns();
    public Intern getInternById(String internId);
}
