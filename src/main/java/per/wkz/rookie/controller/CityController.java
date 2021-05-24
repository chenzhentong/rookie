package per.wkz.rookie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import per.wkz.rookie.bean.City;
import per.wkz.rookie.bean.CommonResult;
import per.wkz.rookie.service.CityService;

import java.util.List;

@RestController
@Slf4j
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city/{cityId}")
    public CommonResult<City> getCityById(@PathVariable("cityId") Integer id) {
        City city = cityService.getCityProvinceDetailById(id);
        if (city != null) {
            return new CommonResult<>(200,"查询到城市id="+city.getId(),city);
        } else {
            return new CommonResult<>(444,"未查询到相关城市信息");
        }
    }

    @GetMapping("/city/all")
    public CommonResult<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        if (cities != null) {
            return new CommonResult<>(200,"查询到"+cities.size()+"条城市信息",cities);
        } else {
            return new CommonResult<>(444,"未查询到相关城市信息");
        }
    }


}
