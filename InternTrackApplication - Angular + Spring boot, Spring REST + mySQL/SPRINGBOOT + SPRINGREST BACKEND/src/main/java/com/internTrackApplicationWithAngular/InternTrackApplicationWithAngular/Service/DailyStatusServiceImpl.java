package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO.DailyStatusDAOHibernateImpl;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.DailyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DailyStatusServiceImpl implements dailyStatusService{
    @Autowired
    DailyStatusDAOHibernateImpl dailyStatusDAOHibernate;

    @Override
    @Transactional
    public void addStatus(DailyStatus dailyStatus) {
        dailyStatusDAOHibernate.addStatus(dailyStatus);
    }

    @Override
    @Transactional
    public List<DailyStatus> listDailyStatusByInternId(String statusOf) {
        return dailyStatusDAOHibernate.listDailyStatusByInternId(statusOf);
    }
}
