package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Specification;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SpecificationService {

    /***
     * 增加Specification
     * @param specification
     * @return
     */
    int add(Specification specification);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Specification
     * @param specification
     * @return
     */
    int modify(Specification specification);

    /***
     * 根据ID查询Specification
     * @param id
     * @return
     */
    Specification getById(Long id);

    /***
     * 查询所有Specification
     * @return
     */
    PageInfo<Specification> getAll(Integer pageNum, Integer size, Specification specification);

}
