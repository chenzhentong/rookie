package per.wkz.rookie.service;

import per.wkz.rookie.bean.Logistics;
import per.wkz.rookie.bean.LogisticsSearchCriteria;

import java.util.List;

public interface LogisticsService {
    Integer updateLogistics(Logistics logistics);
    Integer addLogistics(Logistics logistics);
    List<Logistics> selectLogisticsByCriteria(LogisticsSearchCriteria logisticsSearchCriteria);
}
