package com.frank.pinyougou.service;

import com.frank.pinyougou.model.ItemCat;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ItemCatService {

    /***
     * 增加ItemCat
     * @param itemCat
     * @return
     */
    int add(ItemCat itemCat);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改ItemCat
     * @param itemCat
     * @return
     */
    int modify(ItemCat itemCat);

    /***
     * 根据ID查询ItemCat
     * @param id
     * @return
     */
    ItemCat getById(Long id);

    /***
     * 查询所有ItemCat
     * @return
     */
    PageInfo<ItemCat> getAll(Integer pageNum, Integer size, ItemCat itemCat);

}
