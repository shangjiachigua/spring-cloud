package wen.tian.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wen.tian.it.pojo.User;
import wen.tian.it.service.UserService;

/**
 * @author tianwenwen
 * @date 2019/7/25 21:16
 **/
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{id}")
    public User hello(@PathVariable("id") long id){
        return userService.getUser(id);
    }
}
