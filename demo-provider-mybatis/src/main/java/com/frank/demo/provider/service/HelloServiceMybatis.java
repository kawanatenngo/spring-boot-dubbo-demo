package com.frank.demo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.frank.demo.HelloService;
import com.frank.demo.provider.mapper.CityMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "${demo.service.version}")
public class HelloServiceMybatis implements HelloService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public String sayHello(String name) {
        // return cityMapper.findByState(name).toString();
        PageHelper.startPage(1, 5);
        return cityMapper.selectAll().get(0).toString();
    }
}
