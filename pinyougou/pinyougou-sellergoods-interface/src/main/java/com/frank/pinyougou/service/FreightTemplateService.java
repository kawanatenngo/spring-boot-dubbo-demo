package com.frank.pinyougou.service;

import com.frank.pinyougou.model.FreightTemplate;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface FreightTemplateService {

    /***
     * 增加FreightTemplate
     * @param freightTemplate
     * @return
     */
    int add(FreightTemplate freightTemplate);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改FreightTemplate
     * @param freightTemplate
     * @return
     */
    int modify(FreightTemplate freightTemplate);

    /***
     * 根据ID查询FreightTemplate
     * @param id
     * @return
     */
    FreightTemplate getById(Long id);

    /***
     * 查询所有FreightTemplate
     * @return
     */
    PageInfo<FreightTemplate> getAll(Integer pageNum, Integer size, FreightTemplate freightTemplate);

}
