package com.frank.pinyougou.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.frank.pinyougou.common.http.Result;
import com.frank.pinyougou.model.SeckillGoods;
import com.frank.pinyougou.service.SeckillGoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/seckillGoods")
public class SeckillGoodsController {

    @Reference
    private SeckillGoodsService seckillGoodsService;


    /***
     * 增加SeckillGoods
     * @param seckillGoods
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add(@RequestBody SeckillGoods seckillGoods){
        try {
            int acount = seckillGoodsService.add(seckillGoods);
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
            int dcount = seckillGoodsService.delete(ids);
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
     * @param seckillGoods
     * @return
     */
    @RequestMapping(value = "/modify")
    public Result modify(@RequestBody SeckillGoods seckillGoods){
        try {
            int mcount = seckillGoodsService.modify(seckillGoods);

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
    public SeckillGoods getById(@PathVariable(value = "id")Long id){
        return seckillGoodsService.getById(id);
    }

    /***
     * 集合查询
     * @return
     */
    @RequestMapping(value = "/list")
    public PageInfo<SeckillGoods> list(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                       @RequestParam(value = "size",required = false,defaultValue = "10")Integer size,
                                       @RequestBody SeckillGoods seckillGoods) {
        return seckillGoodsService.getAll(pageNum,size,seckillGoods);
    }

}
