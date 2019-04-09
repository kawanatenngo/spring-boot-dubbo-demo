package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.OrderItemMapper;
import com.frank.pinyougou.model.OrderItem;
import com.frank.pinyougou.service.OrderItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * 增加OrderItem
     * @param orderItem
     * @return
     */
    @Override
    public int add(OrderItem orderItem) {
        return orderItemMapper.insertSelective(orderItem);
    }


    /***
     * 删除OrderItem
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return orderItemMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询OrderItem
     * @param orderItem
     * @return
     */
    @Override
    public int modify(OrderItem orderItem) {
        return orderItemMapper.updateByPrimaryKeySelective(orderItem);
    }


    /***
     * 根据ID查询OrderItem
     * @param id
     * @return
     */
    @Override
    public OrderItem getById(Long id) {
        return orderItemMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有OrderItem
     * @return
     */
    @Override
    public PageInfo<OrderItem> getAll(Integer pageNum, Integer size, OrderItem orderItem) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据OrderItem需要更改
            if(!StringUtils.isEmpty(orderItem.getName())){
                criteria.andLike("name","%"+orderItem.getName()+"%");
            }

            //首字母   根据OrderItem需要更改
            if(!StringUtils.isEmpty(orderItem.getFirstChar())){
                criteria.andEqualTo("firstChar",orderItem.getFirstChar());
            }
        }

        //模糊搜索
        List<OrderItem> list = orderItemMapper.selectByExample(example);
		****/

        //查询数据
        List<OrderItem> list = orderItemMapper.selectAll();
        return  new PageInfo<OrderItem>(list);
    }


}
