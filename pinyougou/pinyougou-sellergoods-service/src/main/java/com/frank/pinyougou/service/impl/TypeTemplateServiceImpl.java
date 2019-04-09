package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.TypeTemplateMapper;
import com.frank.pinyougou.model.TypeTemplate;
import com.frank.pinyougou.service.TypeTemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TypeTemplateMapper typeTemplateMapper;

    /**
     * 增加TypeTemplate
     * @param typeTemplate
     * @return
     */
    @Override
    public int add(TypeTemplate typeTemplate) {
        return typeTemplateMapper.insertSelective(typeTemplate);
    }


    /***
     * 删除TypeTemplate
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(TypeTemplate.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return typeTemplateMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询TypeTemplate
     * @param typeTemplate
     * @return
     */
    @Override
    public int modify(TypeTemplate typeTemplate) {
        return typeTemplateMapper.updateByPrimaryKeySelective(typeTemplate);
    }


    /***
     * 根据ID查询TypeTemplate
     * @param id
     * @return
     */
    @Override
    public TypeTemplate getById(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有TypeTemplate
     * @return
     */
    @Override
    public PageInfo<TypeTemplate> getAll(Integer pageNum, Integer size, TypeTemplate typeTemplate) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(TypeTemplate.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据TypeTemplate需要更改
            if(!StringUtils.isEmpty(typeTemplate.getName())){
                criteria.andLike("name","%"+typeTemplate.getName()+"%");
            }

            //首字母   根据TypeTemplate需要更改
            if(!StringUtils.isEmpty(typeTemplate.getFirstChar())){
                criteria.andEqualTo("firstChar",typeTemplate.getFirstChar());
            }
        }

        //模糊搜索
        List<TypeTemplate> list = typeTemplateMapper.selectByExample(example);
		****/

        //查询数据
        List<TypeTemplate> list = typeTemplateMapper.selectAll();
        return  new PageInfo<TypeTemplate>(list);
    }


}
