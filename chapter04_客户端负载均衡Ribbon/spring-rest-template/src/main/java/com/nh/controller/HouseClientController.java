package com.nh.controller;

import com.nh.bean.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HouseClientController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/call/data")
    public HouseInfo getData(@RequestParam("name") String name){
        return restTemplate.getForObject("http://localhost:8081/house/data?name="+name,HouseInfo.class);
    }
    @GetMapping("/call/data/{name}")
    public String getData2(@PathVariable("name") String name){
        return restTemplate.getForObject("http://localhost:8081/house/data/{name}",String.class,name);
    }
    @GetMapping("/call/save")
    public Long add(){
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setProvince("上海");
        houseInfo.setBlock("虹口");
        houseInfo.setStreet("xxxx");
        Long id = restTemplate.postForObject("http://localhost:8081/house/save",houseInfo,Long.class);
        return id;
    }
}
