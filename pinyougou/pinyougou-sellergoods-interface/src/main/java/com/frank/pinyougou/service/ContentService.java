package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Content;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ContentService {

    /***
     * 增加Content
     * @param content
     * @return
     */
    int add(Content content);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Content
     * @param content
     * @return
     */
    int modify(Content content);

    /***
     * 根据ID查询Content
     * @param id
     * @return
     */
    Content getById(Long id);

    /***
     * 查询所有Content
     * @return
     */
    PageInfo<Content> getAll(Integer pageNum, Integer size, Content content);

}
