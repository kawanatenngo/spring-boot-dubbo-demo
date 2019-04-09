package com.frank.pinyougou.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.frank.pinyougou.common.http.Result;
import com.frank.pinyougou.model.Goods;
import com.frank.pinyougou.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Reference
    private GoodsService goodsService;


    /***
     * 增加Goods
     * @param goods
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add(@RequestBody Goods goods){
        try {
            int acount = goodsService.add(goods);
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
            int dcount = goodsService.delete(ids);
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
     * @param goods
     * @return
     */
    @RequestMapping(value = "/modify")
    public Result modify(@RequestBody Goods goods){
        try {
            int mcount = goodsService.modify(goods);

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
    public Goods getById(@PathVariable(value = "id")Long id){
        return goodsService.getById(id);
    }

    /***
     * 集合查询
     * @return
     */
    @RequestMapping(value = "/list")
    public PageInfo<Goods> list(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                @RequestParam(value = "size",required = false,defaultValue = "10")Integer size,
                                @RequestBody Goods goods) {
        return goodsService.getAll(pageNum,size,goods);
    }

}
