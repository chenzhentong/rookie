package per.wkz.rookie.service;


import per.wkz.rookie.bean.Province;

import java.util.List;

public interface ProvinceService {



    Province getProvinceById(Integer id);
    List<Province> getAllProvinces();
    Double getFreight(int sentAddressId,int deliveryAddressId,double weight);
}
