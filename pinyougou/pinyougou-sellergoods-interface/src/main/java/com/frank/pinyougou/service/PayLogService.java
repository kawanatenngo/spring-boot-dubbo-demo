package com.frank.pinyougou.service;

import com.frank.pinyougou.model.PayLog;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PayLogService {

    /***
     * 增加PayLog
     * @param payLog
     * @return
     */
    int add(PayLog payLog);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改PayLog
     * @param payLog
     * @return
     */
    int modify(PayLog payLog);

    /***
     * 根据ID查询PayLog
     * @param id
     * @return
     */
    PayLog getById(Long id);

    /***
     * 查询所有PayLog
     * @return
     */
    PageInfo<PayLog> getAll(Integer pageNum, Integer size, PayLog payLog);

}
