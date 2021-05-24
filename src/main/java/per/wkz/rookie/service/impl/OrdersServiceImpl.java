package per.wkz.rookie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wkz.rookie.bean.Orders;
import per.wkz.rookie.dao.OrdersDao;
import per.wkz.rookie.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public int addOrders(Orders orders) {
        return   ordersDao.addOrders(orders);

    }
}
