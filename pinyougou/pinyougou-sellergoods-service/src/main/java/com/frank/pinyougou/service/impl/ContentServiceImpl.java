package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.ContentMapper;
import com.frank.pinyougou.model.Content;
import com.frank.pinyougou.service.ContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    /**
     * 增加Content
     * @param content
     * @return
     */
    @Override
    public int add(Content content) {
        return contentMapper.insertSelective(content);
    }


    /***
     * 删除Content
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(Content.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return contentMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询Content
     * @param content
     * @return
     */
    @Override
    public int modify(Content content) {
        return contentMapper.updateByPrimaryKeySelective(content);
    }


    /***
     * 根据ID查询Content
     * @param id
     * @return
     */
    @Override
    public Content getById(Long id) {
        return contentMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有Content
     * @return
     */
    @Override
    public PageInfo<Content> getAll(Integer pageNum, Integer size, Content content) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(Content.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据Content需要更改
            if(!StringUtils.isEmpty(content.getName())){
                criteria.andLike("name","%"+content.getName()+"%");
            }

            //首字母   根据Content需要更改
            if(!StringUtils.isEmpty(content.getFirstChar())){
                criteria.andEqualTo("firstChar",content.getFirstChar());
            }
        }

        //模糊搜索
        List<Content> list = contentMapper.selectByExample(example);
		****/

        //查询数据
        List<Content> list = contentMapper.selectAll();
        return  new PageInfo<Content>(list);
    }


}
