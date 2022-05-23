package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.DailyStatus;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DailyStatusDAOHibernateImpl implements dailyStatusDAO{
    //Field for entityManager and Injecting Dependency
    @Autowired
    private EntityManager entityManager;


    @Override
    public void addStatus(DailyStatus dailyStatus) {
        entityManager.unwrap(Session.class).saveOrUpdate(dailyStatus);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DailyStatus> listDailyStatusByInternId(String statusOf) {
        return entityManager.unwrap(Session.class).createQuery("FROM DailyStatus WHERE statusOf=:statusOf").setParameter("statusOf", statusOf).list();
    }
}
