package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.FreightTemplateMapper;
import com.frank.pinyougou.model.FreightTemplate;
import com.frank.pinyougou.service.FreightTemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class FreightTemplateServiceImpl implements FreightTemplateService {

    @Autowired
    private FreightTemplateMapper freightTemplateMapper;

    /**
     * 增加FreightTemplate
     * @param freightTemplate
     * @return
     */
    @Override
    public int add(FreightTemplate freightTemplate) {
        return freightTemplateMapper.insertSelective(freightTemplate);
    }


    /***
     * 删除FreightTemplate
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(FreightTemplate.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return freightTemplateMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询FreightTemplate
     * @param freightTemplate
     * @return
     */
    @Override
    public int modify(FreightTemplate freightTemplate) {
        return freightTemplateMapper.updateByPrimaryKeySelective(freightTemplate);
    }


    /***
     * 根据ID查询FreightTemplate
     * @param id
     * @return
     */
    @Override
    public FreightTemplate getById(Long id) {
        return freightTemplateMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有FreightTemplate
     * @return
     */
    @Override
    public PageInfo<FreightTemplate> getAll(Integer pageNum, Integer size, FreightTemplate freightTemplate) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(FreightTemplate.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据FreightTemplate需要更改
            if(!StringUtils.isEmpty(freightTemplate.getName())){
                criteria.andLike("name","%"+freightTemplate.getName()+"%");
            }

            //首字母   根据FreightTemplate需要更改
            if(!StringUtils.isEmpty(freightTemplate.getFirstChar())){
                criteria.andEqualTo("firstChar",freightTemplate.getFirstChar());
            }
        }

        //模糊搜索
        List<FreightTemplate> list = freightTemplateMapper.selectByExample(example);
		****/

        //查询数据
        List<FreightTemplate> list = freightTemplateMapper.selectAll();
        return  new PageInfo<FreightTemplate>(list);
    }


}
