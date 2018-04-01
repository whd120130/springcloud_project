package com.whd.service;

import com.whd.model.User;
import org.springframework.stereotype.Component;

/**
 * userService 为用户提供服务
 */
@Component
public class UserService {

    /**
     * 根据ID查询信息
     * @param id
     * @return
     */
    public User getUserById(Integer id){
        User user = new User();
        user.setAge(12);
        user.setId(1);
        user.setUserName("wanghuidong");
        user.setSex("男");
        return user;
    }
}
