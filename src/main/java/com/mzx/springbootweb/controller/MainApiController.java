package com.mzx.springbootweb.controller;


import com.mzx.springbootweb.entity.User;
import com.mzx.springbootweb.entity.UserLog;
import com.mzx.springbootweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

//接口控制器
//RestController 标注类 所有return都为json数据，结合@ResponseBody与@Controller功能
@RestController
public class MainApiController {

    @Autowired
    UserMapper userMapper;

    //登陆请求

    /**
     *
     * 接口地址：/login
     * @param request ServletRequest对象，获取session域中数据
     * @param userName 获取页面input中name="userName"数据
     * @param passWord 获取页面input中name="passWord"数据
     * @return
     */
    @RequestMapping(value = {"/login"})
    public Map<String,Object> login(HttpServletRequest request,String userName,String passWord){
        Map<String,Object> map = new HashMap<>();
        map.put("state",Integer.valueOf(500));

        if (("root".equals(userName)) && ("root".equals(passWord))){
            request.getSession().setAttribute("user","1");
            map.put("state",Integer.valueOf(200));
        }
        return map;
    }

    //查询接口
    @RequestMapping(value = {"/findAllUser"})
    public Map<String,Object> findAllUser(HttpServletRequest request, @RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10")int limit){
        Map<String,Object> map = new HashMap<>();

        //设置简单反爬，python请求头 或 访问速度过快 提示页面访问过于频繁
        Object visitDate = request.getSession().getAttribute("visitDate");
        // 访问速度过快(请求速度不能超过500毫秒)
        if (visitDate == null){
            long time = System.currentTimeMillis();
            request.getSession().setAttribute("visitDate",Long.valueOf(time));
        }else {
            long time = ((Long) request.getSession().getAttribute("visitDate")).longValue();
            long nowSecond = System.currentTimeMillis();
            long timelen = nowSecond - time;
            if (timelen < 500L){
                map.put("msg", "Web page visits are too frequent");
                return map;
            }
        }
        //请求头为Python
        String header = request.getHeader("User-Agent");
        if (header.contains("python")){
            map.put("msg", "Web page visits are too frequent");
            return map;
        }

        //请求单页数据超过30条
        if (limit > 30){
            map.put("msg", "Web page visits are too frequent");
            return map;
        }

        /**
         * sql 中 LIMIT 后的第一个参数是输出记录的初始位置，第二个参数偏移量
         */
        //limit： startLine 比如第二页 (2 - 1) * 10 = 第十行数据  limit
        int startLine = (page - 1) * limit;
        // count:统计所有数据数量
        long l = this.userMapper.phoneLogCount();
        List<User> allUser = this.userMapper.getAllPhoneLog(startLine,limit);
        List list = new ArrayList();
        map.put("code",Integer.valueOf(0));
        map.put("msg","");
        map.put("count",Long.valueOf(l));
        //若为偶数页添加dataA、dataB数据字段
        if (page % 2 == 0){
            UserLog userLog = new UserLog();
            for (User user:allUser) {
                userLog.setUserLog(user.getId(),user.getUserA(),user.getUserB(),user.getStartTime()
                ,user.getEndTime(),user.getAddressCodeA(),user.getAddressCodeB(),
                        UUID.randomUUID().toString(),UUID.randomUUID().toString());
                list.add(userLog);
            }
            map.put("data",list);
            return map;
        }
        map.put("data",allUser);
        return map;
    }
    
}
