package per.wkz.rookie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    private int id;

    private String name;

    private User user;//用户

    private Date createDate;//创建时间

    private Date updateDate;//更新时间

    private List<OrdersDetail> ordersDetailList;//订单详情

    private Integer userId;


}
