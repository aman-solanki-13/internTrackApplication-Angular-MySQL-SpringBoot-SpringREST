package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO.InternDAOHibernateImpl;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Intern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InternServiceImpl implements internService{
    @Autowired
    InternDAOHibernateImpl internDAOHibernate;

    @Override
    @Transactional
    public void addIntern(Intern intern) {
        internDAOHibernate.addIntern(intern);
    }

    @Override
    @Transactional
    public List<Intern> listInterns() {
        return internDAOHibernate.listInterns();
    }

    @Override
    @Transactional
    public Intern getInternById(String internId) {
        return internDAOHibernate.getInternById(internId);
    }
}
