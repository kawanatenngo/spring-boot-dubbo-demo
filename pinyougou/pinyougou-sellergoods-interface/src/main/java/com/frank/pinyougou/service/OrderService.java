package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {

    /***
     * 增加Order
     * @param order
     * @return
     */
    int add(Order order);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Order
     * @param order
     * @return
     */
    int modify(Order order);

    /***
     * 根据ID查询Order
     * @param id
     * @return
     */
    Order getById(Long id);

    /***
     * 查询所有Order
     * @return
     */
    PageInfo<Order> getAll(Integer pageNum, Integer size, Order order);

}
