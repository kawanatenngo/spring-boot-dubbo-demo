package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {

    /***
     * 增加Brand
     * @param brand
     * @return
     */
    int add(Brand brand);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Brand
     * @param brand
     * @return
     */
    int modify(Brand brand);

    /***
     * 根据ID查询Brand
     * @param id
     * @return
     */
    Brand getById(Long id);

    /***
     * 查询所有Brand
     * @return
     */
    PageInfo<Brand> getAll(Integer pageNum, Integer size, Brand brand);

}
