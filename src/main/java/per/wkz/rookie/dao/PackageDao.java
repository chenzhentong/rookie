package per.wkz.rookie.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import per.wkz.rookie.bean.Package;
import per.wkz.rookie.bean.PackageSearchCriteria;

import java.util.List;

@Mapper
public interface PackageDao {

    Package getPackageDetailById(int id);//根据id获取包裹的详细信息
    Package getPackageById(int id);//根据id获取包裹信息
    List<Package> getAllPackagesBySenderId(@Param("senderId") int senderId);//根据发件人id获取包裹
    List<Package> getAllPackagesByReceiverId(@Param("receiverId") int receiverId);//根据收件人id获取包裹
    Integer addPackage(Package pk);//添加包裹
    List<Package> getPackageByCriteria(PackageSearchCriteria packageSearchCriteria);//根据条件查询包裹
    Integer updatePackage(Package pk);//更新包裹信息

}
