package com.frank.pinyougou.service;

import com.frank.pinyougou.model.OrderItem;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderItemService {

    /***
     * 增加OrderItem
     * @param orderItem
     * @return
     */
    int add(OrderItem orderItem);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改OrderItem
     * @param orderItem
     * @return
     */
    int modify(OrderItem orderItem);

    /***
     * 根据ID查询OrderItem
     * @param id
     * @return
     */
    OrderItem getById(Long id);

    /***
     * 查询所有OrderItem
     * @return
     */
    PageInfo<OrderItem> getAll(Integer pageNum, Integer size, OrderItem orderItem);

}
