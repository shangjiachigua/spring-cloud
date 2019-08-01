package wen.tian.it.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author tianwenwen
 * @date 2019/7/30 10:07
 **/
@Data
@Table(name = "users")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private String id;
    private String userAccount;
    private String userPassword;
    private String telephone;
    private String userPic;
    private Date createAt;
//    省略get和set
}
