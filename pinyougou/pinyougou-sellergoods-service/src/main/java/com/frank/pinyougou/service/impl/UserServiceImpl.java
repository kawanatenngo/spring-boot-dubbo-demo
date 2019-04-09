package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.UserMapper;
import com.frank.pinyougou.model.User;
import com.frank.pinyougou.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 增加User
     * @param user
     * @return
     */
    @Override
    public int add(User user) {
        return userMapper.insertSelective(user);
    }


    /***
     * 删除User
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return userMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询User
     * @param user
     * @return
     */
    @Override
    public int modify(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }


    /***
     * 根据ID查询User
     * @param id
     * @return
     */
    @Override
    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有User
     * @return
     */
    @Override
    public PageInfo<User> getAll(Integer pageNum, Integer size, User user) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据User需要更改
            if(!StringUtils.isEmpty(user.getName())){
                criteria.andLike("name","%"+user.getName()+"%");
            }

            //首字母   根据User需要更改
            if(!StringUtils.isEmpty(user.getFirstChar())){
                criteria.andEqualTo("firstChar",user.getFirstChar());
            }
        }

        //模糊搜索
        List<User> list = userMapper.selectByExample(example);
		****/

        //查询数据
        List<User> list = userMapper.selectAll();
        return  new PageInfo<User>(list);
    }


}
