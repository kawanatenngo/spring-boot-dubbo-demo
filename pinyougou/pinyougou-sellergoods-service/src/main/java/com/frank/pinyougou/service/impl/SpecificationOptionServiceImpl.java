package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.SpecificationOptionMapper;
import com.frank.pinyougou.model.SpecificationOption;
import com.frank.pinyougou.service.SpecificationOptionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

    @Autowired
    private SpecificationOptionMapper specificationOptionMapper;

    /**
     * 增加SpecificationOption
     * @param specificationOption
     * @return
     */
    @Override
    public int add(SpecificationOption specificationOption) {
        return specificationOptionMapper.insertSelective(specificationOption);
    }


    /***
     * 删除SpecificationOption
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(SpecificationOption.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return specificationOptionMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询SpecificationOption
     * @param specificationOption
     * @return
     */
    @Override
    public int modify(SpecificationOption specificationOption) {
        return specificationOptionMapper.updateByPrimaryKeySelective(specificationOption);
    }


    /***
     * 根据ID查询SpecificationOption
     * @param id
     * @return
     */
    @Override
    public SpecificationOption getById(Long id) {
        return specificationOptionMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有SpecificationOption
     * @return
     */
    @Override
    public PageInfo<SpecificationOption> getAll(Integer pageNum, Integer size, SpecificationOption specificationOption) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(SpecificationOption.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据SpecificationOption需要更改
            if(!StringUtils.isEmpty(specificationOption.getName())){
                criteria.andLike("name","%"+specificationOption.getName()+"%");
            }

            //首字母   根据SpecificationOption需要更改
            if(!StringUtils.isEmpty(specificationOption.getFirstChar())){
                criteria.andEqualTo("firstChar",specificationOption.getFirstChar());
            }
        }

        //模糊搜索
        List<SpecificationOption> list = specificationOptionMapper.selectByExample(example);
		****/

        //查询数据
        List<SpecificationOption> list = specificationOptionMapper.selectAll();
        return  new PageInfo<SpecificationOption>(list);
    }


}
