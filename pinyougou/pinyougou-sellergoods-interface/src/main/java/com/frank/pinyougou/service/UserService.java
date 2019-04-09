package com.frank.pinyougou.service;

import com.frank.pinyougou.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    /***
     * 增加User
     * @param user
     * @return
     */
    int add(User user);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改User
     * @param user
     * @return
     */
    int modify(User user);

    /***
     * 根据ID查询User
     * @param id
     * @return
     */
    User getById(Long id);

    /***
     * 查询所有User
     * @return
     */
    PageInfo<User> getAll(Integer pageNum, Integer size, User user);

}
