package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.ItemMapper;
import com.frank.pinyougou.model.Item;
import com.frank.pinyougou.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    /**
     * 增加Item
     * @param item
     * @return
     */
    @Override
    public int add(Item item) {
        return itemMapper.insertSelective(item);
    }


    /***
     * 删除Item
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(Item.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return itemMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询Item
     * @param item
     * @return
     */
    @Override
    public int modify(Item item) {
        return itemMapper.updateByPrimaryKeySelective(item);
    }


    /***
     * 根据ID查询Item
     * @param id
     * @return
     */
    @Override
    public Item getById(Long id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有Item
     * @return
     */
    @Override
    public PageInfo<Item> getAll(Integer pageNum, Integer size, Item item) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(Item.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据Item需要更改
            if(!StringUtils.isEmpty(item.getName())){
                criteria.andLike("name","%"+item.getName()+"%");
            }

            //首字母   根据Item需要更改
            if(!StringUtils.isEmpty(item.getFirstChar())){
                criteria.andEqualTo("firstChar",item.getFirstChar());
            }
        }

        //模糊搜索
        List<Item> list = itemMapper.selectByExample(example);
		****/

        //查询数据
        List<Item> list = itemMapper.selectAll();
        return  new PageInfo<Item>(list);
    }


}
