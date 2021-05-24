package per.wkz.rookie.service;
import per.wkz.rookie.bean.Goods;

public interface GoodsService {
    Goods getGoodsById(Integer id);
    Integer addGoods(Goods goods);

}
