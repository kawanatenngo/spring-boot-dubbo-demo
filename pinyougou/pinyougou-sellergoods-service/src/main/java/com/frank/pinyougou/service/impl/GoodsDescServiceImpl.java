package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.GoodsDescMapper;
import com.frank.pinyougou.model.GoodsDesc;
import com.frank.pinyougou.service.GoodsDescService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class GoodsDescServiceImpl implements GoodsDescService {

    @Autowired
    private GoodsDescMapper goodsDescMapper;

    /**
     * 增加GoodsDesc
     * @param goodsDesc
     * @return
     */
    @Override
    public int add(GoodsDesc goodsDesc) {
        return goodsDescMapper.insertSelective(goodsDesc);
    }


    /***
     * 删除GoodsDesc
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(GoodsDesc.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return goodsDescMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询GoodsDesc
     * @param goodsDesc
     * @return
     */
    @Override
    public int modify(GoodsDesc goodsDesc) {
        return goodsDescMapper.updateByPrimaryKeySelective(goodsDesc);
    }


    /***
     * 根据ID查询GoodsDesc
     * @param id
     * @return
     */
    @Override
    public GoodsDesc getById(Long id) {
        return goodsDescMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有GoodsDesc
     * @return
     */
    @Override
    public PageInfo<GoodsDesc> getAll(Integer pageNum, Integer size, GoodsDesc goodsDesc) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(GoodsDesc.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据GoodsDesc需要更改
            if(!StringUtils.isEmpty(goodsDesc.getName())){
                criteria.andLike("name","%"+goodsDesc.getName()+"%");
            }

            //首字母   根据GoodsDesc需要更改
            if(!StringUtils.isEmpty(goodsDesc.getFirstChar())){
                criteria.andEqualTo("firstChar",goodsDesc.getFirstChar());
            }
        }

        //模糊搜索
        List<GoodsDesc> list = goodsDescMapper.selectByExample(example);
		****/

        //查询数据
        List<GoodsDesc> list = goodsDescMapper.selectAll();
        return  new PageInfo<GoodsDesc>(list);
    }


}
