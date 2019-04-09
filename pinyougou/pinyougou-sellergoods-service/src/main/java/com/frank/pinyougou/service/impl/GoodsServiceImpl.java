package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.GoodsMapper;
import com.frank.pinyougou.model.Goods;
import com.frank.pinyougou.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 增加Goods
     * @param goods
     * @return
     */
    @Override
    public int add(Goods goods) {
        return goodsMapper.insertSelective(goods);
    }


    /***
     * 删除Goods
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return goodsMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询Goods
     * @param goods
     * @return
     */
    @Override
    public int modify(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }


    /***
     * 根据ID查询Goods
     * @param id
     * @return
     */
    @Override
    public Goods getById(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有Goods
     * @return
     */
    @Override
    public PageInfo<Goods> getAll(Integer pageNum, Integer size, Goods goods) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据Goods需要更改
            if(!StringUtils.isEmpty(goods.getName())){
                criteria.andLike("name","%"+goods.getName()+"%");
            }

            //首字母   根据Goods需要更改
            if(!StringUtils.isEmpty(goods.getFirstChar())){
                criteria.andEqualTo("firstChar",goods.getFirstChar());
            }
        }

        //模糊搜索
        List<Goods> list = goodsMapper.selectByExample(example);
		****/

        //查询数据
        List<Goods> list = goodsMapper.selectAll();
        return  new PageInfo<Goods>(list);
    }


}
