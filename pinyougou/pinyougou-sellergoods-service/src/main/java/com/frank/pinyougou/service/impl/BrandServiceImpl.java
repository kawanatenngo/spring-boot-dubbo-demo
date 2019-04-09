package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.BrandMapper;
import com.frank.pinyougou.model.Brand;
import com.frank.pinyougou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 增加Brand
     * @param brand
     * @return
     */
    @Override
    public int add(Brand brand) {
        return brandMapper.insertSelective(brand);
    }


    /***
     * 删除Brand
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return brandMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询Brand
     * @param brand
     * @return
     */
    @Override
    public int modify(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }


    /***
     * 根据ID查询Brand
     * @param id
     * @return
     */
    @Override
    public Brand getById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有Brand
     * @return
     */
    @Override
    public PageInfo<Brand> getAll(Integer pageNum,Integer size,Brand brand) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据Brand需要更改
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }

            //首字母   根据Brand需要更改
            if(!StringUtils.isEmpty(brand.getFirstChar())){
                criteria.andEqualTo("firstChar",brand.getFirstChar());
            }
        }

        //模糊搜索
        List<Brand> list = brandMapper.selectByExample(example);
		****/

        //查询数据
        List<Brand> list = brandMapper.selectAll();
        return  new PageInfo<Brand>(list);
    }


}
