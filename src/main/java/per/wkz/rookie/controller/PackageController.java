package per.wkz.rookie.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.wkz.rookie.bean.*;
import per.wkz.rookie.bean.Package;
import per.wkz.rookie.service.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/package")
@Slf4j
public class PackageController {

    @Autowired
    private PackageService packageService;

    @Autowired
    private OrdersDetailService ordersDetailService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrdersService ordersService;


    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private LogisticsService logisticsService;

    @RequestMapping("/freight/count")//计算运费
    public CommonResult calculateFreight(@RequestParam("sentAddressId") Integer sentAddressId, @RequestParam("deliveryAddressId") Integer deliveryAddressId,
                             @RequestParam("weight") Double weight) {
        log.info(sentAddressId.toString());
        log.info(deliveryAddressId.toString());
        log.info(weight.toString());
        Province province1 = provinceService.getProvinceById(sentAddressId);
        Province province2 = provinceService.getProvinceById(deliveryAddressId);
        Double freight = Package.getFreightByWeightAndProvince(weight, province1, province2);
        if (freight != 0.0) {
            if (sentAddressId == deliveryAddressId) {
                return new CommonResult<>(200, "两城市在同一省内，按照本省的省内运费计算，" + province1.getName() + "省内首重为" + province1.getFirstWeight() + "kg,省内首重运费为" + province1.getFirstWeightFee() + "元，省内续重运费为" + province1.getAdditionalWeightFee() + "元," + weight + "kg的物品:" + "从" + province1.getName() + "到" + province2.getName() + "的运费为:" + freight + "元", freight);
            } else {
                return new CommonResult<>(200, "两城市不在同一省内，按照本省的省外运费计算，" + province1.getName() + "省外首重为" + province1.getFirstWeight2() + "kg,省外首重运费为" + province1.getFirstWeightFee2() + "元，省外续重运费为" + province1.getAdditionalWeightFee2() + "元," + weight + "kg的物品:" + "从" + province1.getName() + "到" + province2.getName() + "的运费为:" + freight + "元", freight);
            }
        } else {
            return new CommonResult<>(444, "相关城市或省份信息未录入", null);
        }
    }


