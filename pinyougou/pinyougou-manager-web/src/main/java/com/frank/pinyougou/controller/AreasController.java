package com.frank.pinyougou.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.frank.pinyougou.common.http.Result;
import com.frank.pinyougou.model.Areas;
import com.frank.pinyougou.service.AreasService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/areas")
public class AreasController {

    @Reference
    private AreasService areasService;


    /***
     * 增加Areas
     * @param areas
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add(@RequestBody Areas areas){
        try {
            int acount = areasService.add(areas);
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
            int dcount = areasService.delete(ids);
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
     * @param areas
     * @return
     */
    @RequestMapping(value = "/modify")
    public Result modify(@RequestBody Areas areas){
        try {
            int mcount = areasService.modify(areas);

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
    public Areas getById(@PathVariable(value = "id")Long id){
        return areasService.getById(id);
    }

    /***
     * 集合查询
     * @return
     */
    @RequestMapping(value = "/list")
    public PageInfo<Areas> list(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                @RequestParam(value = "size",required = false,defaultValue = "10")Integer size,
                                @RequestBody Areas areas) {
        return areasService.getAll(pageNum,size,areas);
    }

}
