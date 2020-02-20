package com.nh.controller;

import com.nh.bean.HouseInfo;
import org.springframework.web.bind.annotation.*;

@RestController
public class HouseController {
    @GetMapping("/house/data")
    public HouseInfo getData(@RequestParam("name") String name){
        return new HouseInfo(1L,"上海","虹口","东体小区");
    }
    @GetMapping("/house/data/{name}")
    public String getData2(@PathVariable("name") String name){
        return name;
    }

    @RequestMapping("/house/save")
    public Long adData(@RequestBody HouseInfo houseInfo){
        System.out.println(houseInfo.getStreet());
        return 1001L;
    }
}
