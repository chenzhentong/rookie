package per.wkz.rookie.dao;

import org.apache.ibatis.annotations.Mapper;
import per.wkz.rookie.bean.Logistics;
import per.wkz.rookie.bean.LogisticsSearchCriteria;

import java.util.List;

@Mapper
public interface LogisticsDao {
    Integer updateLogistics(Logistics logistics);
    int addLogistics(Logistics logistics);
    List<Logistics> selectLogisticsByCriteria(LogisticsSearchCriteria logisticsSearchCriteria);
}
