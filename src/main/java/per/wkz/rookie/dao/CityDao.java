package per.wkz.rookie.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import per.wkz.rookie.bean.City;

import java.util.List;

@Mapper
public interface CityDao {
    City getCityProvinceDetailById(@Param("id")Integer id);
    City getCityById(@Param("id")Integer id);
    List<City> getAllCities();
}
