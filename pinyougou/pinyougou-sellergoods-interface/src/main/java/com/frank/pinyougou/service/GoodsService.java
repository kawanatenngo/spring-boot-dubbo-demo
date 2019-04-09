package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Goods;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsService {

    /***
     * 增加Goods
     * @param goods
     * @return
     */
    int add(Goods goods);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Goods
     * @param goods
     * @return
     */
    int modify(Goods goods);

    /***
     * 根据ID查询Goods
     * @param id
     * @return
     */
    Goods getById(Long id);

    /***
     * 查询所有Goods
     * @return
     */
    PageInfo<Goods> getAll(Integer pageNum, Integer size, Goods goods);

}
