package com.frank.pinyougou.controller;

//import org.apache.dubbo.config.annotation.Reference;

import com.alibaba.dubbo.config.annotation.Reference;
import com.frank.pinyougou.common.http.Result;
import com.frank.pinyougou.model.Address;
import com.frank.pinyougou.service.AddressService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Reference
    private AddressService addressService;


    /***
     * 增加Address
     * @param address
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add(@RequestBody Address address){
        try {
            int acount = addressService.add(address);
            if(acount>0){
                return  new Result(true,"增加成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new Result(false,"增加失败！");
    }


    /***
     * 删除操作
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete")
    public Result delete(@RequestBody List<Long> ids){
        try {
            int dcount = addressService.delete(ids);
            if(dcount>0){
                return new Result(true,"删除成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"删除失败!");
    }

    /***
     * 修改操作
     * @param address
     * @return
     */
    @RequestMapping(value = "/modify")
    public Result modify(@RequestBody Address address){
        try {
            int mcount = addressService.modify(address);

            if(mcount>0){
                return new Result(true,"修改成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  new Result(false,"修改失败！");
    }

    /***
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/one/{id}")
    public Address getById(@PathVariable(value = "id")Long id){
        return addressService.getById(id);
    }

    /***
     * 集合查询
     * @return
     */
    @RequestMapping(value = "/list")
    public PageInfo<Address> list(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                  @RequestParam(value = "size",required = false,defaultValue = "10")Integer size,
                                  @RequestBody Address address) {
        return addressService.getAll(pageNum,size,address);
    }

}
