package com.frank.pinyougou.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.frank.pinyougou.common.http.Result;
import com.frank.pinyougou.model.PayLog;
import com.frank.pinyougou.service.PayLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/payLog")
public class PayLogController {

    @Reference
    private PayLogService payLogService;


    /***
     * 增加PayLog
     * @param payLog
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add(@RequestBody PayLog payLog){
        try {
            int acount = payLogService.add(payLog);
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
            int dcount = payLogService.delete(ids);
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
     * @param payLog
     * @return
     */
    @RequestMapping(value = "/modify")
    public Result modify(@RequestBody PayLog payLog){
        try {
            int mcount = payLogService.modify(payLog);

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
    public PayLog getById(@PathVariable(value = "id")Long id){
        return payLogService.getById(id);
    }

    /***
     * 集合查询
     * @return
     */
    @RequestMapping(value = "/list")
    public PageInfo<PayLog> list(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                 @RequestParam(value = "size",required = false,defaultValue = "10")Integer size,
                                 @RequestBody PayLog payLog) {
        return payLogService.getAll(pageNum,size,payLog);
    }

}
