package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO.MentorDAOHibernateImpl;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MentorServiceImpl implements mentorService{

    @Autowired
    MentorDAOHibernateImpl mentorDAOHibernate;

    @Override
    @Transactional
    public void addMentor(Mentor mentor) {
        mentorDAOHibernate.addMentor(mentor);
    }

    @Override
    @Transactional
    public List<Mentor> listMentors() {
        return mentorDAOHibernate.listMentors();
    }

    @Override
    @Transactional
    public Mentor getMentorById(String mentorId) {
        return mentorDAOHibernate.getMentorById(mentorId);
    }
}
