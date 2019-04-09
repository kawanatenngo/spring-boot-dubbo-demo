package com.frank.pinyougou.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.frank.pinyougou.common.http.Result;
import com.frank.pinyougou.model.OrderItem;
import com.frank.pinyougou.service.OrderItemService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orderItem")
public class OrderItemController {

    @Reference
    private OrderItemService orderItemService;


    /***
     * 增加OrderItem
     * @param orderItem
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add(@RequestBody OrderItem orderItem){
        try {
            int acount = orderItemService.add(orderItem);
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
            int dcount = orderItemService.delete(ids);
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
     * @param orderItem
     * @return
     */
    @RequestMapping(value = "/modify")
    public Result modify(@RequestBody OrderItem orderItem){
        try {
            int mcount = orderItemService.modify(orderItem);

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
    public OrderItem getById(@PathVariable(value = "id")Long id){
        return orderItemService.getById(id);
    }

    /***
     * 集合查询
     * @return
     */
    @RequestMapping(value = "/list")
    public PageInfo<OrderItem> list(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                    @RequestParam(value = "size",required = false,defaultValue = "10")Integer size,
                                    @RequestBody OrderItem orderItem) {
        return orderItemService.getAll(pageNum,size,orderItem);
    }

}
