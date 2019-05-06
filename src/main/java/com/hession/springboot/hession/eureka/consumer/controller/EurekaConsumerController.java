package com.hession.springboot.hession.eureka.consumer.controller;


import com.hession.springboot.hession.eureka.consumer.client.HessionClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class EurekaConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HessionClientApi hessionClientApi;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    /**
     * Rest服务端使用RestTemplate发起http请求,然后得到数据返回给前端----gotoUser是为了区分getUser怕小伙伴晕头
     * @param id
     * @return
     */
    @GetMapping(value = "/gotoUser")
    @ResponseBody
    public Map<String,Object> getUser(@RequestParam Integer id){
        /**
         * 小伙伴发现没有，地址居然是http://service-provider
         * 因为他向注册中心注册了服务，服务名称service-provider,我们访问service-provider即可
         */
        Map<String,Object> data;

            // data= restTemplate.getForObject("http://hession-eureka-client-provider/getUser?id="+id,Map.class);
       data= hessionClientApi.getUser(id);

        return data;
    }

}
