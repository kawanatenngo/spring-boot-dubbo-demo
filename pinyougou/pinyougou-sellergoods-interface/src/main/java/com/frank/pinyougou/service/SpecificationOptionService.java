package com.frank.pinyougou.service;

import com.frank.pinyougou.model.SpecificationOption;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SpecificationOptionService {

    /***
     * 增加SpecificationOption
     * @param specificationOption
     * @return
     */
    int add(SpecificationOption specificationOption);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改SpecificationOption
     * @param specificationOption
     * @return
     */
    int modify(SpecificationOption specificationOption);

    /***
     * 根据ID查询SpecificationOption
     * @param id
     * @return
     */
    SpecificationOption getById(Long id);

    /***
     * 查询所有SpecificationOption
     * @return
     */
    PageInfo<SpecificationOption> getAll(Integer pageNum, Integer size, SpecificationOption specificationOption);

}
