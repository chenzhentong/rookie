package per.wkz.rookie.service;

import per.wkz.rookie.bean.City;

import java.util.List;

public interface CityService {

    City getCityProvinceDetailById(Integer id);
    City getCityById(Integer id);
    List<City> getAllCities();
}
