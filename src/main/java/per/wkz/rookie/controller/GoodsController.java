package per.wkz.rookie.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wkz.rookie.bean.CommonResult;
import per.wkz.rookie.bean.Goods;
import per.wkz.rookie.service.GoodsService;

@RestController
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/goods/{goodsId}")
    public CommonResult<Goods> getGoodsById(@PathVariable("goodsId")Integer goodsId){
        Goods goods = goodsService.getGoodsById(goodsId);
        if (goods!=null) {
            return new CommonResult<>(200,"查询到物品" + goods.getName(),goods);
        } else {
            return new CommonResult<>(444,"未查询到相应的物品信息",null);
        }
    }

    @RequestMapping("/goods/add")
    public CommonResult addGoods(@RequestBody Goods goods) {
        Integer goodsId = goodsService.addGoods(goods);
        if (goodsId != null) {
            return new CommonResult(200,"添加货物成功,goodsId= " +goodsId);
        } else {
            return new CommonResult(444,"添加失败");
        }
    }

}
