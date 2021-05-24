package per.wkz.rookie.service;


import per.wkz.rookie.bean.Package;
import per.wkz.rookie.bean.PackageSearchCriteria;

import java.util.List;

public interface PackageService {
    Package getPackageById(int id);
    Package getPackageDetailById(int id);

    List<Package> getAllPackagesBySenderId( int senderId);//根据发件人id获取包裹
    List<Package> getAllPackagesByReceiverId(int receiverId);//根据收件人id获取包裹

    Integer addPackage(Package pk);
    List<Package> getPackageByCriteria(PackageSearchCriteria packageSearchCriteria);
    Integer updatePackage(Package pk);
    List<Package> getPackageByDeliveryId(int deliveryId);//根据所有配送人id获取包裹

    List<Package> getAllPackageNotDeliveryed();
}
