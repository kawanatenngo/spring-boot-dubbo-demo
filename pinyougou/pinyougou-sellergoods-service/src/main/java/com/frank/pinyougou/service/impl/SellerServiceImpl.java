package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.SellerMapper;
import com.frank.pinyougou.model.Seller;
import com.frank.pinyougou.service.SellerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerMapper sellerMapper;

    /**
     * 增加Seller
     * @param seller
     * @return
     */
    @Override
    public int add(Seller seller) {
        return sellerMapper.insertSelective(seller);
    }


    /***
     * 删除Seller
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(Seller.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return sellerMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询Seller
     * @param seller
     * @return
     */
    @Override
    public int modify(Seller seller) {
        return sellerMapper.updateByPrimaryKeySelective(seller);
    }


    /***
     * 根据ID查询Seller
     * @param id
     * @return
     */
    @Override
    public Seller getById(Long id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有Seller
     * @return
     */
    @Override
    public PageInfo<Seller> getAll(Integer pageNum, Integer size, Seller seller) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(Seller.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据Seller需要更改
            if(!StringUtils.isEmpty(seller.getName())){
                criteria.andLike("name","%"+seller.getName()+"%");
            }

            //首字母   根据Seller需要更改
            if(!StringUtils.isEmpty(seller.getFirstChar())){
                criteria.andEqualTo("firstChar",seller.getFirstChar());
            }
        }

        //模糊搜索
        List<Seller> list = sellerMapper.selectByExample(example);
		****/

        //查询数据
        List<Seller> list = sellerMapper.selectAll();
        return  new PageInfo<Seller>(list);
    }


}
