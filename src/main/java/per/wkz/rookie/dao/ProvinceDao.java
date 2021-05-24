package per.wkz.rookie.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import per.wkz.rookie.bean.Province;

import java.util.List;

@Mapper
public interface ProvinceDao {
    Province getProvinceById(@Param("id") int id);
    List<Province> getAllProvinces();
}
