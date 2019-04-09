package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Seller;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SellerService {

    /***
     * 增加Seller
     * @param seller
     * @return
     */
    int add(Seller seller);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Seller
     * @param seller
     * @return
     */
    int modify(Seller seller);

    /***
     * 根据ID查询Seller
     * @param id
     * @return
     */
    Seller getById(Long id);

    /***
     * 查询所有Seller
     * @return
     */
    PageInfo<Seller> getAll(Integer pageNum, Integer size, Seller seller);

}
