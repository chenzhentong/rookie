package per.wkz.rookie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wkz.rookie.bean.City;
import per.wkz.rookie.dao.CityDao;
import per.wkz.rookie.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;


    @Override
    public City getCityProvinceDetailById(Integer id) {
        return cityDao.getCityProvinceDetailById(id);
    }

    @Override
    public City getCityById(Integer id) {
        return cityDao.getCityById(id);
    }

    @Override
    public List<City> getAllCities() {
        return cityDao.getAllCities();
    }
}
