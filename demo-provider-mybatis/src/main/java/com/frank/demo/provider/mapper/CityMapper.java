package com.frank.demo.provider.mapper;

import com.frank.demo.provider.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper extends tk.mybatis.mapper.common.Mapper<City>{

    @Select("select id, name, state, country from city where state = #{state}")
    City findByState(@Param("state") String state);
}
