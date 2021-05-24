package per.wkz.rookie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.wkz.rookie.bean.*;
import per.wkz.rookie.bean.Package;
import per.wkz.rookie.service.LogisticsService;
import per.wkz.rookie.service.PackageService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/logistics")
@Slf4j
public class LogisticsController {


    @Autowired
    private PackageService packageService;
    @Autowired
    private LogisticsService logisticsService;

    @PostMapping("/add")
    public CommonResult<Integer> addLogistics(@RequestBody LogisticsSearchCriteria logisticsSearchCriteria, HttpSession session) {
        User user = (User)session.getAttribute("user");
        if (user==null) {
            return new CommonResult(401, "您还未登录，请登录后再操作");
        }
        Package pk = new Package();
        pk.setId(logisticsSearchCriteria.getPackageId());
        pk.setUpdateDate(new Date());
        pk.setDeliverId(user.getId());
        pk.setState(logisticsSearchCriteria.getPackageState());
        Integer row = packageService.updatePackage(pk);
        if (row!= 1) {
            return new CommonResult<>(200, "包裹更新失败");
        }
        Logistics logistics = new Logistics();
        logistics.setMessage(logisticsSearchCriteria.getMessage());
        logistics.setPackageId(logisticsSearchCriteria.getPackageId());
         row = logisticsService.addLogistics(logistics);
        if (row == 1) {
            return new CommonResult<>(200, "物流信息更新成功,logisticsId= " + logistics.getId());
        } else {
            return new CommonResult<>(444, "添加失败");
        }
    }

    @GetMapping("/search")
    public CommonResult<List<Logistics>> selectLogisticsByCriteria(@RequestParam("packageId") Integer packageId) {

        LogisticsSearchCriteria logisticsSearchCriteria = new LogisticsSearchCriteria();
        logisticsSearchCriteria.setPackageId(packageId);
        List<Logistics> logisticsList = logisticsService.selectLogisticsByCriteria(logisticsSearchCriteria);
        if (logisticsList != null) {
            return new CommonResult<>(200, "搜索成功，搜索到" + logisticsList.size() + "条结果", logisticsList);
        } else {
            return new CommonResult<>(444, "搜索失败");
        }
    }
    @PostMapping("/update")
    public CommonResult<Boolean> updateLogistics(@RequestBody Logistics logistics) {
        Integer row = logisticsService.updateLogistics(logistics);
        if (row == 1) {
            return new CommonResult<>(200, "物流信息更新成功,logisticsId= " + logistics.getId(),true);
        } else {
            return new CommonResult<>(444, "更新失败");
        }
    }

}
