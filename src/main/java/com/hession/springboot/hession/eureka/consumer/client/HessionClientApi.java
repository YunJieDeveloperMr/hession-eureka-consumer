package com.hession.springboot.hession.eureka.consumer.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 使用Feign方式远程调用其他服务接口
 *
 * Ps. 调用hession-eureka-client服务接口
 */

@FeignClient(name = "hession-eureka-client-provider")
@RibbonClient
public interface HessionClientApi {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
        //@RequestParam("id")注解必须配置,否则对方服务无法识别参数,报405
    Map<String, Object> getUser(@RequestParam("id") Integer id);


}
