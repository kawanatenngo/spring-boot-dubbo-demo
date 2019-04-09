package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.SeckillOrderMapper;
import com.frank.pinyougou.model.SeckillOrder;
import com.frank.pinyougou.service.SeckillOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    /**
     * 增加SeckillOrder
     * @param seckillOrder
     * @return
     */
    @Override
    public int add(SeckillOrder seckillOrder) {
        return seckillOrderMapper.insertSelective(seckillOrder);
    }


    /***
     * 删除SeckillOrder
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(SeckillOrder.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return seckillOrderMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询SeckillOrder
     * @param seckillOrder
     * @return
     */
    @Override
    public int modify(SeckillOrder seckillOrder) {
        return seckillOrderMapper.updateByPrimaryKeySelective(seckillOrder);
    }


    /***
     * 根据ID查询SeckillOrder
     * @param id
     * @return
     */
    @Override
    public SeckillOrder getById(Long id) {
        return seckillOrderMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有SeckillOrder
     * @return
     */
    @Override
    public PageInfo<SeckillOrder> getAll(Integer pageNum, Integer size, SeckillOrder seckillOrder) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(SeckillOrder.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据SeckillOrder需要更改
            if(!StringUtils.isEmpty(seckillOrder.getName())){
                criteria.andLike("name","%"+seckillOrder.getName()+"%");
            }

            //首字母   根据SeckillOrder需要更改
            if(!StringUtils.isEmpty(seckillOrder.getFirstChar())){
                criteria.andEqualTo("firstChar",seckillOrder.getFirstChar());
            }
        }

        //模糊搜索
        List<SeckillOrder> list = seckillOrderMapper.selectByExample(example);
		****/

        //查询数据
        List<SeckillOrder> list = seckillOrderMapper.selectAll();
        return  new PageInfo<SeckillOrder>(list);
    }


}
