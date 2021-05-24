package per.wkz.rookie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wkz.rookie.bean.Package;
import per.wkz.rookie.bean.Province;
import per.wkz.rookie.dao.ProvinceDao;
import per.wkz.rookie.service.ProvinceService;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceDao provinceDao;

    @Override
    public Province getProvinceById(Integer id) {
        return provinceDao.getProvinceById(id);
    }

    @Override
    public List<Province> getAllProvinces() {
        return provinceDao.getAllProvinces();
    }

    @Override
    public Double getFreight(int senderId, int receiverId, double weight) {
        Province province1 = provinceDao.getProvinceById(senderId);
        Province province2 = provinceDao.getProvinceById(receiverId);
        return Package.getFreightByWeightAndProvince(weight, province1, province2);
    }
}
