package per.wkz.rookie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wkz.rookie.bean.Logistics;
import per.wkz.rookie.bean.LogisticsSearchCriteria;
import per.wkz.rookie.dao.LogisticsDao;
import per.wkz.rookie.service.LogisticsService;

import java.util.List;

@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Autowired
    private LogisticsDao logisticsDao;

    @Override
    public Integer updateLogistics(Logistics logistics) {
        return logisticsDao.updateLogistics(logistics);
    }

    @Override
    public Integer addLogistics(Logistics logistics) {
        return logisticsDao.addLogistics(logistics);
    }

    @Override
    public List<Logistics> selectLogisticsByCriteria(LogisticsSearchCriteria logisticsSearchCriteria) {
        return logisticsDao.selectLogisticsByCriteria(logisticsSearchCriteria);
    }
}
