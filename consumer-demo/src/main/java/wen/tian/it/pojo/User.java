package wen.tian.it.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author tianwenwen
 * @date 2019/7/30 10:07
 **/
@Data
public class User {
    private String id;
    private String userAccount;
    private String userPassword;
    private String telephone;
    private String userPic;
    private Date createAt;
//    省略get和set
}
