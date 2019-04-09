package com.frank.pinyougou.service;

import com.frank.pinyougou.model.SeckillGoods;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SeckillGoodsService {

    /***
     * 增加SeckillGoods
     * @param seckillGoods
     * @return
     */
    int add(SeckillGoods seckillGoods);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改SeckillGoods
     * @param seckillGoods
     * @return
     */
    int modify(SeckillGoods seckillGoods);

    /***
     * 根据ID查询SeckillGoods
     * @param id
     * @return
     */
    SeckillGoods getById(Long id);

    /***
     * 查询所有SeckillGoods
     * @return
     */
    PageInfo<SeckillGoods> getAll(Integer pageNum, Integer size, SeckillGoods seckillGoods);

}
