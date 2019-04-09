package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Cities;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CitiesService {

    /***
     * 增加Cities
     * @param cities
     * @return
     */
    int add(Cities cities);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Cities
     * @param cities
     * @return
     */
    int modify(Cities cities);

    /***
     * 根据ID查询Cities
     * @param id
     * @return
     */
    Cities getById(Long id);

    /***
     * 查询所有Cities
     * @return
     */
    PageInfo<Cities> getAll(Integer pageNum, Integer size, Cities cities);

}
