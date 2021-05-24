package per.wkz.rookie.service;


import per.wkz.rookie.bean.OrdersDetail;

public interface OrdersDetailService {
    OrdersDetail getOrdersDetailById( int id);
    Integer addOrdersDetail(OrdersDetail ordersDetail);
}
