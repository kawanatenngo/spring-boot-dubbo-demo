package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.ProvincesMapper;
import com.frank.pinyougou.model.Provinces;
import com.frank.pinyougou.service.ProvincesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProvincesServiceImpl implements ProvincesService {

    @Autowired
    private ProvincesMapper provincesMapper;

    /**
     * 增加Provinces
     * @param provinces
     * @return
     */
    @Override
    public int add(Provinces provinces) {
        return provincesMapper.insertSelective(provinces);
    }


    /***
     * 删除Provinces
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(Provinces.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return provincesMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询Provinces
     * @param provinces
     * @return
     */
    @Override
    public int modify(Provinces provinces) {
        return provincesMapper.updateByPrimaryKeySelective(provinces);
    }


    /***
     * 根据ID查询Provinces
     * @param id
     * @return
     */
    @Override
    public Provinces getById(Long id) {
        return provincesMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有Provinces
     * @return
     */
    @Override
    public PageInfo<Provinces> getAll(Integer pageNum, Integer size, Provinces provinces) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(Provinces.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据Provinces需要更改
            if(!StringUtils.isEmpty(provinces.getName())){
                criteria.andLike("name","%"+provinces.getName()+"%");
            }

            //首字母   根据Provinces需要更改
            if(!StringUtils.isEmpty(provinces.getFirstChar())){
                criteria.andEqualTo("firstChar",provinces.getFirstChar());
            }
        }

        //模糊搜索
        List<Provinces> list = provincesMapper.selectByExample(example);
		****/

        //查询数据
        List<Provinces> list = provincesMapper.selectAll();
        return  new PageInfo<Provinces>(list);
    }


}
