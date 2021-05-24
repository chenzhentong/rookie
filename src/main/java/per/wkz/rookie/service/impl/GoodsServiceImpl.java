package per.wkz.rookie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wkz.rookie.bean.Goods;
import per.wkz.rookie.dao.GoodsDao;
import per.wkz.rookie.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Goods getGoodsById(Integer id) {
        return goodsDao.getGoodsById(id);
    }

    @Override
    public Integer addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

}
