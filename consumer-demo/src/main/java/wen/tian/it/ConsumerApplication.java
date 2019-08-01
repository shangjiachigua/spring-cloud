package wen.tian.it;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tianwenwen
 * @date 2019/7/30 11:21
 **/
/*//eureka客户端注解
@EnableDiscoveryClient
@SpringBootApplication
//hystrix 服务降级和熔断注解
@EnableCircuitBreaker*/
//feign注解
@EnableFeignClients
@SpringCloudApplication

public class ConsumerApplication {
    //使用feign组件，不再需要RestTemplate类
   /* @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }
}

