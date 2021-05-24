package per.wkz.rookie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wkz.rookie.bean.Package;
import per.wkz.rookie.bean.PackageSearchCriteria;
import per.wkz.rookie.dao.PackageDao;
import per.wkz.rookie.service.PackageService;

import java.util.List;
@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageDao packageDao;

    @Override
    public Package getPackageById(int id) {
        return packageDao.getPackageById(id);
    }

    @Override
    public Package getPackageDetailById(int id) {
        return packageDao.getPackageDetailById(id);
    }

    @Override
    public List<Package> getAllPackagesBySenderId(int senderId) {
        return packageDao.getAllPackagesBySenderId(senderId);
    }

    @Override
    public List<Package> getAllPackagesByReceiverId(int receiverId) {
        return packageDao.getAllPackagesByReceiverId(receiverId);
    }

    @Override
    public Integer addPackage(Package pk) {
        return packageDao.addPackage(pk);
    }

    @Override
    public List<Package> getPackageByCriteria(PackageSearchCriteria packageSearchCriteria) {
        return packageDao.getPackageByCriteria(packageSearchCriteria);
    }

    @Override
    public Integer updatePackage(Package pk) {
        return packageDao.updatePackage(pk);
    }

    @Override
    public List<Package> getPackageByDeliveryId(int deliveryId) {
        PackageSearchCriteria packageSearchCriteria = new PackageSearchCriteria();
        packageSearchCriteria.setDeliverId(deliveryId);
        return packageDao.getPackageByCriteria(packageSearchCriteria);
    }

    @Override
    public List<Package> getAllPackageNotDeliveryed() {
        PackageSearchCriteria packageSearchCriteria = new PackageSearchCriteria();
        packageSearchCriteria.setIsHasDeliveryed(true);
        return packageDao.getPackageByCriteria(packageSearchCriteria);
    }
}


