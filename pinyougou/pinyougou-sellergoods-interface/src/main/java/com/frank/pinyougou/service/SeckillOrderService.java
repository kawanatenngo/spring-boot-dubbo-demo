package com.frank.pinyougou.service;

import com.frank.pinyougou.model.SeckillOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SeckillOrderService {

    /***
     * 增加SeckillOrder
     * @param seckillOrder
     * @return
     */
    int add(SeckillOrder seckillOrder);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改SeckillOrder
     * @param seckillOrder
     * @return
     */
    int modify(SeckillOrder seckillOrder);

    /***
     * 根据ID查询SeckillOrder
     * @param id
     * @return
     */
    SeckillOrder getById(Long id);

    /***
     * 查询所有SeckillOrder
     * @return
     */
    PageInfo<SeckillOrder> getAll(Integer pageNum, Integer size, SeckillOrder seckillOrder);

}