    @RequestMapping("/sender")
    public CommonResult<List<Package>> sentPackages(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new CommonResult(401, "您还未登录，请登录后再操作");
        }
        List<Package> packageList = packageService.getAllPackagesBySenderId(user.getId());
        if (packageList != null) {
            log.info(packageList.toString());
            return new CommonResult<>(200, "用户ID=" + user.getId() + "有" + packageList.size() + "个寄件", packageList);
        } else {
            return new CommonResult<>(444, "未查询相关包裹信息", null);
        }
    }

    @RequestMapping("/receiver")
    public CommonResult<List<Package>> receivedPackages(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new CommonResult(401, "您还未登录，请登录后再操作");
        }
        List<Package> packageList = packageService.getAllPackagesByReceiverId(user.getId());
        if (packageList != null) {
            return new CommonResult<>(200, "用户ID=" + user.getId() + "共收到" + packageList.size() + "个件", packageList);
        } else {
            return new CommonResult<>(444, "未查询相关包裹信息", null);
        }
    }

    @RequestMapping("/{id}")
    public CommonResult<Package> getPackageDetailById(@PathVariable("id") int id) {
        Package aPackage = packageService.getPackageDetailById(id);
        if (aPackage != null) {
            return new CommonResult<>(200, "查询成功", aPackage);
        } else {
            return new CommonResult<>(444, "未查询到", null);
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public CommonResult<Integer> addPackage(@RequestParam("sentAddressId") Integer sentAddressId,
                                            @RequestParam("deliveryAddressId") Integer deliveryAddressId,
                                            @RequestParam("num") Integer num,
                                            @RequestParam("weight") Double weight,
                                            @RequestParam("goodsName") String goodsName,
                                            @RequestParam("receiverId") Integer receiverId,
                                            HttpSession session) {
        log.info(sentAddressId.toString());
        log.info(deliveryAddressId.toString());
        log.info(num.toString());
        log.info(weight.toString());
        log.info(goodsName);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new CommonResult(401, "您还未登录，请登录后再操作");
        }

        Goods goods = new Goods();
        goods.setName(goodsName);
        goods.setWeight(weight);

//        goods.setPersonal(true);
//        goods.setUserId(user.getId());

        int row = goodsService.addGoods(goods);
        if (row != 1) {
            return new CommonResult<>(444, "添加物品失败");
        }
        log.info("goodsId:" + goods.getId());
        Orders orders = new Orders();
        orders.setName("orders");
        orders.setUserId(user.getId());

        row = ordersService.addOrders(orders);
        if (row != 1) {
            return new CommonResult<>(444, "添加orders失败");
        }
        log.info("ordersId:" + orders.getId());
        OrdersDetail ordersDetail = new OrdersDetail();
        ordersDetail.setGoodsId(goods.getId());
        ordersDetail.setOrdersId(orders.getId());
        ordersDetail.setNum(num);
        row = ordersDetailService.addOrdersDetail(ordersDetail);
        if (row != 1) {
            return new CommonResult<>(444, "添加ordersDetail失败");
        }
        log.info("ordersDetailId:" + ordersDetail.getId());
        Package pk = new Package();
        pk.setSendAddressId(sentAddressId);
        pk.setDeliveryAddressId(deliveryAddressId);
        pk.setSenderId(user.getId());
        pk.setReceiverId(receiverId);
        pk.setState(0);
        pk.setSendDate(new Date());
        Province province1 = provinceService.getProvinceById(sentAddressId);
        Province province2 = provinceService.getProvinceById(deliveryAddressId);
        Double freight = Package.getFreightByWeightAndProvince(weight, province1, province2);
        pk.setFreight(freight * num);
        log.info("freight:" + freight);
        pk.setOrdersDetailId(ordersDetail.getId());
        row = packageService.addPackage(pk);
        log.info("packageId:" + pk.getId());
        if (row != 1) {
            return new CommonResult<>(444, "添加package失败");
        } else {
            Logistics logistics = new Logistics();
            logistics.setPackageId(pk.getId());
            logistics.setCreateDate(new Date());
            logistics.setMessage("您的包裹正在等待揽收");
            logisticsService.addLogistics(logistics);

            return new CommonResult<>(200, "添加成功,packageId=" + pk.getId(), pk.getId());
        }

    }

    @PostMapping(value = "/update")
    public CommonResult<Integer> updatePackage(@RequestBody Package pk) {
        log.info(pk.toString());
        Integer row = packageService.updatePackage(pk);
        if (row == 1) {
            return new CommonResult<>(200, "更新成功", row);
        } else {
            return new CommonResult<>(444, "更新失败");
        }
    }

    @RequestMapping("/search")
    public CommonResult<List<Package>> getPackagesByCriteria(@RequestParam(value = "packageId",required = false) Integer packageId,
                                                             @RequestParam(value = "phone",required = false)String  phone,
                                                             @RequestParam(value = "IDCard",required = false)String IDCard,
                                                             HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new CommonResult(401, "您还未登录，请登录后再操作");
        }
//        log.info(packageId.toString());
//        log.info(phone);
//        log.info(IDCard);

        PackageSearchCriteria packageSearchCriteria = new PackageSearchCriteria();
        if (packageId!=null) {
            packageSearchCriteria.setPackageId(packageId);
        }

        if (phone!=null) {
            packageSearchCriteria.setSenderPhone(phone);
        }
        if (IDCard!=null) {
            packageSearchCriteria.setSenderIDCard(IDCard);
        }

        packageSearchCriteria.setUserId(user.getId());
        List<Package> packageList = packageService.getPackageByCriteria(packageSearchCriteria);
        if (packageList != null) {
            return new CommonResult<>(200, "查询成功", packageList);
        } else {
            return new CommonResult<>(444, "未查询到", null);
        }
    }


    @RequestMapping("/deliver")
    public CommonResult<List<Package>> getPackageByDeliveryId(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new CommonResult(401, "您还未登录，请登录后再操作");
        }
        List<Package> packageList = packageService.getPackageByDeliveryId(user.getId());
        System.out.println(packageList);
        if (packageList != null) {
            return new CommonResult<>(200, "查询成功", packageList);
        } else {
            return new CommonResult<>(444, "未查询到", null);
        }
    }

    @RequestMapping("/notDeliveryed")
    public CommonResult getAllPackageNotDeliveryed() {
        List<Package> packageList = packageService.getAllPackageNotDeliveryed();
        System.out.println(packageList);
        if (packageList != null) {
            return new CommonResult<>(200, "查询成功", packageList);
        } else {
            return new CommonResult<>(444, "未查询到", null);
        }
    }
}
