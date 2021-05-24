package per.wkz.rookie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDetail {

    private int id;

    private Orders orders;//订单

    private Goods goods;//货物

    private int num;//货物数量


    private Integer goodsId;

    private Integer ordersId;


    private Date createDate;

    private Date updateDate;
    

}
