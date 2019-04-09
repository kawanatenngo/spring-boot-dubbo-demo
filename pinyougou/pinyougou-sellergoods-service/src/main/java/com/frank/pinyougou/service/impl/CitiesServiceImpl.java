package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.CitiesMapper;
import com.frank.pinyougou.model.Cities;
import com.frank.pinyougou.service.CitiesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CitiesServiceImpl implements CitiesService {

    @Autowired
    private CitiesMapper citiesMapper;

    /**
     * 增加Cities
     * @param cities
     * @return
     */
    @Override
    public int add(Cities cities) {
        return citiesMapper.insertSelective(cities);
    }


    /***
     * 删除Cities
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(Cities.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return citiesMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询Cities
     * @param cities
     * @return
     */
    @Override
    public int modify(Cities cities) {
        return citiesMapper.updateByPrimaryKeySelective(cities);
    }


    /***
     * 根据ID查询Cities
     * @param id
     * @return
     */
    @Override
    public Cities getById(Long id) {
        return citiesMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有Cities
     * @return
     */
    @Override
    public PageInfo<Cities> getAll(Integer pageNum, Integer size, Cities cities) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(Cities.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据Cities需要更改
            if(!StringUtils.isEmpty(cities.getName())){
                criteria.andLike("name","%"+cities.getName()+"%");
            }

            //首字母   根据Cities需要更改
            if(!StringUtils.isEmpty(cities.getFirstChar())){
                criteria.andEqualTo("firstChar",cities.getFirstChar());
            }
        }

        //模糊搜索
        List<Cities> list = citiesMapper.selectByExample(example);
		****/

        //查询数据
        List<Cities> list = citiesMapper.selectAll();
        return  new PageInfo<Cities>(list);
    }


}
