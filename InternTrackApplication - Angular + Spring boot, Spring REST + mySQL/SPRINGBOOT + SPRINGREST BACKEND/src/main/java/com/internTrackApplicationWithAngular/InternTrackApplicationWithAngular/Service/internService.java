package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Intern;

import java.util.List;

public interface internService {
    public void addIntern(Intern intern);
    public List<Intern> listInterns();
    public Intern getInternById(String internId);
}
