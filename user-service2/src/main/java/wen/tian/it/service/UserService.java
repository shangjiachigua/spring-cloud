package wen.tian.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wen.tian.it.mapper.UserMapper;
import wen.tian.it.pojo.User;

/**
 * @author tianwenwen
 * @date 2019/7/25 23:26
 **/
@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public User getUser(long id){
        return userMapper.selectByPrimaryKey(id);
    }
    /*springboot 事务
    * */
    /*@Transactional
    public void insertUser(User user) {
        userMapper.insert(user);
    }*/
}
