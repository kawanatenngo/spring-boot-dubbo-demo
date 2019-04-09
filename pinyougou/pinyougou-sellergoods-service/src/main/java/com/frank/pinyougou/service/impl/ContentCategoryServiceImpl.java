package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.ContentCategoryMapper;
import com.frank.pinyougou.model.ContentCategory;
import com.frank.pinyougou.service.ContentCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    /**
     * 增加ContentCategory
     * @param contentCategory
     * @return
     */
    @Override
    public int add(ContentCategory contentCategory) {
        return contentCategoryMapper.insertSelective(contentCategory);
    }


    /***
     * 删除ContentCategory
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(ContentCategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return contentCategoryMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询ContentCategory
     * @param contentCategory
     * @return
     */
    @Override
    public int modify(ContentCategory contentCategory) {
        return contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
    }


    /***
     * 根据ID查询ContentCategory
     * @param id
     * @return
     */
    @Override
    public ContentCategory getById(Long id) {
        return contentCategoryMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有ContentCategory
     * @return
     */
    @Override
    public PageInfo<ContentCategory> getAll(Integer pageNum,Integer size,ContentCategory contentCategory) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(ContentCategory.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据ContentCategory需要更改
            if(!StringUtils.isEmpty(contentCategory.getName())){
                criteria.andLike("name","%"+contentCategory.getName()+"%");
            }

            //首字母   根据ContentCategory需要更改
            if(!StringUtils.isEmpty(contentCategory.getFirstChar())){
                criteria.andEqualTo("firstChar",contentCategory.getFirstChar());
            }
        }

        //模糊搜索
        List<ContentCategory> list = contentCategoryMapper.selectByExample(example);
		****/

        //查询数据
        List<ContentCategory> list = contentCategoryMapper.selectAll();
        return  new PageInfo<ContentCategory>(list);
    }


}
