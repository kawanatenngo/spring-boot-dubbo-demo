package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.OrderMapper;
import com.frank.pinyougou.model.Order;
import com.frank.pinyougou.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 增加Order
     * @param order
     * @return
     */
    @Override
    public int add(Order order) {
        return orderMapper.insertSelective(order);
    }


    /***
     * 删除Order
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return orderMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询Order
     * @param order
     * @return
     */
    @Override
    public int modify(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }


    /***
     * 根据ID查询Order
     * @param id
     * @return
     */
    @Override
    public Order getById(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有Order
     * @return
     */
    @Override
    public PageInfo<Order> getAll(Integer pageNum, Integer size, Order order) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据Order需要更改
            if(!StringUtils.isEmpty(order.getName())){
                criteria.andLike("name","%"+order.getName()+"%");
            }

            //首字母   根据Order需要更改
            if(!StringUtils.isEmpty(order.getFirstChar())){
                criteria.andEqualTo("firstChar",order.getFirstChar());
            }
        }

        //模糊搜索
        List<Order> list = orderMapper.selectByExample(example);
		****/

        //查询数据
        List<Order> list = orderMapper.selectAll();
        return  new PageInfo<Order>(list);
    }


}
