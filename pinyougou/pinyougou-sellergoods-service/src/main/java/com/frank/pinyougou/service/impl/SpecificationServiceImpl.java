package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.SpecificationMapper;
import com.frank.pinyougou.model.Specification;
import com.frank.pinyougou.service.SpecificationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;

    /**
     * 增加Specification
     * @param specification
     * @return
     */
    @Override
    public int add(Specification specification) {
        return specificationMapper.insertSelective(specification);
    }


    /***
     * 删除Specification
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(Specification.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return specificationMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询Specification
     * @param specification
     * @return
     */
    @Override
    public int modify(Specification specification) {
        return specificationMapper.updateByPrimaryKeySelective(specification);
    }


    /***
     * 根据ID查询Specification
     * @param id
     * @return
     */
    @Override
    public Specification getById(Long id) {
        return specificationMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有Specification
     * @return
     */
    @Override
    public PageInfo<Specification> getAll(Integer pageNum, Integer size, Specification specification) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(Specification.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据Specification需要更改
            if(!StringUtils.isEmpty(specification.getName())){
                criteria.andLike("name","%"+specification.getName()+"%");
            }

            //首字母   根据Specification需要更改
            if(!StringUtils.isEmpty(specification.getFirstChar())){
                criteria.andEqualTo("firstChar",specification.getFirstChar());
            }
        }

        //模糊搜索
        List<Specification> list = specificationMapper.selectByExample(example);
		****/

        //查询数据
        List<Specification> list = specificationMapper.selectAll();
        return  new PageInfo<Specification>(list);
    }


}
