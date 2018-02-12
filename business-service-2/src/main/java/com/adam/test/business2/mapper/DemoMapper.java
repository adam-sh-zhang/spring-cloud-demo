package com.adam.test.business2.mapper;

import com.adam.test.business2.model.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Adam.Zhang on 2017/9/11.
 */
@Mapper
public interface DemoMapper {
    //@Select("select * from demo")
    List<Demo> findAll();
}
