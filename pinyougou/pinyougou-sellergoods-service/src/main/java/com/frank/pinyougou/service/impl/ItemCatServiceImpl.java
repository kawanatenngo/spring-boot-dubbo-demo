package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.ItemCatMapper;
import com.frank.pinyougou.model.ItemCat;
import com.frank.pinyougou.service.ItemCatService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    /**
     * 增加ItemCat
     * @param itemCat
     * @return
     */
    @Override
    public int add(ItemCat itemCat) {
        return itemCatMapper.insertSelective(itemCat);
    }


    /***
     * 删除ItemCat
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(ItemCat.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return itemCatMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询ItemCat
     * @param itemCat
     * @return
     */
    @Override
    public int modify(ItemCat itemCat) {
        return itemCatMapper.updateByPrimaryKeySelective(itemCat);
    }


    /***
     * 根据ID查询ItemCat
     * @param id
     * @return
     */
    @Override
    public ItemCat getById(Long id) {
        return itemCatMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有ItemCat
     * @return
     */
    @Override
    public PageInfo<ItemCat> getAll(Integer pageNum, Integer size, ItemCat itemCat) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(ItemCat.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据ItemCat需要更改
            if(!StringUtils.isEmpty(itemCat.getName())){
                criteria.andLike("name","%"+itemCat.getName()+"%");
            }

            //首字母   根据ItemCat需要更改
            if(!StringUtils.isEmpty(itemCat.getFirstChar())){
                criteria.andEqualTo("firstChar",itemCat.getFirstChar());
            }
        }

        //模糊搜索
        List<ItemCat> list = itemCatMapper.selectByExample(example);
		****/

        //查询数据
        List<ItemCat> list = itemCatMapper.selectAll();
        return  new PageInfo<ItemCat>(list);
    }


}
