package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.SeckillGoodsMapper;
import com.frank.pinyougou.model.SeckillGoods;
import com.frank.pinyougou.service.SeckillGoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    /**
     * 增加SeckillGoods
     * @param seckillGoods
     * @return
     */
    @Override
    public int add(SeckillGoods seckillGoods) {
        return seckillGoodsMapper.insertSelective(seckillGoods);
    }


    /***
     * 删除SeckillGoods
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(SeckillGoods.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return seckillGoodsMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询SeckillGoods
     * @param seckillGoods
     * @return
     */
    @Override
    public int modify(SeckillGoods seckillGoods) {
        return seckillGoodsMapper.updateByPrimaryKeySelective(seckillGoods);
    }


    /***
     * 根据ID查询SeckillGoods
     * @param id
     * @return
     */
    @Override
    public SeckillGoods getById(Long id) {
        return seckillGoodsMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有SeckillGoods
     * @return
     */
    @Override
    public PageInfo<SeckillGoods> getAll(Integer pageNum, Integer size, SeckillGoods seckillGoods) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(SeckillGoods.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据SeckillGoods需要更改
            if(!StringUtils.isEmpty(seckillGoods.getName())){
                criteria.andLike("name","%"+seckillGoods.getName()+"%");
            }

            //首字母   根据SeckillGoods需要更改
            if(!StringUtils.isEmpty(seckillGoods.getFirstChar())){
                criteria.andEqualTo("firstChar",seckillGoods.getFirstChar());
            }
        }

        //模糊搜索
        List<SeckillGoods> list = seckillGoodsMapper.selectByExample(example);
		****/

        //查询数据
        List<SeckillGoods> list = seckillGoodsMapper.selectAll();
        return  new PageInfo<SeckillGoods>(list);
    }


}
