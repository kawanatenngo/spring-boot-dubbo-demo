package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Areas;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AreasService {

    /***
     * 增加Areas
     * @param areas
     * @return
     */
    int add(Areas areas);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Areas
     * @param areas
     * @return
     */
    int modify(Areas areas);

    /***
     * 根据ID查询Areas
     * @param id
     * @return
     */
    Areas getById(Long id);

    /***
     * 查询所有Areas
     * @return
     */
    PageInfo<Areas> getAll(Integer pageNum, Integer size, Areas areas);

}
