package per.wkz.rookie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wkz.rookie.bean.OrdersDetail;
import per.wkz.rookie.dao.OrdersDetailDao;
import per.wkz.rookie.service.OrdersDetailService;

@Service
public class OrdersDetailServiceImpl implements OrdersDetailService {

    @Autowired
    private OrdersDetailDao ordersDetailDao;

    @Override
    public OrdersDetail getOrdersDetailById(int id) {
        return ordersDetailDao.getOrdersDetailById(id);
    }

    @Override
    public Integer addOrdersDetail(OrdersDetail ordersDetail) {
        return ordersDetailDao.addOrdersDetail(ordersDetail);
    }
}
