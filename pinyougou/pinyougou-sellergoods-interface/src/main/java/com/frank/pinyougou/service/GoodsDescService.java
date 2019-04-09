package com.frank.pinyougou.service;

import com.frank.pinyougou.model.GoodsDesc;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsDescService {

    /***
     * 增加GoodsDesc
     * @param goodsDesc
     * @return
     */
    int add(GoodsDesc goodsDesc);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改GoodsDesc
     * @param goodsDesc
     * @return
     */
    int modify(GoodsDesc goodsDesc);

    /***
     * 根据ID查询GoodsDesc
     * @param id
     * @return
     */
    GoodsDesc getById(Long id);

    /***
     * 查询所有GoodsDesc
     * @return
     */
    PageInfo<GoodsDesc> getAll(Integer pageNum, Integer size, GoodsDesc goodsDesc);

}
