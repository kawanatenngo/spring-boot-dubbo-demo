package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Provinces;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProvincesService {

    /***
     * 增加Provinces
     * @param provinces
     * @return
     */
    int add(Provinces provinces);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Provinces
     * @param provinces
     * @return
     */
    int modify(Provinces provinces);

    /***
     * 根据ID查询Provinces
     * @param id
     * @return
     */
    Provinces getById(Long id);

    /***
     * 查询所有Provinces
     * @return
     */
    PageInfo<Provinces> getAll(Integer pageNum, Integer size, Provinces provinces);

}
