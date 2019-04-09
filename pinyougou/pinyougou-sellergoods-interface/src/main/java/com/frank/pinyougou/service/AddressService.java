package com.frank.pinyougou.service;

import com.frank.pinyougou.model.Address;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AddressService {

    /***
     * 增加Address
     * @param address
     * @return
     */
    int add(Address address);

    /***
     * 删除操作
     * @param ids
     * @return
     */
    int delete(List<Long> ids);


    /**
     * 修改Address
     * @param address
     * @return
     */
    int modify(Address address);

    /***
     * 根据ID查询Address
     * @param id
     * @return
     */
    Address getById(Long id);

    /***
     * 查询所有Address
     * @return
     */
    PageInfo<Address> getAll(Integer pageNum, Integer size, Address address);

}
