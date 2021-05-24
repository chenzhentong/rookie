package per.wkz.rookie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wkz.rookie.bean.CommonResult;
import per.wkz.rookie.bean.OrdersDetail;
import per.wkz.rookie.service.OrdersDetailService;

@RestController
@Slf4j
public class OrdersDetailController {

    @Autowired
    private OrdersDetailService ordersDetailService;

    @RequestMapping("/ordersDetail/{id}")
    public CommonResult<OrdersDetail> getOrdersDetailById(@PathVariable("id") Integer id) {
        OrdersDetail ordersDetail = ordersDetailService.getOrdersDetailById(id);
        if (ordersDetail != null) {
            return new CommonResult<>(200, "查询到信息", ordersDetail);
        } else {
            return new CommonResult<>(444, "未查询到", null);
        }
    }

    @RequestMapping("/ordersDetail/add")
    public CommonResult addOrdersDetail(@RequestBody OrdersDetail ordersDetail) {
        Integer ordersDetail1Id = ordersDetailService.addOrdersDetail(ordersDetail);
        if (ordersDetail1Id != null) {
            return new CommonResult(200, "添加成功，id=" + ordersDetail1Id);
        } else {
            return new CommonResult(444, "添加失败");
        }
    }


}
