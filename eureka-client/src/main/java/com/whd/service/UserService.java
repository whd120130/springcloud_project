package com.whd.service;


import com.whd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class UserService {

    @Autowired
    private RestTemplate template;
    /**
     *
     * @param id
     * @return
     */
    public User getUserById(Integer id){
        return (User) template.getForObject("http://user-service/getUserByIdAll",User.class);
    }
}
