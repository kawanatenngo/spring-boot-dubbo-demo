package com.frank.pinyougou.service;

import com.frank.pinyougou.model.TypeTemplate;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TypeTemplateService {

    /***
     * 增加TypeTemplate
     * @param typeTemplate
     * @return
     */
    int add(TypeTemplate typeTemplate);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改TypeTemplate
     * @param typeTemplate
     * @return
     */
    int modify(TypeTemplate typeTemplate);

    /***
     * 根据ID查询TypeTemplate
     * @param id
     * @return
     */
    TypeTemplate getById(Long id);

    /***
     * 查询所有TypeTemplate
     * @return
     */
    PageInfo<TypeTemplate> getAll(Integer pageNum, Integer size, TypeTemplate typeTemplate);

}
