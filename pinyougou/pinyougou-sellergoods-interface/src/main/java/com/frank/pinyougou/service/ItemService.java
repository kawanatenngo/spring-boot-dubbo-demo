package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Item;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ItemService {

    /***
     * 增加Item
     * @param item
     * @return
     */
    int add(Item item);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Item
     * @param item
     * @return
     */
    int modify(Item item);

    /***
     * 根据ID查询Item
     * @param id
     * @return
     */
    Item getById(Long id);

    /***
     * 查询所有Item
     * @return
     */
    PageInfo<Item> getAll(Integer pageNum, Integer size, Item item);

}
