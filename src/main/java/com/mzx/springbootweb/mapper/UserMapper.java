package com.mzx.springbootweb.mapper;


import com.mzx.springbootweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//指定mapper类(可以在application启动文件中使用@MapperScan 扫描mapper文件)，这里可以写成接口
@Mapper
public abstract interface UserMapper {

    //limit限制查询 返回分页信息
    @Select({"select * from phonelog limit #{startLine},#{num}"})
    public abstract List<User> getAllPhoneLog(@Param("startLine") int paramInt1, @Param("num") int paramInt2);

    // 查询所有数据数量
    @Select({"select count(*) from phonelog"})
    public abstract long phoneLogCount();
}
