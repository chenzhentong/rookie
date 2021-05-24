package per.wkz.rookie.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import per.wkz.rookie.bean.OrdersDetail;

@Mapper
public interface OrdersDetailDao {

    OrdersDetail getOrdersDetailById(@Param("id") int id);
    Integer addOrdersDetail(OrdersDetail ordersDetail);
}
