package wen.tian.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author tianwenwen
 * @date 2019/7/30 10:09
 **/
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("wen.tian.it.mapper")
public class UserApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication2.class);
    }
}
