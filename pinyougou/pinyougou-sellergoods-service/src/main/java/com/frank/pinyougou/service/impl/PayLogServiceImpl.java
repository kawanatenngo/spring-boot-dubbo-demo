package com.frank.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.pinyougou.mapper.PayLogMapper;
import com.frank.pinyougou.model.PayLog;
import com.frank.pinyougou.service.PayLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PayLogServiceImpl implements PayLogService {

    @Autowired
    private PayLogMapper payLogMapper;

    /**
     * 增加PayLog
     * @param payLog
     * @return
     */
    @Override
    public int add(PayLog payLog) {
        return payLogMapper.insertSelective(payLog);
    }


    /***
     * 删除PayLog
     * @param ids
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        Example example = new Example(PayLog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return payLogMapper.deleteByExample(example);
    }


    /***
     * 根据ID查询PayLog
     * @param payLog
     * @return
     */
    @Override
    public int modify(PayLog payLog) {
        return payLogMapper.updateByPrimaryKeySelective(payLog);
    }


    /***
     * 根据ID查询PayLog
     * @param id
     * @return
     */
    @Override
    public PayLog getById(Long id) {
        return payLogMapper.selectByPrimaryKey(id);
    }

    /***
     * 使用通用Mapper查询所有PayLog
     * @return
     */
    @Override
    public PageInfo<PayLog> getAll(Integer pageNum, Integer size, PayLog payLog) {
        //分页实现
        PageHelper.startPage(pageNum,size);


		/****
		如果使用模糊搜索，则去掉注释，根据需要修改
        //构建条件
        Example example = new Example(PayLog.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //根据品牌名字模糊查询 根据PayLog需要更改
            if(!StringUtils.isEmpty(payLog.getName())){
                criteria.andLike("name","%"+payLog.getName()+"%");
            }

            //首字母   根据PayLog需要更改
            if(!StringUtils.isEmpty(payLog.getFirstChar())){
                criteria.andEqualTo("firstChar",payLog.getFirstChar());
            }
        }

        //模糊搜索
        List<PayLog> list = payLogMapper.selectByExample(example);
		****/

        //查询数据
        List<PayLog> list = payLogMapper.selectAll();
        return  new PageInfo<PayLog>(list);
    }


}
