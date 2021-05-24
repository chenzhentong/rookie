package per.wkz.rookie.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import per.wkz.rookie.bean.Goods;

@Mapper
public interface GoodsDao {

    Goods getGoodsById(@Param("id")Integer id);



    Integer addGoods(Goods goods);

}
