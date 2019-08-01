package wen.tian.it.web;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wen.tian.it.clients.UserClient;

/**
 * @author tianwenwen
 * @date 2019/7/30 11:38
 **/
@RestController
@RequestMapping("consumer")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback1")
public class Consumer {
    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    //关于服务降级 一些说的高大上其实也就那么回事
    //简单来说就是本来服务会正常返回数据但是现在服务出现问题无法返回正确数据，提醒用户服务器异常，此时就是
    //服务降级。也就是服务失去了原来的能力。
    //配置超时时长
    /*@HystrixCommand(commandProperties = {@HystrixProperty(name
            = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")})*/
    //配置熔断 测试
    //实际开发使用默认配置
    //requestVolumeThreshold 配置触发熔断的最小请求次数 默认为20
    //sleepWindowInMilliseconds 休眠时长 默认为5000毫秒
    //errorThresholdPercentage 出发熔断的失败请求最小占比 默认为50%
    //触发熔断的条件是当最近20次请求中有百分之50都是失败请求
    //熔断器打开之后所有请求返回失败
    //熔断器打开之后开始计时5秒，5秒之后进入半开状态。
    //半开状态，放行部分请求，如果请求依然失败，再进入打开状态，以此循环
    //直到请求成功，熔断器关闭
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            }
                    )
    public String selectUser(@PathVariable("id") long id) {
        return userClient.selectUser(id);
    }

    public String selectUserFallbackMethod(@PathVariable("id") long id) {
        return "服务器太拥挤了";
    }

    public String defaultFallback1() {
        return "不好意思，服务器太拥挤了";
    }
}
