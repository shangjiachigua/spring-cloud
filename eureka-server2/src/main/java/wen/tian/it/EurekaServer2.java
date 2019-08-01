package wen.tian.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author tianwenwen
 * @date 2019/7/30 22:55
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer2 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer2.class);
    }
}
