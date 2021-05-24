package per.wkz.rookie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package {
    private int id;

    private Date createDate;//创建时间

    private Date updateDate;//更新时间

    private Date sendDate;//发送时间

   // private Date preArriveDate;//预计到达时间

    private Date arriveDate;//到达时间

    private Date takeDate;//取件时间

    private int state;//包裹当前状态，0表示未发货，1表示运输中，2待取件，3已取件

    private OrdersDetail ordersDetail;//订单

    private User sender;//寄件人

    private User receiver;//收件人

    private User deliver;//配送人

    private City sendAddress;//寄件地址

    private City deliveryAddress;//收件地址


    private double freight;//运费

    private Integer senderId;

    private Integer receiverId;

    private Integer deliverId;

    private Integer sendAddressId;

    private Integer deliveryAddressId;

    private Integer ordersDetailId;

    private List<Logistics> logisticsList;
    //    public double getFreight() { //计算运费
//        double weight = this.getOrdersDetail().getGoods().getWeight() * this.getOrdersDetail().getNum();//获取商品重量
//        if (sentAddress.getProvince().getId() == sentAddress.getProvince().getId()){ //如果同省
//            double firstWeight = sentAddress.getProvince().getFirstWeight();
//            double firstWeightFee = sentAddress.getProvince().getFirstWeightFee();
//            double additionalWeightFee =  sentAddress.getProvince().getAdditionalWeightFee();
//            if (weight <= firstWeight) {
//                freight =  firstWeightFee ;
//            } else {
//                freight = firstWeightFee + (weight - firstWeight) * additionalWeightFee;
//            }
//
//        } else { //如果不同省
//            double firstWeight2 = sentAddress.getProvince().getFirstWeight2();
//            double firstWeightFee2 = sentAddress.getProvince().getFirstWeightFee2();
//            double additionalWeightFee2 =  sentAddress.getProvince().getAdditionalWeightFee2();
//            if (weight <= firstWeight2) {
//                freight =  firstWeightFee2 ;
//            } else {
//                freight = firstWeightFee2 + (weight - firstWeight2) * additionalWeightFee2;
//            }
//        }
//        return freight;
//    }
//
    /*
     *
     * 快递运费基于重量进行计算，各快递公司不同，运费计算基本规则如下：
     * 省内首重即1kg 一般是8元，超过1kg即续重为2元。
     * 外省首重8-12元，续重3-10元不等，地方不同，价格也不一样
     * 当需寄递物品实际重量小而体积较大，运费需按材积标准收取，运费计算方法为：首重运费+(重量(公斤)×2-1)×续重运费。
     *
     * */
    public double getFreightByWeight(Double weight) { //计算运费通过重量
        if (sendAddress.getProvince().getId() == sendAddress.getProvince().getId()) { //如果同省
            double firstWeight = sendAddress.getProvince().getFirstWeight();
            double firstWeightFee = sendAddress.getProvince().getFirstWeightFee();
            double additionalWeightFee = sendAddress.getProvince().getAdditionalWeightFee();
            if (weight <= firstWeight) {
                freight = firstWeightFee;
            } else {
                freight = firstWeightFee + (weight - firstWeight) * additionalWeightFee;
            }

        } else { //如果不同省
            double firstWeight2 = sendAddress.getProvince().getFirstWeight2();
            double firstWeightFee2 = sendAddress.getProvince().getFirstWeightFee2();
            double additionalWeightFee2 = sendAddress.getProvince().getAdditionalWeightFee2();
            if (weight <= firstWeight2) {
                freight = firstWeightFee2;
            } else {
                freight = firstWeightFee2 + (weight - firstWeight2) * additionalWeightFee2;
            }
        }
        return freight;
    }

    public static double getFreightByWeightAndProvince(Double weight, Province sentProvince, Province receiverProvince) { //计算运费通过重量
        Double freight = 0.0;
        if (sentProvince.getId() == receiverProvince.getId()) { //如果同省
            double firstWeight = sentProvince.getFirstWeight();
            double firstWeightFee = sentProvince.getFirstWeightFee();
            double additionalWeightFee = sentProvince.getAdditionalWeightFee();
            if (weight <= firstWeight) {
                freight = firstWeightFee;
            } else {
                freight = firstWeightFee + (weight - firstWeight) * additionalWeightFee;
            }

        } else { //如果不同省
            double firstWeight2 = sentProvince.getFirstWeight2();
            double firstWeightFee2 = sentProvince.getFirstWeightFee2();
            double additionalWeightFee2 = sentProvince.getAdditionalWeightFee2();
            if (weight <= firstWeight2) {
                freight = firstWeightFee2;
            } else {
                freight = firstWeightFee2 + (weight - firstWeight2) * additionalWeightFee2;
            }
        }
        return freight;
    }


}
