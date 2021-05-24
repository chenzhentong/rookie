package per.wkz.rookie.dao;

import org.apache.ibatis.annotations.Mapper;
import per.wkz.rookie.bean.Orders;

@Mapper
public interface OrdersDao {
    int addOrders(Orders orders);
}
