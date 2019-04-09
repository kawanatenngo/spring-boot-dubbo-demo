package com.frank.pinyougou.service;

import com.frank.pinyougou.model.ContentCategory;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ContentCategoryService {

    /***
     * 增加ContentCategory
     * @param contentCategory
     * @return
     */
    int add(ContentCategory contentCategory);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改ContentCategory
     * @param contentCategory
     * @return
     */
    int modify(ContentCategory contentCategory);

    /***
     * 根据ID查询ContentCategory
     * @param id
     * @return
     */
    ContentCategory getById(Long id);

    /***
     * 查询所有ContentCategory
     * @return
     */
    PageInfo<ContentCategory> getAll(Integer pageNum, Integer size, ContentCategory contentCategory);

}
